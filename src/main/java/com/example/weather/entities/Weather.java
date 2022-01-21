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
public class Weather {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long weatherId;

    @JsonProperty(value = "id")
    private Integer id;

    @JsonProperty("main")
    private String sky;

    @JsonProperty("description")
    private String description;

    @Override
    public String toString() {
        return "Weather{" +
                "weatherId=" + weatherId +
                ", id=" + id +
                ", sky='" + sky + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
