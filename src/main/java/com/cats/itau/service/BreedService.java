package com.cats.itau.service;

import com.cats.itau.vo.BreedVO;
import com.cats.itau.model.Breed;

import java.util.List;

public interface BreedService {
    List<BreedVO> getAllBreeds();

    Breed getBreedById(Long breedId);

    List<BreedVO> getBreedsByOrigin(String origin);

    List<BreedVO> getBreedsByTemperament(String temperament);

    Breed saveBreed(Breed breed);

    Breed populateBreeds();
}
