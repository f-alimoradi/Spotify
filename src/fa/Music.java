package fa;

import java.util.ArrayList;

public class Music {
    private String title;
    private User singer;
    private int numberOfStream;
    private static ArrayList<Music> allMusics = new ArrayList<>();

    public Music(String title, User singer) throws InvalidOperationException {
        if (Search(title, singer.getUsername()) != null) {
            throw new  InvalidOperationException("This music already exists.");
        }
        this.title = title;
        this.singer = singer;
        numberOfStream = 0;
        allMusics.add(this);
        for (Music m : allMusics) {
            System.out.println(m.singer+m.title);
        }
    }

    public void play() {
        if (Search(title, singer.getUsername()) == null) {
            throw new InvalidOperationException("Music doesn't exist.");
        }
        numberOfStream += 1;
        System.out.println("Music title: " + title + "  Singer: " + singer.getUsername());
    }
    public static ArrayList Search(String title) {
        ArrayList<Music> musics = new ArrayList<>();
        for (Music music : allMusics) {
            if (music.title.equals(title)) {
                musics.add(music);
            }
        }
        if (musics.isEmpty()) {
            return null;
        }
        return musics;
    }
    public static Music Search(String title, String singer) {
        for (Music music : allMusics) {
            if (music.title.equals(title) && music.singer.getUsername().equals(singer)) {
                return music;
            }
        }
        return null;
    }

    public String getTitle() {
        return title;
    }
    public User getSinger() {
        return singer;
    }
}
