package com.example.demo.controller;


import com.example.demo.model.PersonelBirim;
import com.example.demo.service.PersonelBirimService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/birimler")
public class PersonelBirimController {

    private final PersonelBirimService service;

    public PersonelBirimController(PersonelBirimService service) {
        this.service = service;
    }

    @GetMapping
    public List<PersonelBirim> getAllBirim() {
        return service.getAllBirim();
    }

    @GetMapping("/{id}")
    public PersonelBirim getBirimById(@PathVariable Long id) {
        return service.getBirimById(id).orElse(null);
    }

    @PostMapping
    public PersonelBirim createBirim(@RequestBody PersonelBirim birim) {
        return service.saveBirim(birim);
    }

    @PutMapping("/{id}")
    public PersonelBirim updateBirim(@PathVariable Long id, @RequestBody PersonelBirim birim) {
        return service.updateBirim(id, birim);
    }

    @DeleteMapping("/{id}")
    public void deleteBirim(@PathVariable Long id) {
        service.deleteBirim(id);
    }
}
