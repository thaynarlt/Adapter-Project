public class SupportedFormats {
    public static boolean isValidFormat(String audioType) {
        return audioType != null && (
            audioType.equalsIgnoreCase("mp3") ||
            audioType.equalsIgnoreCase("mp4") ||
            audioType.equalsIgnoreCase("vlc")
        );
    }
}
