package com.quest.test2;


public interface UserManager {

    void createPlaylist(Playlist playlistName);

    void addToplaylist(MusicTrack music, Playlist playlistName);

    void deletePlaylist(String playlistName);

    Playlist getPlaylist(String playlistName);

    void displayPlaylists(User user);

    Playlist mergePlaylist(User user);

    //void addFavoriteTrack(Track track);

    //void displayFavoriteTracks();
}
