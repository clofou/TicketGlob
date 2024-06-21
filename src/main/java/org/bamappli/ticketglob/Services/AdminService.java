package org.bamappli.ticketglob.Services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bamappli.ticketglob.Entities.Administrateur;
import org.bamappli.ticketglob.Repositories.AdministrateurRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Getter
@Setter
@AllArgsConstructor
public class AdminService {
    private AdministrateurRepository adminRepository;

    public Administrateur creer(Administrateur admin){
        String motDePasse = admin.getMotDePasse();
        admin.setMotDePasse(new BCryptPasswordEncoder().encode(motDePasse));


        return adminRepository.save(admin);
    }

    public List<Administrateur> tout(){
        return adminRepository.findAll();
    }

    public Optional<Administrateur> unAdministrateur(Integer id){
        return adminRepository.findById(id);
    }

    public Administrateur misAjour(Integer id, @NotNull Administrateur updateAdministrateur){
        Optional<Administrateur> existingA = adminRepository.findById(id);
        if(existingA.isPresent()){
            Administrateur existingAdministrateur = existingA.get();
            existingAdministrateur.setEmail(updateAdministrateur.getEmail());
            existingAdministrateur.setNom(updateAdministrateur.getNom());
            existingAdministrateur.setPrenom(updateAdministrateur.getPrenom());
            adminRepository.save(existingAdministrateur);
        }


        return existingA.orElse(null);
    }

    public Administrateur updateAdministrateurPartial(Integer id, Administrateur updatedFields) {
        return adminRepository.findById(id)
                .map(admin -> {
                    if (updatedFields.getNom() != null) {
                        admin.setNom(updatedFields.getNom());
                    }
                    if (updatedFields.getPrenom() != null) {
                        admin.setPrenom(updatedFields.getPrenom());
                    }
                    if (updatedFields.getEmail() != null) {
                        admin.setEmail(updatedFields.getEmail());
                    }
                    return adminRepository.save(admin);
                })
                .orElseThrow(() -> new RuntimeException("Administrateur not found"));
    }

    public void effacer(Integer id){
        adminRepository.deleteById(id);
    }

}
