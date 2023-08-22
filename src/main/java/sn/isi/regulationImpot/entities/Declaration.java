package sn.isi.regulationImpot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Declaration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateDeclaration;
    private double montantDeclaration;

    @ManyToOne
    @JoinColumn(name = "id_declarant")
    private Declarant declarant;

    @OneToMany(mappedBy = "declaration")
    private List<Paiement> paiement;

    public double getMontantDeclaration() {
        return this.montantDeclaration;
    }
}
