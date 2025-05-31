public class AudioPlayer implements MediaPlayer {
    private MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        try {
            // Verifica se o tipo de áudio é nulo ou vazio
            if (!SupportedFormats.isValidFormat(audioType)) {
                // Lança uma exceção se o formato não for suportado
                throw new IllegalArgumentException("ERRO: Formato de áudio não suportado: " + audioType);
            }

            // Lógica nativa para MP3
            if (audioType.equalsIgnoreCase("mp3")) {
                System.out.println("-> Tocando MP3: " + fileName);
            } 
            // Para outros formatos suportados (MP4, VLC), usa o Adapter
            else if (audioType.equalsIgnoreCase("mp4") || audioType.equalsIgnoreCase("vlc")) {
                mediaAdapter = new MediaAdapter(audioType); // Cria o adaptador específico para o tipo
                mediaAdapter.play(audioType, fileName);   // Delega a reprodução ao adaptador
            }
            // O else original que usava o adapter para qualquer coisa não mp3 foi refinado acima

        // Tratamento de exceções para formatos não suportados
        } catch (IllegalArgumentException e) {
            System.err.println("ERRO: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro inesperado ao tocar o arquivo: " + e.getMessage());
        }
    }
}