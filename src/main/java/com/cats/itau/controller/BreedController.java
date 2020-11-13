package com.cats.itau.controller;

import com.cats.itau.model.Breed;
import com.cats.itau.service.BreedService;
import com.cats.itau.vo.BreedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cats")
public class BreedController {
    @Autowired
    private BreedService breedService;

    @GetMapping(path = "/breed")
    public ResponseEntity<List<BreedVO>> getAllBreeds() {
        List<BreedVO> breedList = breedService.getAllBreeds();
        if (breedList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(breedService.getAllBreeds());
    }

    @GetMapping(path = "/breed/{breedId}")
    public ResponseEntity<Breed> getBreedById(@PathVariable("breedId") Long breedId) {
        Breed breed = breedService.getBreedById(breedId);

        if (breed.getId() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(breed);
    }

    @GetMapping(path = "/temperament/{temperamentBreed}")
    public ResponseEntity<List<BreedVO>> getBreedByTreatment(@PathVariable("temperamentBreed") String temperamentBreed) {
        List<BreedVO> breed = breedService.getBreedsByTemperament(temperamentBreed);
        if (breed == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(breed);
    }

    @GetMapping(path = "/origin/{origin}")
    public ResponseEntity<List<BreedVO>> getBreedByOrigin(@PathVariable("origin") String origin) {
        List<BreedVO> breed = breedService.getBreedsByOrigin(origin);
        if (breed == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(breed);
    }

    @GetMapping(path = "load")
    public ResponseEntity<Breed> populateBreeds() {
        return ResponseEntity.ok(breedService.populateBreeds());
    }

    @PostMapping("/breed")
    Breed save(@RequestBody Breed breed) {
        return breedService.saveBreed(breed);
    }
}
