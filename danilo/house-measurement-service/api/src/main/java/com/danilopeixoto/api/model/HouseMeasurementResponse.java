package com.danilopeixoto.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class HouseMeasurementResponse {
  @NotNull(message = "The area field is required.")
  @Min(value = 0, message = "The area field requires positive numbers.")
  @JsonProperty("area")
  private Double area;

  @NotNull(message = "The market value field is required.")
  @Min(value = 0, message = "The market value field requires positive numbers.")
  @JsonProperty("market_value")
  private Double marketValue;

  @NotNull(message = "The larger room field is required.")
  @JsonProperty("larger_room")
  private RoomResponse largerRoom;

  @Valid
  @NotEmpty(message = "The room areas field requires at least a single room.")
  @JsonProperty("room_areas")
  private List<RoomResponse> roomAreas;

  public HouseMeasurementResponse() {
  }

  public HouseMeasurementResponse(Double area, Double marketValue, RoomResponse largerRoom, List<RoomResponse> roomAreas) {
    this.area = area;
    this.marketValue = marketValue;
    this.largerRoom = largerRoom;
    this.roomAreas = roomAreas;
  }

  public Double getArea() {
    return this.area;
  }

  public void setArea(Double area) {
    this.area = area;
  }

  public Double getMarketValue() {
    return this.marketValue;
  }

  public void setMarketValue(Double marketValue) {
    this.marketValue = marketValue;
  }

  public RoomResponse getLargerRoom() {
    return this.largerRoom;
  }

  public void setLargerRoom(RoomResponse largerRoom) {
    this.largerRoom = largerRoom;
  }

  public List<RoomResponse> getRoomAreas() {
    return this.roomAreas;
  }

  public void setRoomAreas(List<RoomResponse> roomAreas) {
    this.roomAreas = roomAreas;
  }
}
