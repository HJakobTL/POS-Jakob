package est.end.Playlist;

public class MainPlaylist {
    static void main(){

        PlaylistManager playlist1 = new PlaylistManager();
        Song s1 = new Song("Alex mein Bubu","Jakob","Rock");
        Song s2 = new Song("Meine Hoden brennen", "Julius", "Pop");
        Song s3 = new Song("Kein Song","Ben","Rock");
        Song s4 = new Song("Mein Nassler","Little Dominic","Romantic");

        playlist1.songHinzufuegen(s1);
        playlist1.songHinzufuegen(s2);
        playlist1.songHinzufuegen(s3);
        playlist1.songHinzufuegen(s4);
        /*
        playlist1.songHinzufuegen(s1);
        playlist1.songHinzufuegen(s1);
        playlist1.songHinzufuegen(s1);
        playlist1.songHinzufuegen(s2);
        playlist1.songHinzufuegen(s2);
        playlist1.songHinzufuegen(s1);
        */
        // Filter Genre new Array Test
        //System.out.println(playlist1.filterGenre(""));
        // Pre Remove
        System.out.println(playlist1);
        // s1 sollte nicht removed werden
        //playlist1.removeDuplicat(s1);
        //playlist1.removeDuplicat(s2);
        // After Remove
        System.out.println(playlist1);

        //Shuffle
        playlist1.shufflePlaylist();


    }

}
