package com.quest.test2;

import java.util.ArrayList;
import java.util.List;


public class PlaylistManagement {

    private List<Playlist> allPlaylists;

    public PlaylistManagement() {
        this.allPlaylists = new ArrayList<>();
    }

    public List<Playlist> getAllPlaylists() {
        return allPlaylists;
    }

    public void addPlaylist(Playlist playlist) {
        if (findPlaylist(playlist.getPlaylistName()) != null) {
            throw new DuplicateException("Playlist already exists");
        }
        allPlaylists.add(playlist);
        System.out.println("Playlist '" + playlist.getPlaylistName() + "' added.");
    }


    public void removePlaylist(String playlistName) {
        Playlist playlist = findPlaylist(playlistName);
        if (playlist != null) {
            allPlaylists.remove(playlist);
            System.out.println("Playlist '" + playlistName + "' removed.");
        } else {
            throw new IllegalArgumentException("Playlist not found.");
        }
    }


    private Playlist findPlaylist(String playlistName) {
        for (Playlist playlist : allPlaylists) {
            if (playlist.getPlaylistName().equals(playlistName)) {
                return playlist;
            }
        }
        return null;
    }

    public void displayAllPlaylists() {
        if (allPlaylists.isEmpty()) {
            System.out.println("No playlists available.");
        } else {
            for (Playlist playlist : allPlaylists) {
                System.out.println(playlist.toString());
            }
        }
    }

}
