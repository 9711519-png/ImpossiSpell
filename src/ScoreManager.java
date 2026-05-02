public class ScoreManager {

  private int score; // player's total score

  public ScoreManager() {
    this.score = 0; // start at 0
  }

  public void addPoints(int multiplier) {
    // add points based on difficulty
    score += 10 * multiplier;
  }

  public int getScore() {
    return score; // return current score
  }
}
