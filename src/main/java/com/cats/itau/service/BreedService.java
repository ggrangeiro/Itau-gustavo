package com.cats.itau.service;

import com.cats.itau.vo.BreedDetailVO;
import com.cats.itau.model.Breed;
import com.cats.itau.vo.BreedVO;

import java.util.List;

public interface BreedService {
    List<BreedVO> getAllBreeds();

    BreedDetailVO getBreedById(Long breedId);

    List<BreedVO> getBreedsByOrigin(String origin);

    List<BreedVO> getBreedsByTemperament(String temperament);

    BreedDetailVO saveBreed(Breed breed);

    BreedDetailVO populateBreeds();
}
