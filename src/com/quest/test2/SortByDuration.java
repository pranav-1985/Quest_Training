package com.quest.test2;

import java.util.Comparator;

public class SortByDuration implements Comparator<MusicTrack> {

    @Override
    public int compare(MusicTrack o1, MusicTrack o2) {
        double d1 = o1.getDuration();
        double d2 = o2.getDuration();
        if (d1 > d2) {
            return 1;
        } else if (d1 < d2) {
            return -1;
        }
        return 0;
    }
}
