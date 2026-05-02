public class GameController {

    private WordBank wordBank;
    private DifficultyManager difficultyManager;
    private ScoreManager scoreManager;
    private TTS tts;
    private GameTimer timer;
    private UI ui;

    private String currentWord;

    public GameController() {
        wordBank = new WordBank();
        difficultyManager = new DifficultyManager();
        scoreManager = new ScoreManager();
        tts = new TTS();
        ui = new UI(this);

        timer = new GameTimer(10, e -> {
            ui.updateTimer(timer.getTimeLeft());

            if (timer.getTimeLeft() <= 0) {
                handleTimeout();
            }
        });
    }

    public void startGame() {
        scoreManager = new ScoreManager();
        difficultyManager = new DifficultyManager();
        startRound();
    }

    public void startRound() {
        currentWord = wordBank.getRandomWord(
            difficultyManager.getCurrentDifficulty()
        );

        ui.showMessage("Listen carefully...");
        tts.speak(currentWord);

        timer.reset(10);
        timer.start();
    }

    public void receiveInput(String input) {
        timer.stop();

        if (input.equalsIgnoreCase(currentWord)) {
            ui.showMessage("Correct!");
            scoreManager.addPoints(
                difficultyManager.getDifficultyMultiplier()
            );
            difficultyManager.increaseDifficulty();
        } else {
            ui.showMessage("Wrong! Word was: " + currentWord);
        }

        ui.updateScore(scoreManager.getScore());

        // next round after short delay
        new javax.swing.Timer(1500, e -> startRound()).start();
    }

    public void handleTimeout() {
        ui.showMessage("Time's up! Word was: " + currentWord);

        new javax.swing.Timer(1500, e -> startRound()).start();
    }

    public void repeatWord() {
        tts.repeat();
    }
}
