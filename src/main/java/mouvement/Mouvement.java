package mouvement;

import moteur.Moteur;

/**
 * Created by Suguru on 06/12/2015.
 */
public enum Mouvement {
    A {
        @Override
        public void execut(Moteur moteur) {
            moteur.getTondeuse().getDirection().execut(moteur);
        }
    },
    D {
        @Override
        public void execut(Moteur moteur) {
            Direction.tourneDroite(moteur.getTondeuse());
        }
    },
    G {
        @Override
        public void execut(Moteur moteur) {
            Direction.tourneGauche(moteur.getTondeuse());
        }
    },
    R {
        @Override
        public void execut (Moteur moteur){
            Direction.getInversDirection(moteur.getTondeuse()).execut(moteur);
        }
    }
    ;

    public abstract void execut(Moteur moteur);
}
