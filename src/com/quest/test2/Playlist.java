package com.quest.test2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Playlist implements MusicManager {

    private String playlistName;
    private ArrayList<MusicTrack> tracks;

    public Playlist(String playlistName) {
        setPlaylistName(playlistName);
        this.tracks = new ArrayList<>();
    }

    public void setPlaylistName(String playlistName) {
        if (playlistName == null || playlistName.trim().isEmpty()) {
            throw new IllegalArgumentException("Playlist name cannot be null or empty.");
        }
        this.playlistName = playlistName.trim();
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public ArrayList<MusicTrack> getTracks() {
        return tracks;
    }

    @Override
    public String toString() {
        return String.format("Playlist-[Name: %s, Tracks: %d nos]", playlistName, tracks.size());
    }

    @Override
    public void addTrack(MusicTrack track, Playlist playlist) {
        if (findDuplicates(track)) {
            throw new DuplicateException("Track with ID " + track.getTrackId() + " already exists in the playlist.");
        }
        playlist.getTracks().add(track);
    }

    @Override
    public void removeTrack(MusicTrack track, Playlist playlist) {
        MusicTrack foundTrack = searchTrack(track, playlist);
        if (foundTrack != null) {
            playlist.getTracks().remove(foundTrack);
        } else {
            throw new IllegalArgumentException("Track with ID " + track.getTrackId() + " not found in the playlist.");
        }
    }

    @Override
    public boolean findDuplicates(MusicTrack track) {
        for (MusicTrack existingTrack : getTracks()) {
            if (existingTrack.equals(track)) {
                return true; // Duplicate found
            }
        }
        return false; // No duplicate found
    }


    @Override
    public MusicTrack searchTrack(MusicTrack track, Playlist playlist) {
        for (MusicTrack existingTrack : playlist.getTracks()) {
            if (existingTrack.equals(track)) {
                return existingTrack; // Return the found track
            }
        }
        return null;
    }

    @Override
    public void displayAllTracks(Playlist playlist) {
        if (playlist.getTracks().isEmpty()) {
            System.out.println("No tracks available in the playlist.");
        } else {
            System.out.println("Tracks in playlist '" + playlist.getPlaylistName() + "':");
            for (MusicTrack track : playlist.getTracks()) {
                System.out.println(track.toString());
            }
        }

    }

    @Override
    public void sortTracks(Playlist playlist) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Choose sorting option:" +
                "\n1. Sort by duration" +
                "\n2. Sort by title");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                // Sort by duration
                playlist.getTracks().sort(new SortByDuration());
                System.out.println("Tracks sorted by Duration.");
                break;
            case 2:
                // Sort by title
                playlist.getTracks().sort(new SortByTitle());
                System.out.println("Tracks sorted by Title.");
                break;
            default:
                System.out.println("Invalid choice. No sorting applied.");
        }

        displayAllTracks(playlist);
    }

    @Override
    public void shuffleTracks(Playlist playlist) {

        ArrayList<MusicTrack> tracks = playlist.getTracks();

        Random random = new Random();

        for (int i = tracks.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            MusicTrack temp = tracks.get(i);
            tracks.set(i, tracks.get(j));
            tracks.set(j, temp);
        }

        System.out.println("Tracks shuffled.");
        displayAllTracks(playlist);

    }

    public MusicTrack searchTrackbyName(String Trackname, Playlist playlist) {
        for (MusicTrack track : playlist.getTracks()) {
            if (track.getTrackName().equals(Trackname)) {
                return track;
            }
        }
        return null;

    }


}
