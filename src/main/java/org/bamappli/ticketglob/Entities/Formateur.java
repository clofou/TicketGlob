package org.bamappli.ticketglob.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Formateur extends Personne implements Serializable {

    @Column(length = 50)
    private String specialite;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Administrateur admin;

    @OneToMany(mappedBy = "formateur")
    private List<Apprenant> apprenants;

    @OneToMany(mappedBy = "formateur")
    private List<Reponse> reponses;

    @OneToMany(mappedBy = "formateur")
    private List<BDC> bdcs;



}
