public class SupportedFormats {
    // Método para verificar se o formato de áudio é válido
    public static boolean isValidFormat(String audioType) {
        return audioType != null && (
            // Verifica se o tipo de áudio é MP3, MP4 ou VLC
            audioType.equalsIgnoreCase("mp3") ||
            audioType.equalsIgnoreCase("mp4") ||
            audioType.equalsIgnoreCase("vlc")
        );
    }
}
