public class GameController {

    private WordBank wordbank; // gets words
    private DifficultyManager difficultyManager; // tracks difficulty
    private ScoreManager scoreManager; // tracks score
    private TTS tts; // handles speech
    private GameTimer timer; // countdown timer
    private UI ui; // interface

    private String currentWord; // current answer

    // keeps track if round is active
    private boolean roundActive = false;

    // timer between rounds
    private javax.swing.Timer nextRoundDelay;

    public GameController() {

        // create all core objects
        wordbank = new WordBank();
        difficultyManager = new DifficultyManager();
        scoreManager = new ScoreManager();
        tts = new TTS();
        ui = new UI(this);

        // timer updates every second
        timer = new GameTimer(10, e -> {

            // update timer on screen
            ui.updateTimer(timer.getTimeLeft());

            // only timeout if round is active
            if (timer.getTimeLeft() <= 0 && roundActive) {
                handleTimeout();
            }
        });
    }

    public void startGame() {

        // stop old timers before restarting
        timer.stop();

        // stop old round delay if it exists
        if (nextRoundDelay != null) {
            nextRoundDelay.stop();
        }

        // reset game data
        scoreManager = new ScoreManager();
        difficultyManager = new DifficultyManager();

        // reset score display
        ui.updateScore(0);

        // begin first round
        startRound();
    }

    public void startRound() {

        // stop old timer first
        timer.stop();

        // mark round active
        roundActive = true;

        // get random word using current difficulty
        currentWord = wordbank.getRandomWord(
            difficultyManager.getCurrentDifficulty()
        );

        // show difficulty on screen
        ui.showMessage(
            "Difficulty: " +
            difficultyManager.getCurrentDifficulty()
        );

        // speak word
        tts.speak(currentWord);

        // reset countdown
        timer.reset(10);

        // update timer display immediately
        ui.updateTimer(10);

        // start countdown
        timer.start();
    }

    public void receiveInput(String input) {

        // ignore input if round already ended
        if (!roundActive) {
            return;
        }

        // end round
        roundActive = false;

        // stop timer
        timer.stop();

        // check answer
        if (input.trim().equalsIgnoreCase(currentWord)) {

            ui.showMessage(
                "Correct! Word was: " + currentWord
            );

            // add points based on difficulty
            scoreManager.addPoints(
                difficultyManager.getDifficultyMultiplier()
            );

            // increase difficulty
            difficultyManager.increaseDifficulty();

        } else {

            ui.showMessage(
                "Wrong! Word was: " + currentWord
            );
        }

        // update score display
        ui.updateScore(scoreManager.getScore());

        // go to next round
        goToNextRound();
    }

    public void handleTimeout() {

        // stop duplicate timeout calls
        if (!roundActive) {
            return;
        }

        // end round
        roundActive = false;

        // stop timer
        timer.stop();

        // show timeout message
        ui.showMessage(
            "Time's up! Word was: " + currentWord
        );

        // go to next round
        goToNextRound();
    }

    private void goToNextRound() {

        // stop old delay timer
        if (nextRoundDelay != null) {
            nextRoundDelay.stop();
        }

        // create delay before next round
        nextRoundDelay =
            new javax.swing.Timer(1500, e -> startRound());

        // VERY IMPORTANT:
        // without this the timer repeats forever
        // causing broken rounds and random TTS words
        nextRoundDelay.setRepeats(false);

        // start delay
        nextRoundDelay.start();
    }

    public void repeatWord() {

        // only repeat during active round
        if (roundActive) {
            tts.repeat();
        }
    }
}
