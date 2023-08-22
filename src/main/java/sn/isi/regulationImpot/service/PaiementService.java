package sn.isi.regulationImpot.service;

import sn.isi.regulationImpot.entities.Paiement;

import java.util.List;

public interface PaiementService {
    Paiement addPaiement(Paiement paiement);
    List<Paiement> getAllPaiements();
}
