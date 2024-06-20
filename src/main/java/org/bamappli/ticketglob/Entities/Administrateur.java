package org.bamappli.ticketglob.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Administrateur extends Personne implements Serializable {
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Formateur> formateurs;
}