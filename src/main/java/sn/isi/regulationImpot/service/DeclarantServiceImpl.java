package sn.isi.regulationImpot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.isi.regulationImpot.entities.Declarant;
import sn.isi.regulationImpot.repository.DeclarantRepository;

import java.util.List;
@Service
public class DeclarantServiceImpl implements DeclarantService{

    @Autowired
    private DeclarantRepository declarantRepository;

    @Override
    public Declarant addDeclarant(Declarant declarant) {
        return declarantRepository.save(declarant);
    }

    @Override
    public List<Declarant> getAllDeclarants() {
        return declarantRepository.findAll();
    }

    @Override
    public boolean isRaisonSocialeUnique(String raisonSociale) {
        return declarantRepository.findByRaisonSociale(raisonSociale) == null;
    }

    @Override
    public boolean isEmailUnique(String email) {
        return declarantRepository.findByEmail(email) == null;
    }

    @Override
    public boolean isTelephoneUnique(String telephone) {
        return declarantRepository.findByTelephone(telephone) == null;
    }


}
