public class AudioPlayer implements MediaPlayer {
    private MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        try {
            if (!SupportedFormats.isValidFormat(audioType)) {
                throw new IllegalArgumentException("ERRO: Formato de áudio não suportado: " + audioType);
            }

            if (audioType.equalsIgnoreCase("mp3")) {
                System.out.println("-> Tocando MP3: " + fileName);
            } else {
                mediaAdapter = new MediaAdapter(audioType);
                mediaAdapter.play(audioType, fileName);
            }

        } catch (IllegalArgumentException e) {
            System.err.println("ERRO: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro inesperado ao tocar o arquivo: " + e.getMessage());
        }
    }
}
