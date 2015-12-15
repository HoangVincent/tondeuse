package bean;

import mouvement.Direction;

/**
 * Created by Suguru on 29/11/2015.
 */
public class Tondeuse {

    private int xCurrent;

    private int yCurrent;


    private int xTemp;
    private int yTemp;

    public int getxTemp() {
        return xTemp;
    }

    public int getyTemp() {
        return yTemp;
    }

    public void setyTemp(int yTemp) {
        this.yTemp = yTemp;
    }

    public void setxTemp(int xTemp) {
        this.xTemp = xTemp;
    }

    private Direction direction;

    private Tondeuse() {
    }

    public Tondeuse(String coordsMachine){

        String[] coordMachine = coordsMachine.split(" ");
        this.xTemp = Integer.valueOf(coordMachine[0]);
        this.yTemp = Integer.valueOf(coordMachine[1]);
        this.setDirection(Direction.valueOf(coordMachine[2]));
        validateMove();
    }

    public String getCurrentPosition(){
        return new StringBuffer()
                .append(this.xCurrent).append(" ")
                .append(this.yCurrent).append(" ")
                .append(this.direction).append(" ")
                .toString()
                ;
    }

    public int getxCurrent() {
        return xCurrent;
    }

    public void setxCurrent(int xCurrent) {
        this.xCurrent = xCurrent;
    }

    public int getyCurrent() {
        return yCurrent;
    }

    public void setyCurrent(int yCurrent) {
        this.yCurrent = yCurrent;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void cancelMove(){
        this.yTemp = this.yCurrent;
        this.xTemp = this.xCurrent;
    }

    public void validateMove(){
        this.yCurrent = this.yTemp;
        this.xCurrent = this.xTemp;
    }

}
