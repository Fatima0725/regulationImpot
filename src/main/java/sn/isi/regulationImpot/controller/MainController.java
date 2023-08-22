package sn.isi.regulationImpot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sn.isi.regulationImpot.service.DeclarantService;

@Controller
public class MainController {
    @Autowired
    private DeclarantService declarantService;

    //Access the declarant homePage
    @GetMapping("/declarants")
    public String declarants() {
        return "declarant/list"; // Nom de la page pour la liste des déclarants
    }

    //Access the declaration home page
    @GetMapping("/declarations")
    public String declarations() {
        return "declaration/list"; // Nom de la page pour la liste des déclarations
    }

    //Access the paiement home page
    @GetMapping("/paiements")
    public String paiements() {
        return "paiement/list"; // Nom de la page pour la liste des paiements
    }
}
