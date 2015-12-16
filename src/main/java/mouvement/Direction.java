package mouvement;

import bean.Tondeuse;
import moteur.Moteur;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Suguru on 06/12/2015.
 */
public enum Direction {
    N {
        @Override
        public void execut(Moteur moteur) {
            moteur.invoqueAvance();
        }
    },
    E {
        @Override
        public void execut(Moteur moteur) {
            moteur.invoquerDroite();
        }
    },
    S {
        @Override
        public void execut(Moteur moteur) {
            moteur.invoqueBas();
        }
    },
    O {
        @Override
        public void execut(Moteur moteur) {
            moteur.invoquerGauche();
        }
    };

    public static void tourneGauche(Tondeuse tondeuse) {
        System.out.println("tourne a gauche");
        List<Direction> list = Arrays.asList(Direction.values());
        int indexDirection = list.indexOf(tondeuse.getDirection());
        if ( indexDirection == 0) {
            tondeuse.setDirection(list.get(list.size()-1));
        } else {
            tondeuse.setDirection(list.get(indexDirection - 1));
        }
    }
    public static Direction getInversDirection(Tondeuse tondeuse){
        System.out.println("get inverse direction");
        List<Direction> list = Arrays.asList(Direction.values());
        int indexDirection = list.indexOf(tondeuse.getDirection());
        if ( indexDirection == list.size()-2) {
            return list.get(0);
        } else if ( indexDirection == list.size()-1) {
            return list.get(1);
        } else  {
            return list.get(indexDirection+2);
        }
    }
    public static void tourneDroite(Tondeuse tondeuse) {
        System.out.println("tourne a droite");
        List<Direction> list = Arrays.asList(Direction.values());
        int indexDirection = list.indexOf(tondeuse.getDirection());
        if ( indexDirection == list.size()-1) {
            tondeuse.setDirection(list.get(0));
        } else {
            tondeuse.setDirection(list.get(indexDirection + 1));
        }
    }

    public abstract void execut(Moteur moteur);
}
