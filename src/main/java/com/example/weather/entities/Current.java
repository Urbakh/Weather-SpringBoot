package com.example.weather.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Current {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty(value = "temp_c")
    private Integer tempC;

    @ManyToOne(cascade = CascadeType.ALL)
    private Condition condition;

    @JsonProperty(value = "wind_kph")
    private Integer windKph;

    @JsonProperty(value = "pressure_mb")
    private Double pressureMb;

    @JsonProperty(value = "humidity")
    private Integer humidity;

    @JsonProperty(value = "feelslike_c")
    private Integer feelslikeC;

    @JsonProperty(value = "gust_kph")
    private Double gustKph;

    @Override
    public String toString() {
        return "Current{" +
                "id=" + id +
                ", tempC=" + tempC +
                ", condition=" + condition +
                ", windKph=" + windKph +
                ", pressureMb=" + pressureMb +
                ", humidity=" + humidity +
                ", feelslikeC=" + feelslikeC +
                ", gustKph=" + gustKph +
                '}';
    }
}
