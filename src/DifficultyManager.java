import java.util.*;

public class DifficultyManager {

  private List<String> levels; // stores difficulty names
  private int currentIndex; // tracks current level

  public DifficultyManager() {
    // initialize difficulty levels in order
    levels = Arrays.asList(
      "easy", "medium", "hard",
      "difficult", "expert", "insane", "impossible"
    );
    currentIndex = 0; // start at easiest
  }

  public String getCurrentDifficulty() {
    return levels.get(currentIndex); // return current level
  }

  public void increaseDifficulty() {
    // move up one level (if not at max)
    if (currentIndex < levels.size() - 1) {
      currentIndex++;
    }
  }

  public int getDifficultyMultiplier() {
    return currentIndex + 1; // higher level = more points
  }
}
