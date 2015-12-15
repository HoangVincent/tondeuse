package command.impl;

import bean.Tondeuse;
import command.Command;

/**
 * Created by Suguru on 28/11/2015.
 */
public class CommandGauche implements Command {

    private Recepteur recepteur;

    public CommandGauche(Recepteur pRecepteur) {
        recepteur = pRecepteur;
    }

    public void executer(Tondeuse tondeuse) {
        recepteur.gauche(tondeuse);
    }

}
