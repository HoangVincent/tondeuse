package moteur;

import bean.Tondeuse;
import command.Command;
import mouvement.Mouvement;

/**
 * Created by Suguru on 06/12/2015.
 */
public class Moteur {

    private Tondeuse tondeuse;

    public void setTondeuse (Tondeuse tondeuse){
        this.tondeuse = tondeuse;
    }
    // Références vers les commandes
    private Command commandeAvance;
    private Command commandeDroite;
    private Command commandeGauche;
    private Command commandeBas;

    // Méthodes pour invoquer les commandes
    public void invoqueAvance() {
        if(commandeAvance != null) {
            commandeAvance.executer(tondeuse);
        }
    }
    public void invoqueBas() {
        if(commandeBas != null) {
            commandeBas.executer(tondeuse);
        }
    }

    public void invoquerGauche() {
        if(commandeGauche != null) {
            commandeGauche.executer(tondeuse);
        }
    }

    public void invoquerDroite() {
        if(commandeDroite != null) {
            commandeDroite.executer(tondeuse);
        }
    }
    public void run (char input){
        Mouvement.valueOf(String.valueOf(input)).execut(this);
    }

    public Tondeuse getTondeuse(){
        return this.tondeuse;
    }

    public void setCommandeAvance(Command pCommandeAvance) {
        commandeAvance = pCommandeAvance;
    }
    public void setCommandeBas(Command pCommandeBas) {
        commandeBas = pCommandeBas;
    }

    public void setCommandeDroite(Command pCommandeDroite) {
        commandeDroite = pCommandeDroite;
    }

    public void setCommandeGauche(Command pCommandeGauche) {
        commandeGauche = pCommandeGauche;
    }


}
