package com.cats.itau.mapper;

import com.cats.itau.model.Breed;
import com.cats.itau.model.BreedApi;
import com.cats.itau.vo.BreedDetailVO;
import com.cats.itau.vo.BreedVO;

public class BreedMapper {

    public static BreedDetailVO mapBreedToBreedVO(Breed breed) {
        return new BreedDetailVO(breed.getId(), breed.getName(), breed.getOrigin(), breed.getTemperament());
    }

    public static BreedVO mapBreedToBreedListVO(Breed breed) {
        return new BreedVO(breed.getId(), breed.getName());
    }

    public static Breed mapBreedApiToBreed(BreedApi breed) {
        return new Breed(Long.getLong(breed.getId()), breed.getName(), breed.getOrigin(), breed.getTemperament(), null, null);
    }
}
