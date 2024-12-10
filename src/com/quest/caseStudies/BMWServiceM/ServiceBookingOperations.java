package com.quest.caseStudies.BMWServiceM;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ServiceBookingOperations<K extends Customer,V extends ServiceBooking> implements Serializable {
    Map<K, List<V>> bookings;
    VehicleOperations vOp=new VehicleOperations();

    public ServiceBookingOperations() {
        this.bookings = new HashMap<>();
    }

    public void addServiceBooking(K customer, V serviceBooking) throws InvalidBookingException {
        if(bookings.containsKey(customer)){
            for (V existingBooking : bookings.get(customer)){
                if (existingBooking.getBookingId().equals(serviceBooking.getBookingId())) {
                    throw new InvalidBookingException("Booking ID already exists: ");
                }
            }
            if (serviceBooking.getServiceDate().isBefore(LocalDateTime.now())) {
                throw new InvalidBookingException("Service date cannot be in the past: ");
            }
            double discount=getDiscount.apply(customer);
            if(discount>0.00){
                try{
                    V discountedBooking = (V) serviceBooking.clone();
                    double discountedPrice = discountedBooking.getCost() * discount;
                    discountedBooking.setCost(discountedBooking.getCost() - discountedPrice);
                    bookings.get(customer).add(discountedBooking);
                } catch (CloneNotSupportedException e) {
                    throw new RuntimeException(e);
                }
            }
            bookings.get(customer).add(serviceBooking);
        }
        else{
            bookings.put(customer,new ArrayList<>());
            bookings.get(customer).add(serviceBooking);
        }
        System.out.println("Booking added");
    }


    public List<V> getServiceBookingsForCustomer(K customer) {
        return bookings.getOrDefault(customer, new ArrayList<>());
    }


    public void displayAllBookings() {
        for (Map.Entry<K, List<V>> entry : bookings.entrySet()) {
            System.out.println("Customer: " + entry.getKey().toString());
            for (V booking : entry.getValue()) {
                System.out.println(booking);
            }
        }
    }
    public ServiceBooking findBooking(String bookingId){
        for (Map.Entry<K, List<V>> entry : bookings.entrySet()) {
            System.out.println("Customer: " + entry.getKey().toString());
            for (V booking : entry.getValue()) {
                if(booking.getBookingId().equalsIgnoreCase(bookingId)){
                    return booking;
                }
            }
        }
        return null;
    }
    public Customer findCustomer(String cid){
        for (Map.Entry<K, List<V>> entry : bookings.entrySet()) {
            if(entry.getKey().getCustomerId().equalsIgnoreCase(cid)){
                return entry.getKey();
            }
        }
        return null;
    }

    Predicate<V> isScheduledInAWeek=booking->booking.getServiceDate()
            .isAfter(LocalDateTime.now()) &&
            booking.getServiceDate().isBefore(LocalDateTime.now().plusDays(7));

    Consumer<K> invoice=customer->{
        System.out.println(bookings.get(customer).toString());
    };
    Function<K,Double> getDiscount=customer->{
        if(bookings.get(customer).size()>3){
            return 0.15;
        }
        return 0.00;
    };
    Supplier<ServiceBooking> randomBooking=()->{
        Random rand=new Random();
        Vehicle vehicle=vOp.randomVehicleSupplier.get();
        Customer customer=new Customer(
                "cId"+rand.nextInt(1000),
                "customer"+rand.nextInt(1000),
                "email@"+rand.nextInt(1000),
                vehicle
        );
        return new ServiceBooking(
                "id"+rand.nextInt(1000),
                customer,
                LocalDateTime.now(),
                "Wash"+rand.nextInt(1000),
                rand.nextDouble()*1000
        );

    };

    private final String BOOKING_DATA_FILE="serviceData.ser";

    public String getBOOKING_DATA_FILE() {
        return BOOKING_DATA_FILE;
    }

    public void SerializeBookingData()
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BOOKING_DATA_FILE))) {
            oos.writeObject(bookings);
            System.out.println("Data serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<K,V> DeserializeBookingData() {
        Map<K,V> bookingData = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(BOOKING_DATA_FILE))) {
            bookingData = (Map<K,V>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bookingData;
    }

    private final String REPORT_DATA_FILE="serviceReports.txt";

    public void CreateServiceReport() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(REPORT_DATA_FILE))) {


            writer.write("Service Report - Vehicle Maintenance");
            writer.newLine();
            writer.write("Date: " + java.time.LocalDate.now());
            writer.newLine();

            double totalRevenue = 0;
            int totalCount = 0;

            for (Map.Entry<K, List<V>> entry : bookings.entrySet()) {
                List<V> services = entry.getValue();
                totalCount += services.size();
                for (ServiceBooking service : services) {
                    totalRevenue += service.getCost();
                }
            }

            writer.write("Total Revenue: $" + totalRevenue);
            writer.newLine();
            writer.write("Total Count of Services: " + totalCount);
            writer.newLine();

            writer.flush();

            System.out.println("Service report created successfully!");

        } catch (IOException e) {
            System.err.println("An error occurred while writing the service report: " + e.getMessage());
        }
    }

    public void readServiceReport() {
        try (BufferedReader reader = new BufferedReader(new FileReader(REPORT_DATA_FILE))) {
            System.out.println("Reading Service Report:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("The report file does not exist: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("An error occurred while reading the report file: " + e.getMessage());
        }
    }

}
