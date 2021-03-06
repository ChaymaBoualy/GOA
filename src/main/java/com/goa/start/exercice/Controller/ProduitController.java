package com.goa.start.exercice.Controller;


import com.goa.start.exercice.Services.ProduitIService;

import com.goa.start.exercice.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/Produit")
@CrossOrigin
public class ProduitController {
    @Autowired
    ProduitIService produitIService;
    @ResponseBody
    @GetMapping("/AfficherProduit")
    @RolesAllowed("admin")
    //http://localhost:8082/Produit/AfficherProduit

    public List<Produit> getProduitList() {
        List<Produit> listProduits = produitIService.retrieveAllProduit();
        return listProduits;
    }
    @PostMapping("/add")
    @ResponseBody
    @RolesAllowed("admin")
    //http://localhost:8082/Produit/add

    public Produit addProduit(@RequestBody Produit p)
    {
        Produit produit= produitIService.addProduit(p);
        return produit;
    }

    @DeleteMapping("/deleteProd/{Prod-id}")
    @ResponseBody
    @RolesAllowed("admin")
    //http://localhost:8082/Produit/deleteProd/{Prod-id}

    public void deleteProduit(@PathVariable("Prod-id") int id) {
        produitIService.deleteProduit(id);
    }

    @PutMapping("/updateProd")
    @ResponseBody
    @RolesAllowed("admin")
    //http://localhost:8082/Produit/updateProd

    public Produit updateProduit(@RequestBody Produit p ) {
        return produitIService.updateProduit(p);
    }
    @GetMapping("/afficherProd/{Prod-id}")
    @ResponseBody
    @RolesAllowed("admin")
    public Produit retrieveProduit(@PathVariable("Prod-id") int Id) {
        return produitIService.retrieveProduit(Id);
    }
}
