package sn.isi.regulationImpot.service;

import sn.isi.regulationImpot.entities.Declaration;

import java.util.List;

public interface DeclarationService {
    Declaration addDeclaration(Declaration declaration);
    List<Declaration> getAllDeclarations();

    Declaration getDeclarationById(Long id);
}
