package com.quest.test2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User implements UserManager {
    private String userName;
    private Map<String, Playlist> userPlaylists;

    public User(String userName) {
        setUserName(userName);
        userPlaylists = new HashMap<>();
    }

    public String getUserName() {
        return userName;
    }

    public Map<String, Playlist> getUserPlaylists() {
        return userPlaylists;
    }

    public void setUserName(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be null or empty.");
        }
        this.userName = userName.trim();
    }

    @Override
    public void createPlaylist(Playlist playlistName) {
        if (userPlaylists.containsKey(playlistName.getPlaylistName())) {
            throw new DuplicateException("Playlist already exists.");
        } else {
            userPlaylists.put(playlistName.getPlaylistName(), playlistName);
            System.out.println("Playlist '" + playlistName + "' created.");
        }
    }

    @Override
    public void addToplaylist(MusicTrack music, Playlist playlist) {
        playlist.addTrack(music, playlist);
    }

    @Override
    public void deletePlaylist(String playlistName) {
        if (userPlaylists.containsKey(playlistName)) {
            userPlaylists.remove(playlistName);
            System.out.println("Playlist '" + playlistName + "' deleted.");
        } else {
            System.out.println("Playlist with name '" + playlistName + "' does not exist.");
        }
    }

    @Override
    public Playlist getPlaylist(String playlistName) {
        if (userPlaylists.containsKey(playlistName)) {
            return userPlaylists.get(playlistName);
        } else {
            System.out.println("Playlist with name '" + playlistName + "' does not exist.");
            return null;
        }
    }

    @Override
    public void displayPlaylists(User user) {
        if (userPlaylists.isEmpty()) {
            System.out.println("No playlists found.");
        } else {
            System.out.println("Playlists for user '" + userName + "':");
            for (String playlistName : userPlaylists.keySet()) {
                System.out.println(" - " + playlistName);
            }
        }
    }

    @Override
    public Playlist mergePlaylist(User user) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the first playlist to merge:");
        String playlistName1 = sc.nextLine();
        System.out.println("Enter the name of the second playlist to merge:");
        String playlistName2 = sc.nextLine();

        Playlist playlist1 = user.getUserPlaylists().get(playlistName1);
        Playlist playlist2 = user.getUserPlaylists().get(playlistName2);


        if (playlist1 == null || playlist2 == null) {
            System.out.println("One or both of the playlists do not exist.");
            return null;
        }

        String mergedPlaylistName = playlistName1 + " & " + playlistName2 + "(Merged)";
        Playlist mergedPlaylist = new Playlist(mergedPlaylistName);


        mergedPlaylist.getTracks().addAll(playlist1.getTracks());
        mergedPlaylist.getTracks().addAll(playlist2.getTracks());


        user.getUserPlaylists().put(mergedPlaylistName, mergedPlaylist);

        System.out.println("Playlists merged successfully! New playlist created: " + mergedPlaylistName);

        return mergedPlaylist;
    }


    @Override
    public String toString() {
        return String.format("User-[Username: %s, Playlists: %d]", userName, userPlaylists.size());
    }

}
