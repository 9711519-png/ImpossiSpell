import javax.swing.*;
import java.awt.*;

public class UI {

    private JFrame frame; // main window

    // display elements
    private JLabel titleImage;
    private JLabel timerLabel;
    private JLabel scoreLabel;
    private JLabel messageLabel;

    private JTextField inputField; // user input box

    private JButton submitButton;
    private JButton repeatButton;
    private JButton startButton;

    private GameController controller; // connects UI to game logic

    public UI(GameController controller) {
        this.controller = controller;
        createUI(); // build interface
    }

    private void createUI() {
        frame = new JFrame("ImpossiSpell");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        // use card layout to switch screens
        frame.setLayout(new CardLayout());

        JPanel titleScreen = buildTitleScreen(); // first screen
        JPanel gameScreen = buildGameScreen(); // main game screen

        frame.add(titleScreen, "TITLE");
        frame.add(gameScreen, "GAME");

        frame.setVisible(true);
    }

    private JPanel buildTitleScreen() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // load title image
        ImageIcon icon = new ImageIcon("images/ISTitle_.png");
        titleImage = new JLabel(icon);
        titleImage.setHorizontalAlignment(JLabel.CENTER);

        startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.BOLD, 24));

        // start game when clicked
        startButton.addActionListener(e -> {
            showGameScreen();
            controller.startGame();
        });

        panel.add(titleImage, BorderLayout.CENTER);
        panel.add(startButton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel buildGameScreen() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // top bar (timer + score)
        JPanel topBar = new JPanel(new GridLayout(1, 2));

        timerLabel = new JLabel("Time: 10", SwingConstants.CENTER);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 24));

        scoreLabel = new JLabel("Score: 0", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 24));

        topBar.add(timerLabel);
        topBar.add(scoreLabel);

        // center input area
        JPanel center = new JPanel(new GridLayout(3, 1));

        inputField = new JTextField(); // where user types
        inputField.setFont(new Font("Arial", Font.PLAIN, 22));

        submitButton = new JButton("Submit");
        repeatButton = new JButton("Repeat Word");

        submitButton.setFont(new Font("Arial", Font.BOLD, 20));
        repeatButton.setFont(new Font("Arial", Font.BOLD, 20));

        // send answer to controller
        submitButton.addActionListener(e -> {
            String text = inputField.getText();
            controller.receiveInput(text);
            inputField.setText("");
        });

        // replay word
        repeatButton.addActionListener(e -> controller.repeatWord());

        center.add(inputField);
        center.add(submitButton);
        center.add(repeatButton);

        // message area (feedback)
        messageLabel = new JLabel(" ", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.ITALIC, 18));

        panel.add(topBar, BorderLayout.NORTH);
        panel.add(center, BorderLayout.CENTER);
        panel.add(messageLabel, BorderLayout.SOUTH);

        return panel;
    }

    public void updateTimer(int seconds) {
        timerLabel.setText("Time: " + seconds); // update countdown
    }

    public void updateScore(int score) {
        scoreLabel.setText("Score: " + score); // update score
    }

    public void showMessage(String msg) {
        messageLabel.setText(msg); // show feedback
    }

    public void showGameScreen() {
        // switch from title to game
        CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
        cl.show(frame.getContentPane(), "GAME");
    }
}
