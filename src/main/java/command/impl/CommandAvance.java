package command.impl;

import bean.Tondeuse;
import command.Command;

/**
 * Created by Suguru on 28/11/2015.
 */
public class CommandAvance implements Command {

    private Recepteur recepteur;

    public CommandAvance(Recepteur pRecepteur) {
        recepteur = pRecepteur;
    }

    public void executer(Tondeuse tondeuse) {
        recepteur.avance(tondeuse);
    }

}
