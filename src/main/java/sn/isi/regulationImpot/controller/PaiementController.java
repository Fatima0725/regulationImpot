package sn.isi.regulationImpot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.isi.regulationImpot.entities.Declarant;
import sn.isi.regulationImpot.entities.Declaration;
import sn.isi.regulationImpot.entities.Paiement;
import sn.isi.regulationImpot.service.DeclarationService;
import sn.isi.regulationImpot.service.PaiementService;

import java.util.List;

@Controller
@RequestMapping("/paiements")
public class PaiementController {

    @Autowired
    private PaiementService paiementService;
    @Autowired
    private DeclarationService declarationService;


    @GetMapping("/list")
    public String listPaiements(Model model)
    {
        model.addAttribute("listPaiements", paiementService.getAllPaiements());
        return "paiement/list";
    }

    @GetMapping("/payDeclaration")
    public String payDeclaration(@RequestParam Long idDeclaration, Model model) {
        Declaration declaration = declarationService.getDeclarationById(idDeclaration);

        Paiement paiement = new Paiement();
        paiement.setDeclaration(declaration);

        model.addAttribute("paiement", paiement);
        model.addAttribute("idDeclaration", idDeclaration); // Ajoutez ceci à la méthode
        return "paiement/new_paiement";
    }



    @GetMapping("/addNewPaiement")
    public String addNewPaiement(Model model)
    {
        Paiement paiement = new Paiement();

       /* // Pré-remplir la déclaration et le déclarant dans le paiement
        Declaration selectedDeclaration = declarationService.getDeclarationById(idDeclaration);
        paiement.setDeclaration(selectedDeclaration);*/

        // Charger les données nécessaires pour le formulaire (liste de déclarations, etc.)
        model.addAttribute("paiement", paiement);
        model.addAttribute("listDeclarations", declarationService.getAllDeclarations());
        //model.addAttribute("selectedDeclaration", selectedDeclaration);
        return "paiement/new_paiement"; // Nom de la vue du formulaire d'ajout de paiement
    }




    @PostMapping("/savePaiement")
    public String savePaiement(@ModelAttribute("paiement") Paiement paiement, Model model)
    {

        // Obtenir le montant de la déclaration associée
        Declaration declaration = paiement.getDeclaration();
        double montantDeclaration = declaration.getMontantDeclaration();

        // Vérifier si le montant du paiement est inférieur ou égal au montant de la déclaration
        if (paiement.getMontantPaiement() > montantDeclaration) {
            model.addAttribute("errorMessage", "Le montant du paiement ne peut pas dépasser le montant de la déclaration.");
            model.addAttribute("declaration", declaration);
            return "paiement/new_paiement";
        }

        //save declarant to database
        paiementService.addPaiement(paiement);
        return "redirect:/paiements/list";
    }


}
