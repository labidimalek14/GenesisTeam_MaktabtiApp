/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.main;

import edu.esprit.entities.Competition;
import edu.esprit.entities.Panier;
import edu.esprit.services.ServiceCompetition;
import edu.esprit.services.ServicePanier;
import java.sql.Date;

/**
 *
 * @author admin
 */
public class Main {
    public static void main(String[] args) {
        
        ServiceCompetition sc = new ServiceCompetition();
        Competition c =new Competition(1, "cadeau3", "p", "gsdhdghdghdg", "a9rani2", Date.valueOf("2023-04-14"), Date.valueOf("2023-04-23"));
        Competition c1 =new Competition(1,1, "cadeau1", "p1", "gsdhdghdghdg", "a9rani", Date.valueOf("2023-03-25"), Date.valueOf("2023-04-01"));
        //sc.ajouter(c);
        //sc.modifier(c1);
        //sc.delete(3);
        System.out.println(sc.getOneById(1));
        System.out.println(sc.getAll());
        
        
        ServicePanier sp=new ServicePanier();
        Panier p1=new Panier(1, 3, 25);
        Panier p2=new Panier(1, 1, 2, 50);

        //sp.ajouter(p1);
        //sp.modifier(p2);
        sp.delete(2);
        
        System.out.println(sp.getAll());
        System.out.println(sp.getOneById(2));
    }
}
