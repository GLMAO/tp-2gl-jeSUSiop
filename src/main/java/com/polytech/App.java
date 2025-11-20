package com.polytech;




import com.polytech.tp.Cours;
import com.polytech.tp.CoursBuilder;
import com.polytech.tp.CoursEnAnglais;
import com.polytech.tp.CoursEnLigne;
import com.polytech.tp.Etudiant;
import com.polytech.tp.GestionnaireEmploiDuTemps;
import com.polytech.tp.ICours;
import com.polytech.tp.Responsable;
import com.polytech.tp.Observer;
import com.polytech.tp.Subject;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       CoursBuilder builder = new CoursBuilder();
        
        Cours cours = builder
                .setMatiere("Génie Logiciel")
                .setEnseignant("Mr Oussama")
                .build();


        ICours coursDeBase = new Cours("Assurance qualité logiciel", "Mr Omar", 
                                        "D23", "Lundi", "8h00", false, 
                                        "2A", true);

        ICours coursDecore = new CoursEnLigne(coursDeBase);

        System.out.println(coursDecore.getDescription());

         // 1. Setup du Sujet (Gestionnaire)
        GestionnaireEmploiDuTemps gestionnaire = new GestionnaireEmploiDuTemps();

        // 2. Création d'un observateur fictif pour le test (Mock)
        Observer observateurTest = new Etudiant("Abderrahmene");
        Observer observateurTest2 = new Etudiant("Abderrahmene22");

        if (gestionnaire instanceof Subject) {
            ((Subject) gestionnaire).attach(observateurTest);
            ((Subject) gestionnaire).attach(observateurTest2);
            System.out.println("hiii");
        } else {
             System.out.println("La classe GestionnaireEmploiDuTemps doit implémenter l'interface Subject !");
        }

        gestionnaire.setChangement("Changement de salle : C15-C16");

        
    }
}
