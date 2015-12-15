package command.impl;

import bean.Tondeuse;
import command.Command;

/**
 * Created by Suguru on 28/11/2015.
 */
public class CommandBas implements Command {

    private Recepteur recepteur;

    public CommandBas(Recepteur pRecepteur) {
        recepteur = pRecepteur;
    }

    public void executer(Tondeuse tondeuse) {
        recepteur.bas(tondeuse);
    }

}
