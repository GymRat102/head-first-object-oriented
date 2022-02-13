import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {

    private boolean open;

    public DogDoor() {
        this.open = false;
    }

    public void open() {
        System.out.println("The dog door opens.");
        open = true;

        // behind the scene: Timer class kicks off a new Thread
        final Timer timer = new Timer(); // final: anonymous class need to get access timer object
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                close();
                timer.cancel(); // manually cancel it, instead of JVM garbage collects
            }
        }, 5000);
    }

    public void close() {
        System.out.println("The dog door closes.");
        open = false;
    }

    public boolean isOpen() {
        return open;
    }
}
