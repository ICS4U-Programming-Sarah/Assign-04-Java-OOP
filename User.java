import java.util.ArrayList;
import java.util.List;

/**
 * This program contains the Song.
 * class. All classes reference from
 * ChatGPT>
 *
 * @author  Sarah Andrew
 * @version 1.0
 *
 * @since 2023-02-05.
 */

public class User {
    // Declaring instance.
    private List<Song> songs;
    String _name;

    // Creates constructor.
    public User(String name) {
        this._name = name;
        this.songs = new ArrayList<>();
    }

    // Method for adding song to playlist.
    public void addSong(Song song) {
            // Adding new song.
            songs.add(song);
            // Display to user song has been added.
            System.out.println("Song has been added!");
    }

}
