import javax.swing.*;
import java.awt.*;

public class UI {

    private JFrame frame; // main window

    // display elements
    private JLabel titleImage;
    private JLabel timerLabel;
    private JLabel scoreLabel;
    private JLabel messageLabel;
    private JLabel smallImage; // <-- NEW small image

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
        JPanel gameScreen = buildGameScreen();   // main game screen

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

        // ----------------------------------------------------
        // SMALL IMAGE AT THE TOP OF THE GAME SCREEN
        // ----------------------------------------------------
        ImageIcon smallIcon = new ImageIcon("images/small_placeholder.png");
        smallImage = new JLabel(smallIcon);
        smallImage.setHorizontalAlignment(JLabel.CENTER);

        panel.add(smallImage, BorderLayout.NORTH);

        // ----------------------------------------------------
        // TOP BAR (timer + score)
        // ----------------------------------------------------
        JPanel topBar = new JPanel(new GridLayout(1, 2));

        timerLabel = new JLabel("Time: 10", SwingConstants.CENTER);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 24));

        scoreLabel = new JLabel("Score: 0", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 24));

        topBar.add(timerLabel);
        topBar.add(scoreLabel);

        panel.add(topBar, BorderLayout.CENTER);

        // ----------------------------------------------------
        // CENTER INPUT AREA
        // ----------------------------------------------------
        JPanel center = new JPanel(new GridLayout(3, 1));

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 22));

        submitButton = new JButton("Submit");
        repeatButton = new JButton("Repeat Word");

        submitButton.setFont(new Font("Arial", Font.BOLD, 20));
        repeatButton.setFont(new Font("Arial", Font.BOLD, 20));

        submitButton.addActionListener(e -> {
            String text = inputField.getText();
            controller.receiveInput(text);
            inputField.setText("");
        });

        repeatButton.addActionListener(e -> controller.repeatWord());

        center.add(inputField);
        center.add(submitButton);
        center.add(repeatButton);

        panel.add(center, BorderLayout.SOUTH);

        // ----------------------------------------------------
        // MESSAGE LABEL
        // ----------------------------------------------------
        messageLabel = new JLabel(" ", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.ITALIC, 18));

        panel.add(messageLabel, BorderLayout.PAGE_END);

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
