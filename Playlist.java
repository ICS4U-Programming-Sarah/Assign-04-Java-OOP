import java.util.Random;
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

public class Playlist {
    // Declare fields.
    boolean _isShuffle = false;
    List<Song> songs;
    Song currentSong;
    int currentIndex;
    boolean _isRepeat = false;
    

    // Create constructors,
    public Playlist() {
        this._isShuffle = false;
        this.songs = new ArrayList<>();
        this.currentSong = null;
        this.currentIndex = -1;
        this._isRepeat = false;
    }

    // Declare method.
    public void setShuffle(boolean isShuffle) {
        _isShuffle = isShuffle;
        // If statement to see if it's true
        // or false.
        if (isShuffle) {
            shufflePlaylist();
        }
    }

    // Define method.
    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    // Defining method.
    public void setRepeat(boolean repeat) {
        _isRepeat = repeat;
    }
    // Defining method for repeating song.
    public void repeatCurrentSong() {
        // If statement to repeat current
        // song.
        if (!songs.isEmpty()) {
            playCurrentSong();
        }
    }

    // Method to skip forward to the next song
    public void skipForward() {
        if (!songs.isEmpty()) {
            currentIndex++; // Increment the current index
            // Check if the current index is within the valid range of songs
            if (currentIndex >= 0 && currentIndex < songs.size()) {
                playCurrentSong(); // Play the new current song
            } else {
                System.out.println("End of playlist reached.");
                currentIndex = songs.size() - 1; // Set the current index to the last song
            }
    } else {
        System.out.println("No songs in the playlist.");
    }
}

    // Method for playing current song.
    public void playSong() {
        // Usage of if statement to play current song.
        if (currentIndex >= 0 && currentIndex < songs.size()) {
            Song currentSong = songs.get(currentIndex);
            System.out.println("Now playing...");
            System.out.println("Title: " + currentSong.getTitle());
            System.out.println("Artist: " + currentSong.getArtist());
            System.out.println("Duration: "
                + currentSong.getDuration() + " seconds");
            System.out.println();
        } else {
            System.out.println("No song is currently playing.");
        }
    }

    // Define method to shuffle playlist.
    public void shufflePlaylist() {
        // If statement to shuffle playlist.
        if (!songs.isEmpty()) {
            // Declare variable.
            int length = songs.size();
            Random random = new Random();

            // Usage of loop to shuffle song,
            // iterating over last element to
            // first to generate random index.
            for (int counter = length - 1; counter > 0; counter--) {
                // Declare variable & set.
                int counter1 = random.nextInt(counter + 1);

                // Swap songs at indexes.
                Song temp = songs.get(counter);
                songs.set(counter, songs.get(counter1));
                songs.set(counter1, temp);
            }
        }
        // Resets.
        currentIndex = 0;

    }
    // Method for playing current song.
    public void playCurrentSong() {
        if (!songs.isEmpty()) {
            if (currentIndex >= 0 && currentIndex < songs.size()) {
                Song currentSong = songs.get(currentIndex);
                System.out.println("Now playing:");
                System.out.println("Title: " + currentSong.getTitle());
                System.out.println("Artist: " + currentSong.getArtist());
                System.out.println("Duration: " + currentSong.getDuration() + " seconds");
                System.out.println();
            } else {
                System.out.println("No song is currently playing.");
            }
        }
    }
}
