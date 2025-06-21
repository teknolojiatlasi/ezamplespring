package com.example.demo.controller;



import com.example.demo.model.Personel;
import com.example.demo.model.PersonelBirim;
import com.example.demo.model.Adres;
import com.example.demo.service.PersonelService;
import com.example.demo.service.PersonelBirimService;
import com.example.demo.service.AdresService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/personeller")
public class PersonelWebController {

    private final PersonelService personelService;
    private final PersonelBirimService birimService;
    private final AdresService adresService;

    public PersonelWebController(PersonelService personelService, PersonelBirimService birimService, AdresService adresService) {
        this.personelService = personelService;
        this.birimService = birimService;
        this.adresService = adresService;
    }

    @GetMapping
    public String listPersoneller(Model model) {
        model.addAttribute("personeller", personelService.findAll());
        return "personeller";
    }

    @GetMapping("/yeni")
    public String showCreateForm(Model model) {
        model.addAttribute("personel", new Personel());
        model.addAttribute("birimler", birimService.getAllBirim());
        model.addAttribute("adresler", adresService.getAllAdres());  // <== Burada adresler modele eklendi
        return "personel-form";
    }


    @PostMapping
    public String savePersonel(@ModelAttribute("personel") Personel personel) {
        // Formdan gelen adres ID'sini al
        Long adresId = personel.getAdres().getId();

        // Adresi veritabanından getir
        Adres adres = adresService.findById(adresId);

        // Gerçek bağlı entity ile set et
        personel.setAdres(adres);

        personelService.save(personel);
        return "redirect:/personeller";
    }


    @GetMapping("/sil/{id}")
    public String deletePersonel(@PathVariable Long id) {
        personelService.deleteById(id);
        return "redirect:/personeller";
    }
}
