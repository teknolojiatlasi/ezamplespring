package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.PersonelBirim;
import com.example.demo.service.PersonelBirimService;
@Controller
@RequestMapping("/birimler")
public class PersonelBirimWebController {

    private final PersonelBirimService birimService;

    public PersonelBirimWebController(PersonelBirimService birimService) {
        this.birimService = birimService;
    }

    @GetMapping
    public String listele(Model model) {
        model.addAttribute("birimler", birimService.getAllBirim());
        return "personelbirimler";
    }

    @PostMapping
    public String kaydet(@ModelAttribute PersonelBirim birim) {
        birimService.saveBirim(birim);
        return "redirect:/birimler";
    }

    @PostMapping("/guncelle/{id}")
    public String guncelle(@PathVariable Long id, @ModelAttribute PersonelBirim birim) {
        birimService.updateBirim(id, birim);
        return "redirect:/birimler";
    }

    @GetMapping("/sil/{id}")
    public String sil(@PathVariable Long id) {
        birimService.deleteBirim(id);
        return "redirect:/birimler";
    }
}
