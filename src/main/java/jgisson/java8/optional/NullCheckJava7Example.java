package jgisson.java8.optional;

public class NullCheckJava7Example {

  static class Usb {
    private String version;

    public Usb(String version) {
      this.version = version;
    }

    public String getVersion() {
      return version;
    }
  }

  static class SoundCard {
    private Usb usb;

    public SoundCard(Usb usb) {
      this.usb = usb;
    }

    public Usb getUsb() {
      return usb;
    }
  }

  static class Computer {
    private SoundCard soundCard;

    public Computer(SoundCard soundCard) {
      this.soundCard = soundCard;
    }

    public SoundCard getSoundCard() {
      return soundCard;
    }
  }

  public static void main(String[] args) {
    String version = "UNKNOWN";
    Computer computer = new Computer(null);
    if(computer != null){
      SoundCard soundcard = computer.getSoundCard();
      if(soundcard != null){
        Usb usb = soundcard.getUsb();
        if(usb != null){
          version = usb.getVersion();
        }
      }
    }

    System.out.println(version);
  }
}
