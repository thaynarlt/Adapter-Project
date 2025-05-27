public class Main {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();

        System.out.println("==== Testes de reprodução ====");
        player.play("mp3", "musica_boa.mp3");
        player.play("mp4", "video_clipe.mp4");
        player.play("vlc", "documentario.vlc");
        player.play("avi", "filme.avi"); // formato não suportado
        player.play(null, "semformato.mp3"); // formato nulo
        player.play("MP4", "teste_case.mp4"); // testando insensibilidade a maiúsculas
    }
}
    