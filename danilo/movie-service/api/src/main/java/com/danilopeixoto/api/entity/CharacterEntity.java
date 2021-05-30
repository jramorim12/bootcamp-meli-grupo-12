package com.danilopeixoto.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Character")
@Entity
public class CharacterEntity {
  @NotBlank(message = "The name field is required.")
  @JsonProperty("name")
  @Column(name = "name")
  @Id
  private String name;

  @Min(value = 0, message = "The height field requires positive numbers.")
  @JsonProperty("height")
  @Column(name = "height")
  private Double height;

  @Min(value = 0, message = "The mass field requires positive numbers.")
  @JsonProperty("mass")
  @Column(name = "mass")
  private Double mass;

  @JsonProperty("hair_color")
  @Column(name = "hair_color")
  private String hairColor;

  @JsonProperty("skin_color")
  @Column(name = "skin_color")
  private String skinColor;

  @JsonProperty("eye_color")
  @Column(name = "eye_color")
  private String eyeColor;

  @JsonProperty("birth_year")
  @Column(name = "birth_year")
  private String birthYear;

  @JsonProperty("gender")
  @Column(name = "gender")
  private String gender;

  @JsonProperty("home_world")
  @Column(name = "homeworld")
  private String homeWorld;

  @JsonProperty("species")
  @Column(name = "species")
  private String species;
}
