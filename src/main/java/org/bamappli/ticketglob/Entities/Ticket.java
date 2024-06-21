package org.bamappli.ticketglob.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.bamappli.ticketglob.Entities.Enum.Priorite;
import org.bamappli.ticketglob.Entities.Enum.Statut;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 80)
    private String titre;
    private String description;
    private Statut statut;
    private Priorite priorite;

    @ManyToOne
    @JoinColumn(name = "apprenant_id")
    //@JsonBackReference
    private Apprenant apprenant;

    //@ManyToMany(mappedBy = "tickets")
    //private List<Categorie> categorieList;

    //@ManyToMany(mappedBy = "tickets")
    //private List<Image> imageList;

    //@OneToMany(mappedBy = "ticket")
    //private List<Reponse> reponses;



}
