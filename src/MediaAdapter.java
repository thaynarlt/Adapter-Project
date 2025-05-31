public class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedPlayer;

    public MediaAdapter(String audioType) throws IllegalArgumentException {
        // Verifica se o tipo de áudio é nulo ou vazio
        if (!audioType.equalsIgnoreCase("mp4") && !audioType.equalsIgnoreCase("vlc")) {
            throw new IllegalArgumentException("Formato não suportado pelo adaptador: " + audioType);
        }
        // Inicializa o AdvancedMediaPlayer para formatos suportados
        advancedPlayer = new AdvancedMediaPlayer();
    }

    @Override
    // Método para tocar arquivos de áudio usando o AdvancedMediaPlayer
    public void play(String audioType, String fileName) {
        // Verifica se o tipo de áudio é nulo ou vazio
        if (audioType.equalsIgnoreCase("mp4")) {
            advancedPlayer.playMp4(fileName);
        // Se o tipo de áudio for VLC, usa o método correspondente
        } else if (audioType.equalsIgnoreCase("vlc")) {
            advancedPlayer.playVlc(fileName);
        }
    }
}
