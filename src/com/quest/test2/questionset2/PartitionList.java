package com.quest.test2.questionset2;


import java.util.ArrayList;
import java.util.List;

public class PartitionList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);//input data
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int partitionSize = 2; //change partition size as needed

        List<List<Integer>> result = partitionList(list, partitionSize);

        System.out.println(result);
    }

    public static List<List<Integer>> partitionList(List<Integer> list, int n) {

        List<List<Integer>> result = new ArrayList<>();

        int size = list.size();

        for (int i = 0; i < size; i = i + n) {// i skips the number of partition need
            List<Integer> partition = new ArrayList<>();

            for (int j = i; j < i + n && j < size; j++) {// j starts from i and ends at partition
                partition.add(list.get(j)); //new list for sub lists
            }

            result.add(partition);//add sublists to main list
        }

        return result;
    }
}
