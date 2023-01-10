package com.example.weather.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeneralWeather {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer temp;

    private Integer feelslike;

    private Integer hudminity;

    private Integer windKph;

    private Double pressure;

    private String localtimes;

    private Double gustKph;

    private String description;

    private Integer visibility;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private OpenWeatherObject openWeatherObject;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private WeatherApiObject weatherApiObject;

    @Override
    public String toString() {
        return "GeneralWeather{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", temp=" + temp +
                ", feelslike=" + feelslike +
                ", hudminity=" + hudminity +
                ", windKph=" + windKph +
                ", pressure=" + pressure +
                ", localtimes='" + localtimes + '\'' +
                ", gustKph=" + gustKph +
                ", description='" + description + '\'' +
                ", visibility=" + visibility +
                '}';
    }
}
