package sn.isi.regulationImpot.service;

import sn.isi.regulationImpot.entities.Declarant;

import java.util.List;

public interface DeclarantService {
    Declarant addDeclarant(Declarant declarant);
    List<Declarant> getAllDeclarants();



    boolean isRaisonSocialeUnique(String raisonSociale);
    boolean isEmailUnique(String email);
    boolean isTelephoneUnique(String telephone);
}
