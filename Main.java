import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This program contains the main
 * class. Referenced from video.
 *
 * @author  Sarah Andrew
 * @version 1.0
 *
 * @since 2023-02-05.
 */

public class Main {
    public static void main(String[] args) {
        // Pass path to file as parameter.
        final File file = new File("input.txt");
        final File fileOut = new File("output.txt");

        // Usage of try catch to detect errors.
        try {
            // Create FileWriter object to write to file.
            final FileWriter fW = new FileWriter(fileOut);
            // Create Scanner object to read from file.
            final Scanner sc = new Scanner(file);
            // Create PrintWriter object to write to file.
            final PrintWriter write = new PrintWriter(fW);

            while (sc.hasNextLine()) {
                // Read line as string.
                final String newLine = sc.nextLine();

                // In case of user entering empty line,
                // display no strings found.
                if (newLine.equals("")) {
                    System.out.println("No data found on line.");
                    continue;
                }

                // Declare array & variable.
                final String[] dataPlaylist = newLine.split(" ");
                String songTitle = "";
                String songArtist = "";
                int songDuration = 0;

                // Create new instance.

                // Checking if line contains all element.
                if (dataPlaylist.length == 3) {
                    // Set at specified index.
                    songTitle = dataPlaylist[0];
                    songArtist = dataPlaylist[1];
                    songDuration = Integer.parseInt(dataPlaylist[2]);
                }

                // Creating instance.
                Song song = new Song(songTitle, songArtist, songDuration);

                // Creating new instance.
                User user = new User("Sandy");

                // Call method, add song within playlist class.
                user.addSong(song);

                // Display to user.
                System.out.println("Title: " + songTitle);
                System.out.println("Artist: " + songArtist);
                System.out.println("Duration: " + songDuration);

                // Create scanner object to read input & declare variable.
                Scanner userInput = new Scanner(System.in);
                int userChoice = 0;

                // Usage of loop to execute the many options.
                do {
                    // Display choices to user.
                    System.out.print("Here are the choices you may");
                    System.out.println(" execute on playlist!");
                    System.out.println("01 | Play song.");
                    System.out.println("02 | Shuffling song.");
                    System.out.println("03 | Repeat song.");
                    System.out.println("04 | Skip forward.");
                    System.out.println("05 | Backtrack song.");
                    System.out.println("06 | Remove track.");
                    System.out.println("07 | Add song.");

                    // Display to user.
                    System.out.print("Enter your choice: ");
                    System.out.println();

                    try {
                        // Receive user input & parse input.
                        userChoice = Integer.parseInt(userInput.nextLine());
    
                        // If statement to execute said options.
                        if (userChoice == 1) {
                            song.play();
                        } else if (userChoice == 7) {
                            // If user would like to add song, 
                            // assuming valid input.
                            System.out.print("Enter song details ");
                            System.out.println("(title, artist, duration): ");

                            // Declare variable.
                            String songInfo = userInput.nextLine();

                            // Split by spaces.
                            String[] songData = songInfo.split(", ");

                            // Checking to see if it contains all elements.
                            if (songData.length == 3) {
                                songTitle = songData[0];
                                songArtist = songData[1];
                                songDuration = Integer.parseInt(songData[2]);

                                // Reference instance.
                                Song newSong = 
                                        new Song(songTitle, songArtist, songDuration);
                                // Add song.
                                user.addSong(newSong);
                                System.out.println("New song has been added to playlist!");
                                System.out.println();

                                // Display current playlist.
                                System.out.println("Title: " + songTitle);
                                System.out.println("Artist: " + songArtist);
                                System.out.println("Duration: " + songDuration);
                                System.out.println();
                            } else {
                                System.out.print("Invalid details, song has not");
                                System.out.println(" been added.");
                            }
                        }
                        else {
                            System.out.println("Invalid, please choose either or option.");
                        }

                    } catch (NumberFormatException E) {
                        System.out.println("Please enter valid input");
                    }
                    
                } while (userChoice != 0);
                userInput.close();
            }

            // Closes scanner & writer.
            sc.close();
        } catch (IOException error) {
            // Displays error to user.
            System.out.println("An error occurred: "
                    + error.getMessage());
        }
    }
}

