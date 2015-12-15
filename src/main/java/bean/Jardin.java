package bean;

/**
 * Created by Suguru on 06/12/2015.
 */
public class Jardin {

    private int xMax;

    private int yMax;

    public Jardin(String area){
        String[] coord = area.split(" ");
        this.xMax = Integer.valueOf(coord[0]);
        this.yMax = Integer.valueOf(coord[1]);
    }

    public boolean isOut(Tondeuse tondeuse){
        if (tondeuse.getxTemp() > this.xMax || tondeuse.getxTemp() < 0) {
            System.out.println("isOut sur X");
            return true;
        }
        if (tondeuse.getyTemp() > this.yMax || tondeuse.getyTemp() < 0) {
            System.out.println("isOut sur Y");
            return true;
        }
        return false;
    }
}
