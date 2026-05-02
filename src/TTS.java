public class TTS {

  private String lastWord; // last spoken word

  public TTS() {
    // no setup needed
  }

  public void speak(String word) {
    lastWord = word; // store for repeat

    try {
      // PowerShell command to speak text
      String command =
        "powershell -Command \"Add-Type -AssemblyName System.Speech; " +
        "(New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak(\\\"" + word + "\\\");\"";

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
