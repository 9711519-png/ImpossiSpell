public class GameController {

    private WordBank wordBank; // gets words
    private DifficultyManager difficultyManager; // tracks difficulty
    private ScoreManager scoreManager; // tracks score
    private TTS tts; // handles speech
    private GameTimer timer; // countdown timer
    private UI ui; // interface

    private String currentWord; // current answer

    public GameController() {
        // create all core objects
        wordBank = new WordBank();
        difficultyManager = new DifficultyManager();
        scoreManager = new ScoreManager();
        tts = new TTS();
        ui = new UI(this);

        // timer updates UI every second
        timer = new GameTimer(10, e -> {
            ui.updateTimer(timer.getTimeLeft());

            if (timer.getTimeLeft() <= 0) {
                handleTimeout(); // time ran out
            }
        });
    }

    public void startGame() {
        // reset game state
        scoreManager = new ScoreManager();
        difficultyManager = new DifficultyManager();
        startRound();
    }

    public void startRound() {
        // get random word based on difficulty
        currentWord = wordBank.getRandomWord(
            difficultyManager.getCurrentDifficulty()
        );

        ui.showMessage("Listen carefully...");
        tts.speak(currentWord); // say word

        timer.reset(10); // reset timer
        timer.start(); // start countdown
    }

    public void receiveInput(String input) {
        timer.stop(); // stop timer when user answers

        if (input.equalsIgnoreCase(currentWord)) {
            ui.showMessage("Correct!");
            scoreManager.addPoints(
                difficultyManager.getDifficultyMultiplier()
            );
            difficultyManager.increaseDifficulty(); // harder next round
        } else {
            ui.showMessage("Wrong! Word was: " + currentWord);
        }

        ui.updateScore(scoreManager.getScore());

        // wait briefly, then next round
        new javax.swing.Timer(1500, e -> startRound()).start();
    }

    public void handleTimeout() {
        // what happens if time runs out
        ui.showMessage("Time's up! Word was: " + currentWord);

        new javax.swing.Timer(1500, e -> startRound()).start();
    }

    public void repeatWord() {
        tts.repeat(); // replay word
    }
}
