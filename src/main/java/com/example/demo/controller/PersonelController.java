package com.example.demo.controller;


import com.example.demo.model.Personel;
import com.example.demo.service.PersonelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personeller")
public class PersonelController {

    private final PersonelService service;

    public PersonelController(PersonelService service) {
        this.service = service;
    }

    @GetMapping
    public List<Personel> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Personel getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public Personel create(@RequestBody Personel personel) {
        return service.save(personel);
    }

    @PutMapping("/{id}")
    public Personel update(@PathVariable Long id, @RequestBody Personel personel) {
        personel.setId(id);
        return service.save(personel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
