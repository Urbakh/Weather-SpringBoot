package com.example.weather.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherObject {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long openWeatherObjectId;

    @JsonProperty(value = "id")
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    private Core main;

    private Integer visibility;

    @OneToOne(cascade = CascadeType.ALL)
    private Wind wind;

    private Integer timezone;

    private String name;

    private Integer cod;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Weather> weather;

    @Override
    public String toString() {
        return "OpenWeatherObject{" +
                "openWeatherObjectId=" + openWeatherObjectId +
                ", id=" + id +
                ", main=" + main +
                ", visibility=" + visibility +
                ", wind=" + wind +
                ", timezone=" + timezone +
                ", name='" + name + '\'' +
                ", cod=" + cod +
                ", weather=" + weather +
                '}';
    }
}