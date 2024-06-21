package org.bamappli.ticketglob.Repositories;

import org.bamappli.ticketglob.Entities.Personne;
import org.bamappli.ticketglob.Entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
    @Query("select p from Personne p where p.email=:x")
    Personne findByEmail(@Param("x")String email);
    @Query("select p.roles from Personne p where p.email=:x")
    Set<Roles> findRolesByEmail(@Param("x") String email);
}
