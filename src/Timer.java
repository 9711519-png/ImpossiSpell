import javax.swing.Timer;
import java.awt.event.ActionListener;

public class GameTimer {

  private int timeLeft;
  private Timer timer;

  public GameTimer(int duration, ActionListener onTick) {
    timeLeft = duration;

    timer = new Timer(1000, e -> {
      timeLeft--;
      onTick.actionPerformed(e);

      if (timeLeft <= 0) {
        timer.stop();
      }
    });
  }

  public void start() {
    timer.start();
  }

  public void stop() {
    timer.stop();
  }

  public void reset(int duration) {
    timeLeft = duration;
  }

  public int getTimeLeft() {
    return timeLeft;
  }
}
