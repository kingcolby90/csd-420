import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ColbyThreeThreads extends JFrame {
    private JTextArea textArea;
    private static final int COUNT = 10000;

    public ColbyThreeThreads() {
        setTitle("ColbyThreeThreads Output");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        add(new JScrollPane(textArea));
        setVisible(true);

        startThreads();
    }

    private void startThreads() {
        Thread letterThread = new Thread(() -> outputRandomChars("letters"));
        Thread digitThread = new Thread(() -> outputRandomChars("digits"));
        Thread symbolThread = new Thread(() -> outputRandomChars("symbols"));

        letterThread.start();
        digitThread.start();
        symbolThread.start();
    }

    private void outputRandomChars(String type) {
        Random rand = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < COUNT; i++) {
            char c;
            switch (type) {
                case "letters":
                    c = (char) ('a' + rand.nextInt(26));
                    break;
                case "digits":
                    c = (char) ('0' + rand.nextInt(10));
                    break;
                case "symbols":
                    char[] symbols = {'!', '@', '#', '$', '%', '&', '*'};
                    c = symbols[rand.nextInt(symbols.length)];
                    break;
                default:
                    c = '?';
            }
            builder.append(c);
            if ((i + 1) % 100 == 0) builder.append("\n"); // Line breaks for readability
        }

        SwingUtilities.invokeLater(() -> textArea.append(type.toUpperCase() + ":\n" + builder.toString() + "\n\n"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ColbyThreeThreads::new);
    }
}
