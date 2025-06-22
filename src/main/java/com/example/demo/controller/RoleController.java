package com.example.demo.controller;



import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/roles")
public class RoleController {

    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping
    public String listRoles(Model model) {
        List<Role> roles = roleRepository.findAll();
        model.addAttribute("roles", roles);
        return "admin/role-list";
    }

    @GetMapping("/new")
    public String newRoleForm(Model model) {
        model.addAttribute("role", new Role());
        return "admin/role-form";
    }

    @PostMapping("/save")
    public String saveRole(@ModelAttribute Role role) {
        roleRepository.save(role);
        return "redirect:/admin/roles";
    }

    @GetMapping("/edit/{id}")
    public String editRoleForm(@PathVariable Long id, Model model) {
        Role role = roleRepository.findById(id)
                      .orElseThrow(() -> new IllegalArgumentException("Role bulunamadı: " + id));
        model.addAttribute("role", role);
        return "admin/role-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteRole(@PathVariable Long id) {
        roleRepository.deleteById(id);
        return "redirect:/admin/roles";
    }
}

