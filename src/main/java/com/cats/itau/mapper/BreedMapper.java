package com.cats.itau.mapper;

import com.cats.itau.model.Breed;
import com.cats.itau.model.BreedApi;
import com.cats.itau.vo.BreedVO;

public class BreedMapper {

    public static BreedVO mapBreedToBreedDTO(Breed breed) {
        return new BreedVO(breed.getId(), breed.getName(), breed.getOrigin(), breed.getTemperament());
    }

    public static Breed mapBreedApiToBreed(BreedApi breed) {
        return new Breed(Long.getLong(breed.getId()), breed.getName(), breed.getOrigin(), breed.getTemperament(), null, null);
    }
}
