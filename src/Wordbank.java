import java.util.Random;

public class WordBank {

  // word lists by difficulty
  private String[] easy;
  private String[] medium;
  private String[] hard;
  private String[] difficult;
  private String[] expert;
  private String[] insane;
  private String[] impossible;

  private Random rand = new Random(); // random generator

  public WordBank() {

    // each array stores words for a difficulty level

    easy = new String[] {"cat", "dog", "sun", "hat", "tree", "book"};
    medium = new String[] {"garden", "puzzle", "whisper", "silver"};
    hard = new String[] {"silhouette", "pharaoh", "chaos", "rhythm"};
    difficult = new String[] {"onomatopoeia", "bureaucracy"};
    expert = new String[] {"juxtaposition", "magnanimous"};
    insane = new String[] {"synecdoche", "schadenfreude"};
    impossible = new String[] {"antidisestablishmentarianism"};

  }

  public String getRandomWord(String difficulty) {
    // get correct list based on difficulty
    String[] list = getList(difficulty);

    if (list == null || list.length == 0) {
      return "No words found"; // safety check
    }

    int index = rand.nextInt(list.length); // random index
    return list[index]; // return random word
  }

  private String[] getList(String difficulty) {
    // match difficulty string to correct array
    switch (difficulty.toLowerCase()) {
      case "easy": return easy;
      case "medium": return medium;
      case "hard": return hard;
      case "difficult": return difficult;
      case "expert": return expert;
      case "insane": return insane;
      case "impossible": return impossible;
      default: return null; // invalid input
    }
  }
}
