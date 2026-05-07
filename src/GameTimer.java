import javax.swing.Timer;
import java.awt.event.ActionListener;

public class GameTimer {

    private int timeLeft; // seconds remaining
    private Timer timer; // swing timer

    public GameTimer(int duration, ActionListener onTick) {

        // set starting time
        timeLeft = duration;

        // runs every second
        timer = new Timer(1000, e -> {

            // decrease time
            timeLeft--;

            // update UI
            onTick.actionPerformed(e);

            // stop at zero
            if (timeLeft <= 0) {
                timer.stop();
            }
        });
    }

    public void start() {
        // begin countdown
        timer.start();
    }

    public void stop() {
        // stop countdown
        timer.stop();
    }

    public void reset(int duration) {

        // reset time value
        timeLeft = duration;
    }

    public int getTimeLeft() {

        // return remaining time
        return timeLeft;
    }
}
