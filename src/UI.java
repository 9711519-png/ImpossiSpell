import javax.swing.*;
import java.awt.*;

public class UI {

    private JFrame frame;

    private JLabel titleImage;
    private JLabel timerLabel;
    private JLabel scoreLabel;
    private JLabel messageLabel;

    private JTextField inputField;

    private JButton submitButton;
    private JButton repeatButton;
    private JButton startButton;

    private GameController controller;

    public UI(GameController controller) {
        this.controller = controller;
        createUI();
    }

    private void createUI() {
        frame = new JFrame("ImpossiSpell");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        frame.setLayout(new CardLayout());

        JPanel titleScreen = buildTitleScreen();
        JPanel gameScreen = buildGameScreen();

        frame.add(titleScreen, "TITLE");
        frame.add(gameScreen, "GAME");

        frame.setVisible(true);
    }

    private JPanel buildTitleScreen() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.BLACK);

        // Load title image
        ImageIcon icon = new ImageIcon("https://github.com/9711519-png/ImpossiSpell/blob/main/images/ISTitle_.png");
        titleImage = new JLabel(icon);
        titleImage.setHorizontalAlignment(JLabel.CENTER);

        startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.BOLD, 24));
        startButton.setBackground(Color.DARK_GRAY);
        startButton.setForeground(Color.WHITE);

        startButton.addActionListener(e -> {
            showGameScreen();
            controller.startGame();
        });

        panel.add(titleImage, BorderLayout.CENTER);
        panel.add(startButton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel buildGameScreen() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.BLACK);

        // TOP BAR
        JPanel topBar = new JPanel(new GridLayout(1, 2));
        topBar.setBackground(Color.BLACK);

        timerLabel = new JLabel("Time: 10", SwingConstants.CENTER);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        timerLabel.setForeground(Color.WHITE);

        scoreLabel = new JLabel("Score: 0", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 24));
        scoreLabel.setForeground(Color.WHITE);

        topBar.add(timerLabel);
        topBar.add(scoreLabel);

        panel.add(topBar, BorderLayout.NORTH);

        // CENTER INPUT AREA
        JPanel center = new JPanel(new GridLayout(3, 1));
        center.setBackground(Color.BLACK);

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 22));
        inputField.setBackground(Color.DARK_GRAY);
        inputField.setForeground(Color.WHITE);

        submitButton = new JButton("Submit");
        repeatButton = new JButton("Repeat Word");

        submitButton.setFont(new Font("Arial", Font.BOLD, 20));
        repeatButton.setFont(new Font("Arial", Font.BOLD, 20));

        submitButton.setBackground(Color.GRAY);
        repeatButton.setBackground(Color.GRAY);

        submitButton.setForeground(Color.WHITE);
        repeatButton.setForeground(Color.WHITE);

        submitButton.addActionListener(e -> {
            String text = inputField.getText();
            controller.receiveInput(text);
            inputField.setText("");
        });

        repeatButton.addActionListener(e -> controller.repeatWord());

        center.add(inputField);
        center.add(submitButton);
        center.add(repeatButton);

        panel.add(center, BorderLayout.CENTER);

        // MESSAGE LABEL
        messageLabel = new JLabel(" ", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.ITALIC, 18));
        messageLabel.setForeground(Color.LIGHT_GRAY);

        panel.add(messageLabel, BorderLayout.SOUTH);

        return panel;
    }

    public void updateTimer(int seconds) {
        timerLabel.setText("Time: " + seconds);
    }

    public void updateScore(int score) {
        scoreLabel.setText("Score: " + score);
    }

    public void showMessage(String msg) {
        messageLabel.setText(msg);
    }

    public void showGameScreen() {
        CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
        cl.show(frame.getContentPane(), "GAME");
    }
}
