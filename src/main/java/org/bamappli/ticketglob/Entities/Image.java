package org.bamappli.ticketglob.Entities;

import jakarta.persistence.*;
import lombok.Data;
import org.bamappli.ticketglob.Entities.Enum.FormatImage;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Image implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String url;
    private String nom;
    @Column(nullable = false)
    private Date dateDeCreation;
    private FormatImage formatImage;

    @ManyToMany
    @JoinTable(
            name = "ticket_image",
            joinColumns = @JoinColumn(name = "image_id"),
            inverseJoinColumns = @JoinColumn(name = "ticket_id")
    )
    private List<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "reponse_id")
    private Reponse reponse;
}
