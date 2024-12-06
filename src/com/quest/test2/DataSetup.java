package com.quest.test2;

public class DataSetup {

    public static void setupSampleData(UserManagement userManager) {
        // Create users
        User user1 = new User("alice");
        User user2 = new User("bob");

        // Add users to the UserManagement system
        userManager.addUser(user1);
        userManager.addUser(user2);

        // Create playlists
        Playlist playlist1 = new Playlist("pop");
        Playlist playlist2 = new Playlist("rock");
        Playlist playlist3 = new Playlist("jazz");

        user1.createPlaylist(playlist1);
        user1.createPlaylist(playlist2);
        user2.createPlaylist(playlist3);

        // Add tracks to playlists
        MusicTrack track1 = new MusicTrack(1, "Shape of You", "Ed Sheeran", 3.5);
        MusicTrack track2 = new MusicTrack(2, "Bohemian Rhapsody", "Queen", 5.9);
        MusicTrack track3 = new MusicTrack(3, "Stairway to Heaven", "Led Zeppelin", 8.0);
        MusicTrack track4 = new MusicTrack(4, "Take Five", "Dave Brubeck", 5.3);
        MusicTrack track5 = new MusicTrack(5, "Blinding Lights", "The Weeknd", 4.2);
        MusicTrack track6 = new MusicTrack(6, "Levitating", "Dua Lipa", 3.0);
        MusicTrack track7 = new MusicTrack(7, "Uptown Funk", "Mark Ronson ft. Bruno Mars", 4.5);
        MusicTrack track8 = new MusicTrack(8, "Rolling in the Deep", "Adele", 3.5);
        MusicTrack track9 = new MusicTrack(9, "Hotel California", "The Eagles", 6.3);
        MusicTrack track10 = new MusicTrack(10, "Imagine", "John Lennon", 3.1);
        MusicTrack track11 = new MusicTrack(11, "Smells Like Teen Spirit", "Nirvana", 5.1);
        MusicTrack track12 = new MusicTrack(12, "Sweet Child O' Mine", "Guns N' Roses", 5.5);
        MusicTrack track13 = new MusicTrack(13, "What a Wonderful World", "Louis Armstrong", 2.4);
        MusicTrack track14 = new MusicTrack(14, "Take the A Train", "Duke Ellington", 3.0);
        MusicTrack track15 = new MusicTrack(15, "All of Me", "John Legend", 4.5);
        MusicTrack track16 = new MusicTrack(16, "Respect", "Aretha Franklin", 2.9);

        // Add tracks to the playlists
        user1.addToplaylist(track1, playlist1);
        user1.addToplaylist(track5, playlist1);
        user1.addToplaylist(track6, playlist1);
        user1.addToplaylist(track7, playlist1);
        user1.addToplaylist(track8, playlist1);

        user1.addToplaylist(track2, playlist2);
        user1.addToplaylist(track3, playlist2);
        user1.addToplaylist(track9, playlist2);
        user1.addToplaylist(track11, playlist2);
        user1.addToplaylist(track12, playlist2);

        user2.addToplaylist(track4, playlist3);
        user2.addToplaylist(track13, playlist3);
        user2.addToplaylist(track14, playlist3);
        user2.addToplaylist(track15, playlist3);
        user2.addToplaylist(track16, playlist3);

        // Optionally display the current playlists and tracks
        System.out.println("Sample data setup complete.");
        user1.displayPlaylists(user1);
        user2.displayPlaylists(user2);
    }

}
