package sn.isi.regulationImpot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Declarant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String raisonSociale;

    private String adresse;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String telephone;

    @OneToMany(mappedBy = "declarant")
    private List<Declaration> declarations;


}
