package com.example.weather.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Wind {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long windId;

    @JsonProperty("speed")
    private Integer speed;

    @JsonProperty("deg")
    private Integer deg;

    @Override
    public String toString() {
        return "Wind{" +
                "id=" + windId +
                ", speed=" + speed +
                ", deg=" + deg +
                '}';
    }
}
