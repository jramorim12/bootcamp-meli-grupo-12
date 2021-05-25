package com.danilopeixoto.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

abstract class Vehicle {
  private final String plate;
  private final double weight;
  private final int wheelCount;
  private double velocity;
  private double acceleration;
  private double rotationAngle;

  public Vehicle(String plate, double weight, int wheelCount) {
    this.plate = plate;
    this.weight = weight;
    this.wheelCount = wheelCount;
    this.velocity = 0;
    this.acceleration = 0;
    this.rotationAngle = 0;
  }

  public String getPlate() {
    return plate;
  }

  public double getWeight() {
    return weight;
  }

  public int getWheelCount() {
    return wheelCount;
  }

  public double getVelocity() {
    return velocity;
  }

  public void setVelocity(double velocity) {
    this.velocity = velocity;
  }

  public double getAcceleration() {
    return acceleration;
  }

  public void setAcceleration(double acceleration) {
    this.acceleration = acceleration;
  }

  public double getRotationAngle() {
    return rotationAngle;
  }

  public void setRotationAngle(double rotationAngle) {
    this.rotationAngle = rotationAngle;
  }

  @Override
  public String toString() {
    return "Vehicle{" +
      "plate='" + plate + '\'' +
      ", weight=" + weight +
      ", wheelCount=" + wheelCount +
      ", velocity=" + velocity +
      ", acceleration=" + acceleration +
      ", rotationAngle=" + rotationAngle +
      '}';
  }
}

class Car extends Vehicle {
  public Car(String plate) {
    super(plate, 1000, 4);
  }
}

class MedicalCar extends Car {
  public MedicalCar(String plate) {
    super(plate);
  }

  public void rescue(Car car) {
    System.out.println("Rescue:");
    System.out.println(car);
  }
}

class Motorbike extends Vehicle {
  public Motorbike(String plate) {
    super(plate, 300, 2);
  }

  public void rescue(Motorbike motorbike) {
    System.out.println("Rescue:");
    System.out.println(motorbike);
  }
}

class MedicalMotorbike extends Motorbike {
  public MedicalMotorbike(String plate) {
    super(plate);
  }
}

class Race {
  private String name;
  private double prize;
  private double distance;
  private int maximumVehicleCount;
  private List<Vehicle> vehicles;
  private MedicalCar medicalCar;
  private MedicalMotorbike medicalMotorbike;

  public Race(
    String name,
    double prize,
    double distance,
    int maximumVehicleCount,
    List<Vehicle> vehicles,
    MedicalCar medicalCar,
    MedicalMotorbike medicalMotorbike) {
    this.name = name;
    this.prize = prize;
    this.distance = distance;
    this.maximumVehicleCount = maximumVehicleCount;
    this.vehicles = vehicles;
    this.medicalCar = medicalCar;
    this.medicalMotorbike = medicalMotorbike;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrize() {
    return prize;
  }

  public void setPrize(double prize) {
    this.prize = prize;
  }

  public double getDistance() {
    return distance;
  }

  public void setDistance(double distance) {
    this.distance = distance;
  }

  public int getMaximumVehicleCount() {
    return maximumVehicleCount;
  }

  public void setMaximumVehicleCount(int maximumVehicleCount) {
    this.maximumVehicleCount = maximumVehicleCount;
  }

  public List<Vehicle> getVehicles() {
    return vehicles;
  }

  public void setVehicles(List<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }

  public MedicalCar getMedicalCar() {
    return medicalCar;
  }

  public void setMedicalCar(MedicalCar medicalCar) {
    this.medicalCar = medicalCar;
  }

  public MedicalMotorbike getMedicalMotorbike() {
    return medicalMotorbike;
  }

  public void setMedicalMotorbike(MedicalMotorbike medicalMotorbike) {
    this.medicalMotorbike = medicalMotorbike;
  }

  public void registerCar(double velocity, double acceleration, double rotationAngle, String patent) {
    Vehicle vehicle = new Car(patent);

    vehicle.setVelocity(velocity);
    vehicle.setAcceleration(acceleration);
    vehicle.setRotationAngle(rotationAngle);
  }

  public void registerMotorbike(double velocity, double acceleration, double rotationAngle, String patent) {
    Vehicle vehicle = new Motorbike(patent);

    vehicle.setVelocity(velocity);
    vehicle.setAcceleration(acceleration);
    vehicle.setRotationAngle(rotationAngle);
  }

  public Optional<Vehicle> findByPlate(String plate) {
    return this.vehicles
      .stream()
      .filter(vehicle -> vehicle
        .getPlate()
        .equals(plate))
      .findFirst();
  }

  public void removeVehicle(Vehicle vehicle) {
    this.vehicles.remove(vehicle);
  }

  public void removeVehicleByPlate(String plate) {
    this.removeVehicle(
      this.findByPlate(plate)
        .orElse(null));
  }

  public Vehicle getWinner() {
    return this.vehicles
      .stream()
      .parallel()
      .collect(Collectors.toMap(
        Function.identity(),
        (vehicle -> vehicle.getVelocity() * vehicle.getAcceleration() /
          (vehicle.getRotationAngle() * (vehicle.getWeight() - vehicle.getWheelCount() * 100)))
      ))
      .entrySet()
      .stream()
      .max(Map.Entry.comparingByValue())
      .map(Map.Entry::getKey)
      .orElseThrow();
  }

  public void rescueCar(String plate) {
    this.findByPlate(plate)
      .ifPresent(vehicle -> this.medicalCar.rescue((Car) vehicle));
  }

  public void rescueMotorbike(String plate) {
    this.findByPlate(plate)
      .ifPresent(vehicle -> this.medicalMotorbike.rescue((Motorbike) vehicle));
  }
}

public class DakarApplication {
  public static void main(String[] args) {
    Car car = new Car("124");
    Motorbike motorbike = new Motorbike("242");

    MedicalCar medicalCar = new MedicalCar("001");
    MedicalMotorbike medicalMotorbike = new MedicalMotorbike("002");

    ArrayList<Vehicle> vehicles = new ArrayList<>();

    vehicles.add(car);
    vehicles.add(motorbike);

    Race race = new Race(
      "Monte Carlo",
      100000,
      10000,
      20,
      vehicles,
      medicalCar,
      medicalMotorbike);

    System.out.println("Winner:");

    try {
      System.out.println(race.getWinner());
    } catch (Exception exception) {
      System.err.println("none");
    }

    race.rescueCar("124");
    race.rescueMotorbike("242");
  }
}
