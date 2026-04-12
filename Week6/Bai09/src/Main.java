public class Main {

    public static void main(String[] args) {
        AudioPlayable audioPlayer = new AudioPlayer();
        VideoPlayable videoPlayer = new VideoPlayer();

        MediaPlayer mediaPlayer = new MediaPlayer(audioPlayer, videoPlayer);

        mediaPlayer.playAudio("music.mp3");
        mediaPlayer.playVideo("movie.mp4");
    }
}
