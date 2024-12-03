package com.quest.test2;

public class MusicTrack {
    private int trackId;
    private String trackName;
    private String artist;
    private double duration;

    public MusicTrack(int trackId, String trackName, String artist, double duration) {
        setTrackId(trackId);
        setTrackName(trackName);
        setArtist(artist);
        setDuration(duration);
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        if (trackId <= 0) {
            throw new IllegalArgumentException("Track ID must be positive.");
        }
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        if (trackName == null || trackName.trim().isEmpty()) {
            throw new IllegalArgumentException("Track name cannot be null or empty.");
        }
        this.trackName = trackName.trim();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        if (artist == null || artist.trim().isEmpty()) {
            throw new IllegalArgumentException("Artist name cannot be null or empty.");
        }
        this.artist = artist.trim();
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        if (duration <= 0) {
            throw new IllegalArgumentException("Duration must be greater than zero.");
        }
        this.duration = duration;
    }

    @Override
    public String toString() {
        return String.format("Track-[ID: %d, Name: %s, Artist: %s, Duration: %.2f mins]",
                trackId, trackName, artist, duration);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Same object
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Null or different class
        }
        MusicTrack otherTrack = (MusicTrack) obj;
        return this.trackId == otherTrack.trackId; // Compare based on trackId
    }

    @Override
    public int hashCode() {
        return getTrackId(); // use trackId as the hash code
    }
}
