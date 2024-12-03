package com.quest.test2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManagement userManager = new UserManagement();

        while (true) {
            System.out.println("\nChoose an action:" +
                    "\n1. Create User" +
                    "\n2. Add Playlist" +
                    "\n3. Add Track to Playlist" +
                    "\n4. Remove Track from Playlist" +
                    "\n5. Display Tracks in Playlist" +
                    "\n6. Sort Tracks" +
                    "\n7. Shuffle Tracks" +
                    "\n8. Merge Playlists" +
                    "\n9. Exit");

            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.println("Enter username: ");
                        String userName = scanner.next();
                        userManager.addUser(new User(userName));
                        System.out.println("User created successfully.");
                    } catch (IllegalArgumentException | InputMismatchException | DuplicateException e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:

                    try {
                        System.out.println("Enter username: ");
                        String userName = scanner.next();
                        User user = userManager.getUser(userName);
                        if (user != null) {
                            System.out.println("Enter playlist name: ");
                            String playlistName = scanner.next();
                            Playlist playlist = user.getPlaylist(playlistName);
                            user.createPlaylist(playlist);
                            System.out.println("Playlist '" + playlistName + "' created.");
                        } else {
                            System.out.println("User not found.");
                        }
                    } catch (IllegalArgumentException | InputMismatchException | DuplicateException e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    //add track
                    try {
                        System.out.println("Enter username: ");
                        String userName = scanner.next();
                        User user = userManager.getUser(userName);
                        if (user != null) {
                            System.out.println("Enter playlist name: ");
                            String playlistName = scanner.next();
                            Playlist playlist = user.getPlaylist(playlistName);
                            if (playlist != null) {
                                System.out.println("Enter track id: ");
                                int trackId = scanner.nextInt();
                                System.out.println("Enter track name: ");
                                String trackName = scanner.next();
                                System.out.println("Enter Track artist");
                                String trackAuthor = scanner.next();
                                System.out.println("Enter track duration: ");
                                int duration = scanner.nextInt();
                                MusicTrack track = new MusicTrack(trackId, trackName, trackAuthor, duration);
                                Playlist newplay = new Playlist(trackName);
                                newplay.addTrack(track, newplay);
                                try {
                                    user.createPlaylist(newplay);
                                    System.out.println("Track '" + trackName + "' added to playlist.");
                                } catch (DuplicateException | InputMismatchException | IllegalArgumentException e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                            } else {
                                System.out.println("Playlist not found.");
                            }
                        } else {
                            System.out.println("User not found.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid number for duration.");
                        scanner.next();  // Clear invalid input
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    //remove Track
                    try {
                        System.out.println("Enter username: ");
                        String userName = scanner.next();
                        User user = userManager.getUser(userName);
                        if (user != null) {
                            System.out.println("Enter playlist name: ");
                            String playlistName = scanner.next();
                            Playlist playlist = user.getPlaylist(playlistName);
                            if (playlist != null) {
                                System.out.println("Enter track name: ");
                                String trackName = scanner.next();
                                MusicTrack music = playlist.searchTrackbyName(trackName, playlist);
                                try {
                                    playlist.removeTrack(music, playlist);
                                    System.out.println("Track '" + trackName + "' removed from playlist.");
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                            } else {
                                System.out.println("Playlist not found.");
                            }
                        } else {
                            System.out.println("User not found.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    // Display Tracks in Playlist
                    try {
                        System.out.println("Enter username: ");
                        String userName = scanner.next();
                        User user = userManager.getUser(userName);
                        if (user != null) {
                            System.out.println("Enter playlist name: ");
                            String playlistName = scanner.next();
                            Playlist playlist = user.getPlaylist(playlistName);
                            if (playlist != null) {
                                System.out.println(playlist);
                            } else {
                                System.out.println("Playlist not found.");
                            }
                        } else {
                            System.out.println("User not found.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 6:
                    // Sort Tracks
                    try {
                        System.out.println("Enter username: ");
                        String userName = scanner.next();
                        User user = userManager.getUser(userName);
                        if (user != null) {
                            System.out.println("Enter playlist name: ");
                            String playlistName = scanner.next();
                            Playlist playlist = user.getPlaylist(playlistName);
                            if (playlist != null) {
                                playlist.sortTracks(playlist);
                            } else {
                                System.out.println("Playlist not found.");
                            }
                        } else {
                            System.out.println("User not found.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 7:
                    // Shuffle Tracks
                    try {
                        System.out.println("Enter username: ");
                        String userName = scanner.next();
                        User user = userManager.getUser(userName);
                        if (user != null) {
                            System.out.println("Enter playlist name: ");
                            String playlistName = scanner.next();
                            Playlist playlist = user.getPlaylist(playlistName);
                            if (playlist != null) {
                                playlist.shuffleTracks(playlist);
                            } else {
                                System.out.println("Playlist not found.");
                            }
                        } else {
                            System.out.println("User not found.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 8:
                    // Merge Playlists
                    try {
                        System.out.println("Enter username: ");
                        String userName = scanner.next();
                        User user = userManager.getUser(userName);
                        if (user != null) {
                            user.mergePlaylist(user);
                        } else {
                            System.out.println("User not found.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 9:
                    // Exit
                    System.out.println("Exiting the program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
