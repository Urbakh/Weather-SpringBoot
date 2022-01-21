package com.example.weather.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherApiObject {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Location location;

    @OneToOne(cascade = CascadeType.ALL)
    private Current current;

    @Override
    public String toString() {
        return "WeatherApiObject{" +
                "id=" + id +
                ", location=" + location +
                ", current=" + current +
                '}';
    }
}
