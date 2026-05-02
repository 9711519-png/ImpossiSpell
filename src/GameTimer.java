import javax.swing.Timer;
import java.awt.event.ActionListener;

public class GameTimer {

  private int timeLeft; // seconds remaining
  private Timer timer; // Swing timer

  public GameTimer(int duration, ActionListener onTick) {
    timeLeft = duration; // set starting time

    // runs every 1 second
    timer = new Timer(1000, e -> {
      timeLeft--; // decrease time
      onTick.actionPerformed(e); // update UI

      if (timeLeft <= 0) {
        timer.stop(); // stop at 0
      }
    });
  }

  public void start() {
    timer.start(); // begin countdown
  }

  public void stop() {
    timer.stop(); // pause/stop
  }

  public void reset(int duration) {
    timeLeft = duration; // reset time
  }

  public int getTimeLeft() {
    return timeLeft; // return remaining time
  }
}
