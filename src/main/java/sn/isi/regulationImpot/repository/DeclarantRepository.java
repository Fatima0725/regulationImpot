package sn.isi.regulationImpot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.isi.regulationImpot.entities.Declarant;

@Repository
public interface DeclarantRepository extends JpaRepository<Declarant, Long> {
    boolean existsByRaisonSociale(String raisonSociale);

    boolean existsByEmail(String email);

    boolean existsByTelephone(String telephone);

    Declarant findByRaisonSociale(String raisonSociale);

    Declarant findByTelephone(String telephone);

    Declarant findByEmail(String email);
}
