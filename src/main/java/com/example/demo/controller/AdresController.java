package com.example.demo.controller;



import com.example.demo.model.Adres;
import com.example.demo.service.AdresService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adresler")
public class AdresController {

    private final AdresService adresService;

    public AdresController(AdresService adresService) {
        this.adresService = adresService;
    }

    @GetMapping
    public List<Adres> getAllAdres() {
        return adresService.getAllAdres();
    }

    @GetMapping("/{id}")
    public Adres getAdresById(@PathVariable Long id) {
        return adresService.getAdresById(id).orElse(null);
    }

    @PostMapping
    public Adres createAdres(@RequestBody Adres adres) {
        return adresService.saveAdres(adres);
    }

    @PutMapping("/{id}")
    public Adres updateAdres(@PathVariable Long id, @RequestBody Adres adres) {
        return adresService.updateAdres(id, adres);
    }

    @DeleteMapping("/{id}")
    public void deleteAdres(@PathVariable Long id) {
        adresService.deleteAdres(id);
    }
}

