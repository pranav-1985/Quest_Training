package com.quest.test2;

import java.util.Comparator;

public class TrackComparator {

    // sort by title
    public static Comparator<MusicTrack> sortByTitle() {
        return (track1, track2) -> track1.getTrackName().compareToIgnoreCase(track2.getTrackName());
    }

    //sort by duration
    public static Comparator<MusicTrack> sortByDuration() {
        return (track1, track2) -> Double.compare(track1.getDuration(), track2.getDuration());
    }
}

