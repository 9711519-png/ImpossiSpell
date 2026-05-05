public class DifficultyManager {

    private int level = 0;

    private String[] levels = {
        "easy", "medium", "hard", "difficult", "expert", "insane", "impossible"
    };

    public String getCurrentDifficulty() {
        return levels[level];
    }

    public void increaseDifficulty() {
        if (level < levels.length - 1) {
            level++;
        }
    }
}
