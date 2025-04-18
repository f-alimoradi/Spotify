package fa;

public class PremiumBehavior implements UserBehavior {
    private int month;

    public PremiumBehavior(int month) throws InvalidOperationException {
        if (month <= 0) {
            throw new InvalidOperationException("Month should be positive.");
        }
        this.month = month;
    }

    @Override
    public void createPlaylist (String title, User owner) {
        if (!(owner.playlists.isEmpty())) {
            for (Playlist pl : owner.playlists) {
                if (pl.getTitle().equals(title)) {
                    throw new InvalidOperationException("This title already Exist in your playlists.");
                }
            }
        }
        owner.playlists.add(new Playlist(title, owner));
    }
    @Override
    public void playMusic (Music music) {
        music.play();
    }
    @Override
    public void buyPremium (User owner, int month) {
        if (month <= 0) {
            throw new InvalidOperationException("Month should be positive.");
        }
        month += month;
    }
}
