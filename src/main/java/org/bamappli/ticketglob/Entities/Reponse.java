package org.bamappli.ticketglob.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Reponse implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String text;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    //@OneToMany(mappedBy = "reponse")
    //private List<Image> images;

    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private Formateur formateur;

    //@OneToOne(mappedBy = "reponse")
    //private BDC bdc;

}
