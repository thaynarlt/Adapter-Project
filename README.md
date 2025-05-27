# Projeto AudioPlayer com Padrão Adapter 🎵🔌

Este projeto demonstra o uso do padrão de projeto **Adapter** para habilitar um `AudioPlayer`, inicialmente limitado a MP3, a reproduzir formatos como MP4 e VLC, que são gerenciados por uma classe `AdvancedMediaPlayer` com uma interface diferente.

---

## Essência do Projeto 💡

O `AudioPlayer` precisa de suporte a novos formatos de áudio (MP4, VLC). Em vez de modificar o `AudioPlayer` ou a classe `AdvancedMediaPlayer` (que já lida com esses formatos mas de forma incompatível), utilizamos um `MediaAdapter`. Este adaptador faz a "tradução" necessária para que ambos possam trabalhar juntos, seguindo o padrão Adapter, que conecta interfaces incompatíveis.

---

## Principais Componentes 🧩

* **`MediaPlayer.java` (Interface Target):** Define o contrato `play(String audioType, String fileName)` esperado pelo cliente.
* **`AdvancedMediaPlayer.java` (Adaptee):** Classe existente que reproduz MP4 e VLC através de métodos próprios (ex: `playMp4(fileName)`).
* **`MediaAdapter.java` (Adapter):** Implementa `MediaPlayer` e traduz suas chamadas para os métodos de `AdvancedMediaPlayer`.
* **`AudioPlayer.java` (Client):** Utiliza `MediaPlayer` para tocar áudio. Reproduz MP3 nativamente e delega outros formatos (MP4, VLC) para o `MediaAdapter`.
* **`SupportedFormats.java` (Utilitário):** Valida os formatos de áudio suportados.
* **`Main.java` (Ponto de Entrada):** Demonstra o funcionamento do `AudioPlayer` com diferentes formatos.

---

## Como Inicializar e Executar o Projeto 🚀

Para compilar e executar este projeto Java, você precisará do JDK (Java Development Kit) instalado.

### Estrutura de Arquivos:

Certifique-se de que todos os arquivos `.java` (`AdvancedMediaPlayer.java`, `AudioPlayer.java`, `Main.java`, `MediaAdapter.java`, `MediaPlayer.java`, `SupportedFormats.java`) estejam no mesmo diretório ou em um pacote configurado corretamente.

### Passos para Compilação e Execução (via Terminal):

1.  **Abra um terminal ou prompt de comando.**
2.  **Navegue até o diretório do projeto:**
    ```bash
    cd caminho/para/seu/projeto
    ```
3.  **Compile os arquivos Java:**
    ```bash
    javac *.java
    ```
    Isso gerará os arquivos `.class`.
4.  **Execute a classe principal:**
    ```bash
    java Main
    ```

### Saída Esperada:

O console exibirá os resultados das tentativas de reprodução, incluindo mensagens de sucesso para formatos suportados e erros para os não suportados: