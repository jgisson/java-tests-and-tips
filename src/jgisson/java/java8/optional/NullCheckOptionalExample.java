package jgisson.java.java8.optional;

import java.util.Optional;

public class NullCheckOptionalExample {

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

    public Optional<Usb> getUsb() {
      return Optional.ofNullable(usb);
    }
  }

  static class Computer {
    private SoundCard soundCard;

    public Computer(SoundCard soundCard) {
      this.soundCard = soundCard;
    }

    public Optional<SoundCard> getSoundCard() {
      return Optional.ofNullable(soundCard);
    }
  }

  public static void main(String[] args) {
    Optional<Computer> computer = Optional.of(new Computer(null));
    String version = computer.flatMap(Computer::getSoundCard)
        .flatMap(SoundCard::getUsb)
        .map(Usb::getVersion)
        .orElse("UNKNOWN");
    System.out.println(version);
  }

}
