package org.bamappli.ticketglob.Controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bamappli.ticketglob.Entities.Formateur;
import org.bamappli.ticketglob.Services.FormateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/formateurs")
@Getter
@Setter
@AllArgsConstructor
public class FormateurController {
    FormateurService formateurService;

    @PostMapping
    public Formateur create(@RequestBody Formateur formateur) {
        return formateurService.creer(formateur);
    }

    @GetMapping
    public List<Formateur> getAll() {
        return formateurService.tout();
    }
    @GetMapping("/{id}")
    public Optional<Formateur> getOne(@PathVariable Integer id) {
        return formateurService.unFormateur(id);
    }

    @PutMapping("/{id}")
    public Formateur update(@PathVariable Integer id, @RequestBody Formateur formateur) {
        return formateurService.misAjour(id, formateur);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        formateurService.effacer(id);
    }

    @PatchMapping("/{id}")
    public Formateur patch(@PathVariable Integer id, @RequestBody Formateur formateur) {
        return formateurService.updateFormateurPartial(id, formateur);
    }

}
