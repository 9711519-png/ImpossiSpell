public class ScoreManager {

  private int score;

  public ScoreManager() {
    this.score = 0;
  }

  public void addPoints(int multiplier) {
    score += 10 * multiplier;
  }

  public int getScore() {
    return score;
  }
}
