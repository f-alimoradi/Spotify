package fa;

import java.util.ArrayList;

public class Playlist {
    private String title;
    public ArrayList<Music> playlist = new ArrayList<>();
    private User Owner;

    public Playlist(String title, User owner) {
        this.title = title;
        this.Owner = owner;
    }

    public void editTitle(String password, String title) throws InvalidOperationException {
        if (!(password.equals(Owner.getPassword()))) {
            throw new  InvalidOperationException("The name of the playlist can only be changed by the owner.");
        }
        this.title = title;
    }
    public void addMusic(String password, String title, String singer) throws InvalidOperationException {
        if (!(password.equals(Owner.getPassword()))) {
            throw new  InvalidOperationException("Music can only be added to the playlist by the owner.");
        }
        Music music = Music.Search(title, singer);
        if (music == null) {
            throw new  InvalidOperationException("Music not found.");
        }
        if (searchInPlaylist(title, singer) != null) {
            throw new  InvalidOperationException("The music already exists in the playlist.");
        }
        playlist.add(music);
    }
    public void removeMusic(String password, String title, String singer) throws InvalidOperationException {
        if (!(password.equals(Owner.getPassword()))) {
            throw new  InvalidOperationException("Music can only be removed from the playlist by the owner.");
        }
        Music music = searchInPlaylist(title, singer);
        if (music == null) {
            throw new  InvalidOperationException("The music doesn't exists in the playlist.");
        }
        playlist.remove(music);
    }
    public ArrayList searchInPlaylist(String title) {
        ArrayList<Music> musics = new ArrayList<>();
        for (Music music : playlist) {
            if (music.getTitle().equals(title)) {
                musics.add(music);
            }
        }
        if (musics.isEmpty()) {
            return null;
        }
        return musics;
    }
    public Music searchInPlaylist(String title, String singer) {
        if (!(playlist.isEmpty())) {
            for (Music music : playlist) {
                if (music.getTitle().equals(title) && music.getSinger().getUsername().equals(singer)) {
                    return music;
                }
            }
        }
        return null;
    }
    public void playPlaylist() {
        for (Music music : playlist) {
            music.play();

        }
    }

    public String getTitle() {
        return title;
    }
}
