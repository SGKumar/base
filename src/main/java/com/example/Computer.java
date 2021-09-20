import java.util.Optional;

public class Computer {
  private Soundcard soundCard;
  public Computer() {
    //soundCard = new Soundcard();
  }
  public Soundcard getSoundcard() { return soundCard; }

  public static void main(String[] args) {
    Computer computer = new Computer();
    Optional<Computer> comp = Optional.of(computer);
    String name = comp.flatMap(Computer::getSoundcard)
                            .flatMap(Soundcard::getUSB)
                            .map(USB::getVersion)
                            .orElse("Chumma");

  }
}

class Soundcard {
  private USB usb;
  public Soundcard() { usb = new USB(); }
  public USB getUSB() { return usb; }

}

class USB{
  public String getVersion() { return "4.0"; }
}