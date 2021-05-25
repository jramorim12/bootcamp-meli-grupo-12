package com.danilopeixoto.application;

import java.util.ArrayList;
import java.util.List;

class Guest {
  private String name;

  public Guest(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Guest{" +
      "name='" + name + '\'' +
      '}';
  }

  public void eatCake() {
  }
}

class MeliGuest extends Guest {
  public MeliGuest(String name) {
    super(name);
  }

  @Override
  public void eatCake() {
    System.out.println("Viva La Chiqui!");
  }
}

interface FireworkNode {
  void setOff();
}

class FireworkItem implements FireworkNode {
  private String sound;

  public FireworkItem(String sound) {
    this.sound = sound;
  }

  public String getSound() {
    return sound;
  }

  public void setSound(String sound) {
    this.sound = sound;
  }

  @Override
  public String toString() {
    return "FireworkItem{" +
      "sound='" + sound + '\'' +
      '}';
  }

  @Override
  public void setOff() {
    System.out.print("Set off: ");
    System.out.println(this.sound);
  }
}

class FireworkPackage extends ArrayList<FireworkNode> implements FireworkNode {
  public FireworkPackage() {
  }

  @Override
  public void setOff() {
    this.forEach(System.out::println);
  }
}

class MarteGroup {
  private List<Guest> guests;
  private FireworkNode fireworks;

  public MarteGroup(List<Guest> guests, FireworkNode fireworks) {
    this.guests = guests;
    this.fireworks = fireworks;
  }

  public List<Guest> getGuests() {
    return guests;
  }

  public void setGuests(List<Guest> guests) {
    this.guests = guests;
  }

  public FireworkNode getFireworks() {
    return fireworks;
  }

  public void setFireworks(FireworkNode fireworks) {
    this.fireworks = fireworks;
  }

  public void setOffFireworks() {
    this.fireworks.setOff();
  }

  public void distributeCake() {
    this.guests.forEach(Guest::eatCake);
  }

  public void blowOutCandle() {
    this.setOffFireworks();
    this.distributeCake();
  }
}

public class LaChiquiApplication {
  public static void main(String[] args) {
    List<Guest> guests = new ArrayList<>();

    guests.add(new Guest("Maria Elisabeth Ferreira"));
    guests.add(new MeliGuest("Danilo Peixoto Ferreira"));

    FireworkPackage fireworks = new FireworkPackage();

    fireworks.add(new FireworkItem("Poooooh!"));
    fireworks.add(new FireworkPackage());

    MarteGroup marteGroup = new MarteGroup(guests, fireworks);

    marteGroup.blowOutCandle();
  }
}
