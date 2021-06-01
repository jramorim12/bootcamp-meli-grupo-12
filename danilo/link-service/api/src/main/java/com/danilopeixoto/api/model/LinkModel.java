package com.danilopeixoto.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table("Link")
public class LinkModel {
  @NotNull(message = "The id field is required.")
  @JsonProperty("id")
  @Column("id")
  @Id
  private UUID id;

  @NotBlank(message = "The URL field is required.")
  @JsonProperty("url")
  @Column("url")
  @URL(protocol = "https", message = "The URL field requires a valid URL.")
  private String url;

  @NotBlank(message = "The passcode field is required.")
  @Length(min = 8, message = "The passcode field requires a length greater than or equal to 8.")
  @JsonProperty("passcode")
  @Column("passcode")
  private String passcode;

  @NotNull(message = "The redirects field is required.")
  @Min(value = 0, message = "The redirects field requires positive integers.")
  @JsonProperty("redirects")
  @Column("redirects")
  private Integer redirects;
}
