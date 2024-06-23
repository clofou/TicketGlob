package org.bamappli.ticketglob.Controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bamappli.ticketglob.Entities.Administrateur;
import org.bamappli.ticketglob.Services.AdminService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@Getter
@Setter
@AllArgsConstructor
public class AdminController {
    private final BCryptPasswordEncoder passwordEncoder;
    AdminService adminService;


    @PostMapping
    public Administrateur create(@RequestBody Administrateur admin) {
        return adminService.creer(admin);
    }

    @GetMapping
    public List<Administrateur> getAll() {
        return adminService.tout();
    }
    @GetMapping("/{id}")
    public Optional<Administrateur> getOne(@PathVariable Integer id) {
        return adminService.unAdministrateur(id);
    }

    @PutMapping("/{id}")
    public Administrateur update(@PathVariable Integer id, @RequestBody Administrateur admin) {
        return adminService.misAjour(id, admin);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        adminService.effacer(id);
    }

}


