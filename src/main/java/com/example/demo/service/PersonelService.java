package com.example.demo.service;



import com.example.demo.model.Personel;
import com.example.demo.repository.PersonelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonelService {

    private final PersonelRepository repository;

    public PersonelService(PersonelRepository repository) {
        this.repository = repository;
    }

    public List<Personel> findAll() {
        return repository.findAll();
    }

    public Optional<Personel> findById(Long id) {
        return repository.findById(id);
    }

    public Personel save(Personel personel) {
        return repository.save(personel);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

