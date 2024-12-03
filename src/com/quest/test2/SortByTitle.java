package com.quest.test2;

import java.util.Comparator;

public class SortByTitle implements Comparator<MusicTrack> {

    @Override
    public int compare(MusicTrack o1, MusicTrack o2) {
        String s1 = o1.getTrackName();
        String s2 = o2.getTrackName();
        return s1.compareToIgnoreCase(s2);

    }
}
