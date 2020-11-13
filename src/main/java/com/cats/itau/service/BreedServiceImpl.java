package com.cats.itau.service;

import com.cats.itau.mapper.BreedMapper;
import com.cats.itau.model.Breed;
import com.cats.itau.model.BreedApi;
import com.cats.itau.service.repository.BreedRepository;
import com.cats.itau.vo.BreedDetailVO;
import com.cats.itau.vo.BreedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BreedServiceImpl implements BreedService {

    @Autowired
    private BreedRepository breedRepository;

    @Override
    public List<BreedVO> getAllBreeds() {
        return breedRepository.findAll().stream().map(BreedMapper::mapBreedToBreedListVO).collect(Collectors.toList());
    }

    @Override
    public BreedDetailVO getBreedById(Long breedId) {
        Optional<Breed> a = breedRepository.findById(breedId);
        try {
            return BreedMapper.mapBreedToBreedVO(a.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BreedDetailVO();
    }

    @Override
    public List<BreedVO> getBreedsByOrigin(String origin) {
        return breedRepository.findAll().stream().filter(breed -> {
            return breed.getOrigin().equals(origin);
        }).map(BreedMapper::mapBreedToBreedListVO).collect(Collectors.toList());
    }

    @Override
    public List<BreedVO> getBreedsByTemperament(String temperament) {
        return breedRepository.findAll().stream().filter(breed -> {
            return breed.getTemperament().contains(temperament);
        }).map(BreedMapper::mapBreedToBreedListVO).collect(Collectors.toList());
    }

    @Override
    public BreedDetailVO saveBreed(Breed breed) {
        Breed savedBreed = breedRepository.save(breed);
        return BreedMapper.mapBreedToBreedVO(savedBreed);
    }

    @Override
    public BreedDetailVO populateBreeds() {
        WebClient client3 = WebClient
                .builder()
                .baseUrl("https://api.thecatapi.com/v1")
                .defaultHeader("x-api-key", "0cd3bc76-5217-4c75-ab4e-b6376199f981")
                .build();
        Flux<BreedApi> response = client3.get()
                .uri("/breeds")
                .retrieve()
                .bodyToFlux(BreedApi.class);

        Stream<BreedDetailVO> breedStream = Objects.requireNonNull(response.collectList().block()).stream().map(breedApi -> {
            return saveBreed(BreedMapper.mapBreedApiToBreed(breedApi));
        });

        return breedStream.findFirst().get();
    }
}
