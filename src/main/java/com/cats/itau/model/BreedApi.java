package com.cats.itau.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BreedApi implements Serializable {
    private String id;
    private String name;
    private String origin;
    private String temperament;
}