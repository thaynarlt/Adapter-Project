public class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedPlayer;

    public MediaAdapter(String audioType) throws IllegalArgumentException {
        if (!audioType.equalsIgnoreCase("mp4") && !audioType.equalsIgnoreCase("vlc")) {
            throw new IllegalArgumentException("Formato não suportado pelo adaptador: " + audioType);
        }
        advancedPlayer = new AdvancedMediaPlayer();
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp4")) {
            advancedPlayer.playMp4(fileName);
        } else if (audioType.equalsIgnoreCase("vlc")) {
            advancedPlayer.playVlc(fileName);
        }
    }
}
