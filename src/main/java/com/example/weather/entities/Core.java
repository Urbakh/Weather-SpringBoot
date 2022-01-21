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
public class Core {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coreId;

    @JsonProperty("temp")
    private Integer temp;

    @JsonProperty("feels_like")
    private Integer feelslike;

    @JsonProperty("pressure")
    private Double pressure;

    @JsonProperty("humidity")
    private Integer humidity;

    @Override
    public String toString() {
        return "Core{" +
                "coreId=" + coreId +
                ", temp=" + temp +
                ", feelsLike=" + feelslike +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                '}';
    }
}
