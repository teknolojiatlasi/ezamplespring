package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Personel;
import com.example.demo.service.AdresService;
import com.example.demo.service.PersonelBirimService;
import com.example.demo.service.PersonelService;

@Controller
@RequestMapping("/personeller")
public class PersonelWebController {

    private final PersonelService personelService;
    private final PersonelBirimService birimService;
    private final AdresService adresService;

    public PersonelWebController(PersonelService personelService,
                                 PersonelBirimService birimService,
                                 AdresService adresService) {
        this.personelService = personelService;
        this.birimService = birimService;
        this.adresService = adresService;
    }

    @GetMapping
    public String listele(Model model) {
        model.addAttribute("personeller", personelService.findAll());
        model.addAttribute("birimler", birimService.getAllBirim());
        model.addAttribute("adresler", adresService.getAllAdres());
        return "personeller";
    }

    @PostMapping
    public String kaydet(@ModelAttribute Personel personel) {
        personelService.save(personel);
        return "redirect:/personeller";
    }

    @PostMapping("/guncelle/{id}")
    public String guncelle(@PathVariable Long id, @ModelAttribute Personel personel) {
        personel.setId(id);
        personelService.save(personel); // save hem insert hem update yapar
        return "redirect:/personeller";
    }

    @GetMapping("/sil/{id}")
    public String sil(@PathVariable Long id) {
        personelService.deleteById(id);
        return "redirect:/personeller";
    }
}

