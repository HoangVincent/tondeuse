import bean.Tondeuse;
import command.Command;
import command.impl.*;
import moteur.Moteur;
import mouvement.Direction;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
//Let's import Mockito statically so that the code looks clearer
import static org.mockito.Mockito.*;


/**
 * Created by Suguru on 06/12/2015.
 */
public class test {
    @Mock
    private Tondeuse mockTondeuse = mock(Tondeuse.class);

    private Moteur init(){
        // Création d'un récepteur
        Recepteur lRecepteur = new Recepteur();

        // Création des commandes
        Command avance  = new CommandAvance(lRecepteur);
        Command gauche  = new CommandGauche(lRecepteur);
        Command droite  = new CommandDroite(lRecepteur);
        Command bas     = new CommandBas(lRecepteur);
        // Création et initialisation de l'invoqueur
        Moteur moteur = new Moteur();
        moteur.setCommandeAvance(avance);
        moteur.setCommandeDroite(droite);
        moteur.setCommandeGauche(gauche);
        moteur.setCommandeBas(bas);
        return moteur;
    }

    @Before
    public void initMockTondeuse(){
        //stub set/getDirection
        when(mockTondeuse.getDirection()).thenCallRealMethod();
        doCallRealMethod().when(mockTondeuse).setDirection(any(Direction.class));

        //stub set/get x/y
        when(mockTondeuse.getxTemp()).thenCallRealMethod();
        doCallRealMethod().when(mockTondeuse).setxTemp(anyInt());
        when(mockTondeuse.getyTemp()).thenCallRealMethod();
        doCallRealMethod().when(mockTondeuse).setyTemp(anyInt());

        //stub set/get x/yCurrent
        when(mockTondeuse.getxCurrent()).thenCallRealMethod();
        doCallRealMethod().when(mockTondeuse).setxCurrent(anyInt());
        when(mockTondeuse.getyCurrent()).thenCallRealMethod();
        doCallRealMethod().when(mockTondeuse).setyCurrent(anyInt());

        doCallRealMethod().when(mockTondeuse).validateMove();




    }
    @Test
    public void shouldTurnRightNtoO() {
        mockTondeuse.setDirection(Direction.valueOf("N"));
        Direction.tourneGauche(mockTondeuse);
        assertEquals(Direction.O, mockTondeuse.getDirection());
    }
    @Test
    public void shouldTurnRightStoE() {
        mockTondeuse.setDirection(Direction.valueOf("S"));
        Direction.tourneGauche(mockTondeuse);
        assertEquals(Direction.E, mockTondeuse.getDirection());
    }

    @Test
    public void shouldTurnLeftNtoE() {
        mockTondeuse.setDirection(Direction.valueOf("N"));
        Direction.tourneDroite(mockTondeuse);
        assertEquals(Direction.E, mockTondeuse.getDirection());
    }

    @Test
    public void shouldTurnLeftStoO() {
        mockTondeuse.setDirection(Direction.valueOf("S"));
        Direction.tourneDroite(mockTondeuse);
        assertEquals(Direction.O, mockTondeuse.getDirection());
    }

    @Test
    public void shouldInitTondeuse(){
        mockTondeuse.setxTemp(3);
        mockTondeuse.setyTemp(2);
        mockTondeuse.setDirection(Direction.valueOf("N"));
        mockTondeuse.validateMove();

        assertEquals(3, mockTondeuse.getxCurrent());
        assertEquals(2, mockTondeuse.getyCurrent());
        assertEquals(Direction.N, mockTondeuse.getDirection());
    }

    @Test
    public void shouldAvanceUp(){
        mockTondeuse.setxTemp(3);
        mockTondeuse.setyTemp(2);
        mockTondeuse.setDirection(Direction.valueOf("N"));
        mockTondeuse.validateMove();

        Moteur moteur = init();
        moteur.setTondeuse(mockTondeuse);

        moteur.run('A');
        mockTondeuse.validateMove();

        assertEquals(3, mockTondeuse.getxCurrent());
        assertEquals(3, mockTondeuse.getyCurrent());
        assertEquals(Direction.N, mockTondeuse.getDirection());

    }

    @Test
    public void shouldAvanceLeft(){
        mockTondeuse.setxTemp(3);
        mockTondeuse.setyTemp(2);
        mockTondeuse.setDirection(Direction.valueOf("O"));
        mockTondeuse.validateMove();

        Moteur moteur = init();
        moteur.setTondeuse(mockTondeuse);

        moteur.run('A');
        mockTondeuse.validateMove();

        assertEquals(2, mockTondeuse.getxCurrent());
        assertEquals(2, mockTondeuse.getyCurrent());
        assertEquals(Direction.O, mockTondeuse.getDirection());

    }

    @Test
    public void shouldAvanceRight(){
        mockTondeuse.setxTemp(3);
        mockTondeuse.setyTemp(2);
        mockTondeuse.setDirection(Direction.valueOf("E"));
        mockTondeuse.validateMove();

        Moteur moteur = init();
        moteur.setTondeuse(mockTondeuse);

        moteur.run('A');
        mockTondeuse.validateMove();

        assertEquals(4, mockTondeuse.getxCurrent());
        assertEquals(2, mockTondeuse.getyCurrent());
        assertEquals(Direction.E, mockTondeuse.getDirection());

    }

    @Test
    public void shouldAvanceDown(){
        mockTondeuse.setxTemp(3);
        mockTondeuse.setyTemp(2);
        mockTondeuse.setDirection(Direction.valueOf("S"));
        mockTondeuse.validateMove();

        Moteur moteur = init();
        moteur.setTondeuse(mockTondeuse);

        moteur.run('A');
        mockTondeuse.validateMove();

        assertEquals(3, mockTondeuse.getxCurrent());
        assertEquals(1, mockTondeuse.getyCurrent());
        assertEquals(Direction.S, mockTondeuse.getDirection());

    }
}
