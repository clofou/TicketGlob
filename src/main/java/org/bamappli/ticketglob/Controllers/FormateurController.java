package org.bamappli.ticketglob.Controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bamappli.ticketglob.Entities.Apprenant;
import org.bamappli.ticketglob.Entities.BDC;
import org.bamappli.ticketglob.Entities.Reponse;
import org.bamappli.ticketglob.Services.ApprenantService;
import org.bamappli.ticketglob.Services.BdcService;
import org.bamappli.ticketglob.Services.ReponseService;
import org.bamappli.ticketglob.Services.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/formateur")
@Getter
@Setter
@AllArgsConstructor
public class FormateurController {
    ApprenantService apprenantService;
    ReponseService reponseService;
    TicketService ticketService;
    BdcService bdcService;

    // Ajout , suppresion et Modification d'un compte Apprenant
    @PostMapping("/apprenants")
    public Apprenant createApprenant(@RequestBody Apprenant apprenant) {
        return apprenantService.creer(apprenant);
    }

    @GetMapping("/apprenants")
    public List<Apprenant> getAllApprenant() {
        return apprenantService.tout();
    }
    @GetMapping("/apprenants/{id}")
    public Optional<Apprenant> getOneApprenant(@PathVariable Integer id) {
        return apprenantService.unApprenant(id);
    }

    @PutMapping("/apprenants/{id}")
    public Apprenant updateApprenant(@PathVariable Integer id, @RequestBody Apprenant apprenant) {
        return apprenantService.misAjour(id, apprenant);
    }

    @DeleteMapping("/apprenants/{id}")
    public void deleteApprenant(@PathVariable Integer id) {
        apprenantService.effacer(id);
    }

    // Gestion de Reponse au Ticket
    @PostMapping("/reponses")
    public Reponse createReponse(@RequestBody Reponse reponse) {
        return reponseService.creer(reponse);
    }

    @GetMapping("/reponses")
    public List<Reponse> getAll() {
        return reponseService.tout();
    }
    @GetMapping("/reponses/{id}")
    public Optional<Reponse> getOne(@PathVariable Integer id) {
        return reponseService.unReponse(id);
    }

    @PutMapping("/reponses/{id}")
    public Reponse update(@PathVariable Integer id, @RequestBody Reponse reponse) {
        return reponseService.misAjour(id, reponse);
    }

    @DeleteMapping("/reponses/{id}")
    public void delete(@PathVariable Integer id) {
        reponseService.effacer(id);
    }

    @GetMapping("/ticket/statut/{id}/{nouveauStatut}")
    public String updateStatutTicket(@PathVariable Long id, @PathVariable Integer nouveauStatut) {
        ticketService.updateStatut(id, nouveauStatut);
        return "Statut Mise à Jour";
    }

    // Remplissage et gestion de la base de connaissance
    @PostMapping("/bdc")
    public BDC createQuestionforBDC(@RequestBody BDC bdc) {
        return bdcService.creer(bdc);
    }
    @GetMapping("/bdc")
    public List<BDC> getAllQuestionfromBdc() {
        return bdcService.tout();
    }
    @GetMapping("/bdc/{id}")
    public Optional<BDC> getOneQuestionFromBdc(@PathVariable Integer id) {
        return bdcService.unBDC(id);
    }
    @PutMapping("/bdc/{id}")
    public BDC updateQuestionFromBdc(@PathVariable Integer id, @RequestBody BDC bdc) {
        return bdcService.misAjour(id, bdc);
    }
    @DeleteMapping("/bdc/{id}")
    public void deleteQuestionFromBdc(@PathVariable Integer id) {
        bdcService.effacer(id);
    }

}
