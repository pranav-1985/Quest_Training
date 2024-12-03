package com.quest.test2;

import javax.sound.midi.Track;

public interface MusicManager {


    void addTrack(MusicTrack track, Playlist playlist);

    void removeTrack(MusicTrack track, Playlist playlist);

    boolean findDuplicates(MusicTrack track, Playlist playlist);

    MusicTrack searchTrack(MusicTrack track, Playlist playlist);

    void displayAllTracks(Playlist playlist);

    void sortTracks(Playlist playlist);

    void shuffleTracks(Playlist playlist);

    //void addTrackRating(Track track,float rating);

    //void displayByRating(Playlist playlist);


}
