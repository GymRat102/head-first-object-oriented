public class BarkRecognizer {
    private DogDoor door;

    // recognizer to know which door it controls
    public BarkRecognizer(DogDoor door) {
        this.door = door;
    }

    public void recognize(String bark) {
        System.out.println("    BarkRecognizer: Heard a `" +
                bark + "`");
        door.open();
    }
}
