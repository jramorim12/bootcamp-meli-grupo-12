package com.danilopeixoto.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class HouseMeasurementRequest {
  @NotEmpty(message = "The name field is required.")
  @JsonProperty("name")
  private String name;

  @NotEmpty(message = "The address field is required.")
  @JsonProperty("address")
  private String address;

  @Valid
  @NotEmpty(message = "The rooms field requires at least a single room.")
  @JsonProperty("rooms")
  private List<RoomRequest> rooms;

  public HouseMeasurementRequest() {
  }

  public HouseMeasurementRequest(String name, String address, List<RoomRequest> rooms) {
    this.name = name;
    this.address = address;
    this.rooms = rooms;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public List<RoomRequest> getRooms() {
    return this.rooms;
  }

  public void setRooms(List<RoomRequest> rooms) {
    this.rooms = rooms;
  }
}
