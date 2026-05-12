public class TTS {

  private String lastWord; // last spoken word

  public TTS() {
    // no setup needed
  }

  public void speak(String word) {
    lastWord = word; // store for repeat

    try {
      // macOS command to speak text using 'say' utility
      String[] command = {"say", word};
      Runtime.getRuntime().exec(command);

    } catch (Exception e) {
      e.printStackTrace(); // print errors
    }
  }

  public void repeat() {
    // replay last word
    if (lastWord != null) {
      speak(lastWord);
    }
  }
}
