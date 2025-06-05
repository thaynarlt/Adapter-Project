import java.util.Objects;

public class AudioPlayer implements MediaPlayer {
    private MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        try {
            
            Objects.requireNonNull(audioType, "ERRO: O tipo de áudio não pode ser nulo.");
            Objects.requireNonNull(fileName, "ERRO: O nome do arquivo não pode ser nulo.");

            if (audioType.equalsIgnoreCase("mp3")) {
                playMp3(fileName);
            } else if (SupportedFormats.isValidFormat(audioType)) {
                playWithAdapter(audioType, fileName);
            } else {
                throw new IllegalArgumentException("Formato de áudio não suportado: " + audioType);
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            System.err.println("ERRO: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        }
    }

    private void playMp3(String fileName) {
        System.out.println("-> Tocando MP3: " + fileName);
    }

    private void playWithAdapter(String audioType, String fileName) {
        mediaAdapter = new MediaAdapter(audioType);
        mediaAdapter.play(audioType, fileName);
    }
}
