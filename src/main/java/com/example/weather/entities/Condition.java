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
public class Condition {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty(value = "text")
    private String text;

    @Override
    public String toString() {
        return "Condition{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
