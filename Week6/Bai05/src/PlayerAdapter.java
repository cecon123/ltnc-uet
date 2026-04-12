public class PlayerAdapter implements Player {

    private OldPlayer oldPlayer;

    public PlayerAdapter() {
        this.oldPlayer = new OldPlayer();
    }

    @Override
    public void play(String name) {
        oldPlayer.playFile(name);
    }
}
