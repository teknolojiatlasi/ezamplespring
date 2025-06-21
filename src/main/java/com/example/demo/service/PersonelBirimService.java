package com.example.demo.service;


import com.example.demo.model.PersonelBirim;
import com.example.demo.repository.PersonelBirimRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonelBirimService {

    private final PersonelBirimRepository repository;

    public PersonelBirimService(PersonelBirimRepository repository) {
        this.repository = repository;
    }

    public List<PersonelBirim> getAllBirim() {
        return repository.findAll();
    }

    public Optional<PersonelBirim> getBirimById(Long id) {
        return repository.findById(id);
    }

    public PersonelBirim saveBirim(PersonelBirim birim) {
        return repository.save(birim);
    }

    public PersonelBirim updateBirim(Long id, PersonelBirim birim) {
        birim.setId(id);
        return repository.save(birim);
    }

    public void deleteBirim(Long id) {
        repository.deleteById(id);
    }
}

