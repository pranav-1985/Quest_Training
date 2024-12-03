package com.quest.test2;

import javax.sound.midi.Track;

public interface UserManager {

    void createPlaylist(Playlist playlistName);

    void deletePlaylist(String playlistName);

    Playlist getPlaylist(String playlistName);

    void displayPlaylists(User user);

    Playlist mergePlaylist(User user);

    //void addFavoriteTrack(Track track);

    //void displayFavoriteTracks();
}
