package org.bamappli.ticketglob.Repositories;
import org.bamappli.ticketglob.Entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PersonneRepository extends JpaRepository<Personne, Long> {
    @Query("select p from Personne p where p.username=:x")
    Personne findPersonneByUsername(@Param("x") String username);
}
