package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Adres;
import com.example.demo.service.AdresService;

@RestController
@RequestMapping("/adresler/api")
public class AdresRestController {

    private final AdresService adresService;

    public AdresRestController(AdresService adresService) {
        this.adresService = adresService;
    }

    @GetMapping
    public List<Adres> getAll() {
        return adresService.getAllAdres();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Adres> getById(@PathVariable Long id) {
        return adresService.getAdresById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Adres save(@RequestBody Adres adres) {
        return adresService.saveAdres(adres);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Adres> update(@PathVariable Long id, @RequestBody Adres adres) {
        if (adresService.getAdresById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(adresService.updateAdres(id, adres));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        adresService.deleteAdres(id);
        return ResponseEntity.noContent().build();
    }
}
