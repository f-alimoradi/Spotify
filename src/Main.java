import fa.InvalidOperationException;
import fa.Music;
import fa.Playlist;
import fa.User;

public class Main {
    public static void main(String[] args) {
        System.out.println("***user test***");
        User ed = new User("ed", "123456789");
        User Ali = new User("Ali", "1456236885");

        System.out.println("***user test repetitive name***");
        try {
            User ali = new User("Ali", "741852963");
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("***user test short password***");
        try {
            User sib = new User("sib", "74185");
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("***music test***");
        Music shapeOfYou = new Music("shapeOfYou", ed);
        Music Azizam = new Music("Azizam", ed);

        System.out.println("***music test repetitive music***");
        try {
            Music shape = new Music("shapeOfYou", ed);
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("***music search test***");
        try {
            System.out.println(Music.Search("Azizam"));
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("***Buy Premium test***");
            try {
                Ali.buyPremium(Ali, 5);
            } catch (InvalidOperationException e) {
                System.out.println(e.getMessage());
            }

        System.out.println("***music play test***");
        shapeOfYou.play();

        System.out.println("***add playlist test***");
        Ali.createPlaylist("haha");
        Playlist playlist = Ali.getPlaylistByTitle("haha");
        System.out.println("***add music to playlist test***");
        playlist.addMusic("1456236885", "Azizam", "ed");

        System.out.println("***add music to playlist repetitive test***");
        try {
            playlist.addMusic("1456236885", "Azizam", "ed");
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("***search in playlist test***");
        System.out.println(playlist.searchInPlaylist("Azizam", "ed").getTitle());
        System.out.println(playlist.searchInPlaylist("Azizam", "ed").getSinger().getUsername());

        System.out.println("***play playlist test***");
        playlist.playPlaylist();

        System.out.println("***remove music from playlist test***");
        playlist.removeMusic("1456236885", "Azizam", "ed");

        System.out.println("***remove not existing music from playlist test***");
        try {
            playlist.removeMusic("1456236885", "Azizam", "ed");
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }

    }
}