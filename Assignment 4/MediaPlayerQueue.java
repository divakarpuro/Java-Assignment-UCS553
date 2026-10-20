
import java.util.*;

class Song {
    String title;
    String artist;

    Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Song)) {
            return false;
        }

        Song s = (Song) obj;

        return title.equalsIgnoreCase(s.title)
                && artist.equalsIgnoreCase(s.artist);
    }

    public int hashCode() {
        return Objects.hash(title.toLowerCase(), artist.toLowerCase());
    }

    public String toString() {
        return title + " - " + artist;
    }
}

public class MediaPlayerQueue {
    LinkedList<Song> playlist = new LinkedList<>();
    LinkedList<Song> history = new LinkedList<>();

    void addSong(Song s) {
        playlist.addLast(s);
        System.out.println("Added: " + s);
    }

    void addPrioritySong(Song s) {
        playlist.addFirst(s);
        System.out.println("Priority song added: " + s);
    }

    void insertSong(int pos, Song s) {
        if (pos < 0 || pos > playlist.size()) {
            System.out.println("Invalid position.");
            return;
        }

        playlist.add(pos, s);
        System.out.println("Song inserted.");
    }

    void removeDuplicates() {
        HashSet<Song> seen = new HashSet<>();
        ListIterator<Song> it = playlist.listIterator();

        while (it.hasNext()) {
            Song s = it.next();

            if (!seen.add(s)) {
                it.remove();
            }
        }

        System.out.println("Duplicates removed.");
    }

    void playNext() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        Song s = playlist.removeFirst();
        history.addLast(s);

        System.out.println("Now playing: " + s);
    }

    void showHistory() {
        System.out.println("\nRecently played:");

        Iterator<Song> it = history.descendingIterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    void showPlaylist() {
        System.out.println("\nPlaylist:");

        for (Song s : playlist) {
            System.out.println(s);
        }
    }

    void traverseBothWays() {
        ListIterator<Song> it = playlist.listIterator();

        System.out.println("\nForward:");

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("\nBackward:");

        while (it.hasPrevious()) {
            System.out.println(it.previous());
        }
    }

    public static void main(String[] args) {
        MediaPlayerQueue p = new MediaPlayerQueue();

        p.addSong(new Song("Believer", "Imagine Dragons"));
        p.addSong(new Song("Perfect", "Ed Sheeran"));
        p.addSong(new Song("Shape of You", "Ed Sheeran"));
        p.addSong(new Song("Believer", "Imagine Dragons"));

        p.addPrioritySong(new Song("Numb", "Linkin Park"));

        p.insertSong(2, new Song("Faded", "Alan Walker"));

        p.showPlaylist();

        p.removeDuplicates();
        p.showPlaylist();

        p.traverseBothWays();

        System.out.println("\nPlaying songs:");
        p.playNext();
        p.playNext();

        p.showHistory();
    }
}
