import java.util.*;

public class DifficultyManager {

  private List<String> levels;
  private int currentIndex;

  public DifficultyManager() {
    levels = Arrays.asList(
      "easy", "medium", "hard",
      "difficult", "expert", "insane", "impossible"
    );
    currentIndex = 0;
  }

  public String getCurrentDifficulty() {
    return levels.get(currentIndex);
  }

  public void increaseDifficulty() {
    if (currentIndex < levels.size() - 1) {
      currentIndex++;
    }
  }

  public int getDifficultyMultiplier() {
    return currentIndex + 1; // 1–7 scaling
  }
}
