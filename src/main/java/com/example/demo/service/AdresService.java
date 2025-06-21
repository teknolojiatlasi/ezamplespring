package com.example.demo.service;


import com.example.demo.model.Adres;
import com.example.demo.repository.AdresRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdresService {

    private final AdresRepository adresRepository;

    public AdresService(AdresRepository adresRepository) {
        this.adresRepository = adresRepository;
    }

    public List<Adres> getAllAdres() {
        return adresRepository.findAll();
    }

    public Optional<Adres> getAdresById(Long id) {
        return adresRepository.findById(id);
    }

    public Adres saveAdres(Adres adres) {
        return adresRepository.save(adres);
    }

    public Adres updateAdres(Long id, Adres adres) {
        adres.setId(id);
        return adresRepository.save(adres);
    }

    public void deleteAdres(Long id) {
        adresRepository.deleteById(id);
    }
    
    public Adres findById(Long id) {
        return adresRepository.findById(id).orElseThrow(() -> new RuntimeException("Adres bulunamadı"));
    }

}
