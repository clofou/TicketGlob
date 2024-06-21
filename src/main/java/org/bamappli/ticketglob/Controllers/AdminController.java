package org.bamappli.ticketglob.Controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bamappli.ticketglob.Entities.Administrateur;
import org.bamappli.ticketglob.Entities.Roles;
import org.bamappli.ticketglob.Services.AdminService;
import org.bamappli.ticketglob.Services.PersonneRoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/admin")
@Getter
@Setter
@AllArgsConstructor
public class AdminController {
    AdminService adminService;
    PersonneRoleService personneRoleService;

    @PostMapping
    public Administrateur create(@RequestBody Administrateur admin) {
        Administrateur administrateur = adminService.creer(admin);
        Roles role = new Roles();
        role.setRole("ADMIN");
        administrateur.setRoles(Set.of(role));
        adminService.updateAdministrateurPartial(administrateur.getId(), administrateur);
        return administrateur;
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


