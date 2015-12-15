import bean.Jardin;
import bean.Tondeuse;
import command.*;
import command.impl.*;
import moteur.Moteur;

import java.io.*;
import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");


        try (
                InputStream fis = new FileInputStream("ressources/test");
                InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
                BufferedReader br = new BufferedReader(isr)
        ) {
            Moteur moteur = init();
            String area = br.readLine();
            Jardin jardin = new Jardin(area);
            String initPosition;
            while ((initPosition = br.readLine()) != null) {
                Tondeuse tondeuse = new Tondeuse(initPosition);
                moteur.setTondeuse(tondeuse);
                System.out.println("INIT : " + tondeuse.getCurrentPosition());
                String executeLIne = br.readLine();
                for (char c : executeLIne.toCharArray()) {
                    moteur.run(c);
                    if (jardin.isOut(tondeuse)){
                        tondeuse.cancelMove();
                    }else{
                        tondeuse.validateMove();
                    }
                    System.out.println(tondeuse.getCurrentPosition());
                }
                System.out.println("FIN : " + tondeuse.getCurrentPosition());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static Moteur init(){

        // Cr�ation d'un r�cepteur
        Recepteur lRecepteur = new Recepteur();

        // Cr�ation des commandes
        Command avance  = new CommandAvance(lRecepteur);
        Command gauche  = new CommandGauche(lRecepteur);
        Command droite  = new CommandDroite(lRecepteur);
        Command bas     = new CommandBas(lRecepteur);
        // Cr�ation et initialisation de l'invoqueur
        Moteur moteur = new Moteur();
        moteur.setCommandeAvance(avance);
        moteur.setCommandeDroite(droite);
        moteur.setCommandeGauche(gauche);
        moteur.setCommandeBas(bas);
        return moteur;
    }

}
