package org.bamappli.ticketglob.Services;

import lombok.AllArgsConstructor;
import org.bamappli.ticketglob.Entities.Personne;
import org.bamappli.ticketglob.Entities.Roles;
import org.bamappli.ticketglob.Repositories.PersonneRepository;
import org.bamappli.ticketglob.Repositories.RolesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class PersonneRoleService {


    private PersonneRepository personneRepository;


    private RolesRepository roleRepository;

    public void associerRole(String email, Integer roleId) {
        Personne personneOpt = personneRepository.findByEmail(email);
        Optional<Roles> roleOpt = roleRepository.findById(roleId);

        roleOpt.ifPresent(role -> {
            personneOpt.getRoles().add(role);
        });
    }
}
