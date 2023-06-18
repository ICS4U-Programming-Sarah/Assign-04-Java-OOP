import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;
import java.util.Random;

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
    List<Song> _songs;
    Song _currentSong;
    int currentIndex;
    boolean _isRepeat = false;
    PrintWriter _writer;

    // Create constructors,
    public Playlist(PrintWriter write) {
        this._isShuffle = false;
        this._songs = new ArrayList<>();
        this._currentSong = null;
        this.currentIndex = -1;
        this._isRepeat = false;
        this._writer = write;
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
        this._songs = songs;
        currentIndex = 0;
    }

    // Define method.
    public int getCurrentIndex() {
        return currentIndex;
    }

    // Defining method.
    public void setRepeat(boolean repeat) {
        _isRepeat = repeat;
    }
    // Defining method for repeating song.
    public void repeatCurrentSong() {
        // If statement to repeat current
        // song.
        if (!_songs.isEmpty()) {
            playCurrentSong();
        } else {
            // Displaying to console & writing to
            // file.
            System.out.println("No songs to repeat!");
            _writer.println("No songs to repeat!");
            _writer.println();
        }
    }

    // Method for pausing song.
    public void pause() {
        // If statement to pause song.
        if (!_songs.isEmpty()) {
            System.out.println("Song has been paused!");
            System.out.println();

            // Writing to file.
            _writer.println("Song has been paused!");
            _writer.println();

        } else {
            System.out.print("Seems as there's no songs to");
            System.out.println(" pause.");
            _writer.println("Seem as there's no song to "
             + " pause.");
        }
    }

    // Method for removing song.
    public void removeSong() {
        // Usage of if statement, checking line.
        if (!_songs.isEmpty()) {
            // Defining range.
            if (currentIndex >= 0 && currentIndex < _songs.size()) {
                // Reference instance.
                Song songRemove = _songs.remove(currentIndex);
                System.out.println("Removed song: " + songRemove.getTitle());
                System.out.println();
                System.out.println();
                _writer.println("Removed song: " + songRemove.getTitle());
                // Decrement counter.
                currentIndex--;
                // Defining range.
                if (currentIndex >= 0 && currentIndex < _songs.size()) {
                    // Play current song.
                    playCurrentSong();
                } else {
                    System.out.println("Removing in process!");
                    System.out.println();
                    _writer.println("Removing in process!");
                    _writer.println();
                    // Set current index to last song.
                    currentIndex = _songs.size() - 1;
                }
            } else {
                System.out.println("No song is currently playing.");
                System.out.println();
                _writer.println("No song is currently playing.");
                _writer.println();
            }
        } else {
            System.out.println("No songs in the playlist.");
            System.out.println();
            _writer.println("No songs in the playlist.");
            _writer.println();
        }
    }

    // Method to back track a song.
    public void backTrack() {
        if (!_songs.isEmpty()) {
            // Decrement current index.
            currentIndex--;
            // Check if the current index is in range of songs
            if (currentIndex >= 0 && currentIndex < _songs.size()) {
                // Calls method.
                playCurrentSong();
                System.out.println("Back track has commenced.");
                System.out.println();
                _writer.println("Back track has commenced");
                _writer.println();
            } else {
                // Display to  user & set current index to last.
                System.out.println("End of playlist reached.");
                currentIndex = _songs.size() - 1;
                System.out.println();
                _writer.println("End of playlist reached.");
            }
        } else {
            // Display to user.
            System.out.println("No songs in the playlist.");
            System.out.println();
            _writer.println("No songs in the playlist.");
        }

    }

    // Method to skip forward to the next song
    public void skipForward() {
        if (!_songs.isEmpty()) {
            // Increments current index.
            currentIndex++;
            // Check if the current index is in range of songs
            if (currentIndex >= 0 && currentIndex < _songs.size()) {
                // Calls method.
                playCurrentSong();
                System.out.println("Skipping forward has occurred.");
                System.out.println();
                _writer.println("Skipping forward has occurred.");
                _writer.println();
            } else {
                // Display to user & set current index to last.
                System.out.println("End of playlist reached.");
                currentIndex = _songs.size() - 1;
                System.out.println();
                _writer.println("Skipped forward! " +
                    " End of playlist reached.");
            }
        } else {
            System.out.println("No songs in the playlist.");
            System.out.println();
            _writer.println("No songs in the playlist.");
        }
    }

    // Method for playing current song.
    public void playSong() {
        // Usage of if statement to play current song.
        if (_currentSong != null) {
            Song currentSong = _songs.get(currentIndex);
            System.out.println("Now playing..." + currentSong.getTitle()
                + " by "
                + currentSong.getArtist()
                + " for " + currentSong.getDuration()
                + " seconds.");
            System.out.println();
            _writer.println("Now playing..." + currentSong.getTitle()
                + " by "
                + currentSong.getArtist()
                + " for " + currentSong.getDuration()
                + " seconds.");
        } else {
            System.out.println("No song is currently playing.");
            _writer.println("No song is currently playing.");
        }
    }

    // Define method to shuffle playlist.
    public void shufflePlaylist() {
        // If statement to shuffle playlist.
        if (_songs.isEmpty()) {
            System.out.println("Playlist is empty. No songs to shuffle.");
            System.out.println();
            _writer.println("Playlist is empty. No songs to shuffle.");
            // Exiting if playlist is empty.
            return;

        }
        // Declare variable.
        final int length = _songs.size();
        final Random random = new Random();

        // Usage of loop to shuffle song,
        // iterating over last element to
        // first to generate random index.
        for (int counter = length - 1; counter > 0; counter--) {
            // Declare variable & set.
            final int counter1 = random.nextInt(counter + 1);

            // Swap songs at indexes.
            final Song temp = _songs.get(counter);
            _songs.set(counter, _songs.get(counter1));
            _songs.set(counter1, temp);
        }
        // Resets.
        currentIndex = 0;
        // Play new shuffle.
        _currentSong = _songs.get(currentIndex);
        playCurrentSong();
        System.out.println("Shuffled!");
        _writer.println("Shuffled!");
        _writer.println();
        System.out.println("Now playing..."
            + _currentSong.getTitle() + " by "
            + _currentSong.getArtist()
            + " for " + _currentSong.getDuration()
            + " seconds.");
        _writer.println("Now playing..."
            + _currentSong.getTitle() + " by "
            + _currentSong.getArtist()
            + " for " + _currentSong.getDuration()
            + " seconds.");
    }
    // Method for playing current song.
    public void playCurrentSong() {
        // Checking to see if list is empty.
        if (!_songs.isEmpty()) {
            // Defining range & display to user.
            if (currentIndex >= 0 && currentIndex < _songs.size()) {
                Song currentSong = _songs.get(currentIndex);
                System.out.println("Now playing..."
                    + currentSong.getTitle() + " by "
                    + currentSong.getArtist()
                    + " for " + currentSong.getDuration()
                    + " seconds.");
                System.out.println();
                _writer.println("Now playing..."
                    + currentSong.getTitle() + " by "
                    + currentSong.getArtist()
                    + " for " + currentSong.getDuration()
                    + " seconds.");
            } else {
                System.out.println("No song is currently playing.");
                System.out.println();
                _writer.println("No song is currently playing.");
                _writer.println();
            }
        }
    }
}
