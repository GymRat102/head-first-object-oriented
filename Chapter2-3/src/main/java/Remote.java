import java.util.Timer;
import java.util.TimerTask;

public class Remote {
    private DogDoor door;

    public Remote(DogDoor door) {
        this.door = door;
    }

    public void pressButton() {
        System.out.println("Pressing the remote control button...");
        if (door.isOpen()) {
            door.close();
        } else {
            door.open();

            // behind the scene: Timer class kicks off a new Thread
            final Timer timer = new Timer(); // final: anonymous class need to get access timer object
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    door.close();
                    timer.cancel(); // manually cancel it, instead of JVM garbage collects
                }
            }, 5000);
        }
    }
}
