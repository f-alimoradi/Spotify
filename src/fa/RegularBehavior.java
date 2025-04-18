package fa;

public class RegularBehavior implements UserBehavior {
    private int playingLimit;

    public RegularBehavior() {
        playingLimit = 5;
    }

    @Override
    public void createPlaylist (String Title, User Owner) throws InvalidOperationException {
        throw new InvalidOperationException("Only premium users can create playlists.");
    }
    @Override
    public void playMusic (Music music) throws InvalidOperationException {
        if (playingLimit > 0) {
            playingLimit -= 1;
            music.play();
        } else {
            throw new InvalidOperationException("You have reached your playing limit.");
        }
    }
    @Override
    public void buyPremium (User owner, int month){
        if (month <= 0) {
            throw new InvalidOperationException("Month should be positive.");
        }
        owner.setBehavior(month);
    }
}
