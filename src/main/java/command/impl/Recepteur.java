package command.impl;

import bean.Tondeuse;

/**
 * Created by Suguru on 06/12/2015.
 */
public class Recepteur {

    public void avance(Tondeuse tondeuse) {
        System.out.println("Traitement avance.");
        tondeuse.setyTemp(tondeuse.getyTemp() + 1);
    }

    public void gauche(Tondeuse tondeuse) {
        System.out.println("Traitement gauche.");
        tondeuse.setxTemp(tondeuse.getxTemp() - 1);
    }

    public void droite(Tondeuse tondeuse) {
        System.out.println("Traitement droite.");
        tondeuse.setxTemp(tondeuse.getxTemp() + 1);
    }

    public void bas(Tondeuse tondeuse) {
        System.out.println("Traitement bas.");
        tondeuse.setyTemp(tondeuse.getyTemp() - 1);
    }



}
