public class DifficultyManager {

    private int level = 0; // current difficulty level

    // difficulty names in order
    private String[] levels = {
        "easy", "medium", "hard", "difficult",
        "expert", "insane", "impossible"
    };

    public String getCurrentDifficulty() {
        // return current difficulty name
        return levels[level];
    }

    public int getDifficultyMultiplier() {
        // score multiplier based on level
        return level + 1;
    }

    public void increaseDifficulty() {
        // move to next difficulty if possible
        if (level < levels.length - 1) {
            level++;
        }
    }
}
