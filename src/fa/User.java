package fa;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList<User> followerList = new ArrayList<>();
    private ArrayList<User> followingList = new ArrayList<>();
    private UserBehavior behavior;
    public ArrayList<Playlist> playlists = new ArrayList<>();
    private static ArrayList<User> allUsers = new ArrayList<>();

    public User(String username, String password) throws InvalidOperationException {
        if (username.isEmpty()) {
            throw new InvalidOperationException("Username cannot be empty.");
        }
        for (User user : allUsers) {
            if (user.username.equals(username)) {
                throw new InvalidOperationException("This username already exist.");
            }
        }
        if (password.length() < 8) {
            throw new InvalidOperationException("Password cannot have less than 8 characters.");
        }

        this.username = username;
        this.password = password;
        behavior = new RegularBehavior();
        allUsers.add(this);
    }

    public void follow (User user) {
        if (allUsers.contains(user)) {
            followingList.add(user);
        }
        throw new InvalidOperationException("User not found.");
    }
    public void createPlaylist (String title) {
        this.behavior.createPlaylist(title, this);
    }
    public void playMusic (Music music) {
        this.behavior.playMusic(music);
    }
    public void buyPremium (User owner, int month) {
        this.behavior.buyPremium(owner, month);
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public void setBehavior(int month) {
        behavior = new PremiumBehavior(month);
    }
    public Playlist getPlaylistByTitle(String title) {
        if (!(playlists.isEmpty())) {
            for (Playlist pl : playlists) {
                if (pl.getTitle().equals(title)) {
                    return pl;
                }
            }
        }
        throw new InvalidOperationException("This title already Exist in your playlists.");
    }
}
