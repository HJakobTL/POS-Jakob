package est.end.Playlist;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class PlaylistManager {

    private ArrayList<Song> playlist;

    public PlaylistManager() {
        this.playlist = new ArrayList<>();
    }

    public Song songHinzufuegen(Song song){
        if (song == null){
            throw new IllegalArgumentException("song nicht null sein");
        }
        playlist.add(song);
        return song;
    }

    public ArrayList<Song> filterGenre(String genre){
        ArrayList<Song> filteredSonges = new ArrayList<>();
        if (genre == null) throw new IllegalArgumentException("Genre kann nicht null sein");
        for (Song song : playlist) {
            if (Objects.equals(song.getGenre(), genre)) {
                filteredSonges.add(song);
            }
        }
        return filteredSonges;
    }

    public void shufflePlaylist() {
        ArrayList<Song> shuffeled = new ArrayList<>();
        for (int i = 0; i < playlist.size(); i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 4);
            shuffeled.add(playlist.get(randomNum));
        }
        playlist = shuffeled;
    }

    public void removeDuplicat(Song song) {
        while(playlist.contains(song)){
            playlist.remove(song);
        }
        playlist.add(song);
    }


    @Override
    public String toString() {
        return "PlaylistManager{" +
                "playlist=" + playlist +
                '}';
    }
}
