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

public class Song {
    // Creating fields.
    String _songTitle;
    String _songArtist;
    int _songDuration;

    // Create constructors.
    public Song(String songTitle, String songArtist,
            int songDuration) {
            // Referencing object.
            this._songTitle = songTitle;
            this._songArtist = songArtist;
            this._songDuration = songDuration;
    }

    // Method for playing song.
    public void play() {
        // Display to user.
        System.out.println("Now playing, " + _songTitle
                + " by " + _songArtist + " with duration of "
                + _songDuration + " seconds.");
    }
}
