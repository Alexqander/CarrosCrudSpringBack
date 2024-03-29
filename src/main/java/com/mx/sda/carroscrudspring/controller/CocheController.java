package com.mx.sda.carroscrudspring.controller;

import com.mx.sda.carroscrudspring.model.Coche;
import com.mx.sda.carroscrudspring.model.CocheDto;
import com.mx.sda.carroscrudspring.services.CocheService;
import com.mx.sda.carroscrudspring.utils.Mesage;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sda/coche")
@CrossOrigin(origins = {"*"})
public class CocheController {
    @Autowired
    CocheService cocheService;
    @GetMapping("/")
    public ResponseEntity<Mesage> getAll() {return cocheService.findAll();}
    @GetMapping("/{id}")
    public ResponseEntity<Mesage>getById(@PathVariable("id") long id){
        return cocheService.findCoche(id);
    }
    @PostMapping("/")
    public ResponseEntity<Mesage>createCoche(@Valid @RequestBody CocheDto cocheDto ){
        Coche coche = new Coche(
                cocheDto.getId(),
                cocheDto.getMarca(),
                cocheDto.getModelo(),
                cocheDto.getActivo(),
                cocheDto.getPrecio(),
                cocheDto.getColor(),
                cocheDto.getAnio());
        return cocheService.save(coche);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Mesage> updateCoche( @PathVariable("id") long id ,  @Valid @RequestBody CocheDto cocheDto){
        Coche coche = new Coche(
                cocheDto.getId(),
                cocheDto.getMarca(),
                cocheDto.getModelo(),
                cocheDto.getActivo(),
                cocheDto.getPrecio(),
                cocheDto.getColor(),
                cocheDto.getAnio());
        return cocheService.updateCoche(id,coche);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Mesage>deleteById(@PathVariable("id") long id){
        return cocheService.deleteCoche(id);
    }



}
