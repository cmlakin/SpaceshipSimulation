import java.util.*;

public abstract class SpaceShip {

    Scanner input = new Scanner(System.in);

    public String shipName;
    public int yearBuilt;
    public int x;
    public int y;

    //spaceship constructor
    public SpaceShip() {

        System.out.print("Enter year built (yyyy): ");
        yearBuilt = input.nextInt();

        System.out.print("Enter an x coordinate between 1 and 10: ");
        x = input.nextInt();
        while ( x < 1 || x > 10 ){
            System.out.println("Invalid input. Enter a number 1 - 10:");
            x = input.nextInt();
        }
        System.out.print("Enter an y coordinate between 1 and 10: ");
        y = input.nextInt();
        while ( y < 1 || y > 10 ){
            System.out.println("Invalid input. Enter a number 1 - 10:");
            y = input.nextInt();
        }

    }

    //@Override //Does this toString also need to be overridden?
    public String toString() {
        return "ShipName: " + shipName +
                ", yearBuilt: " + yearBuilt +
                ", Location: (" + getX() + "," + getY() + ")";
    }


    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }

    public String getShipName(){
        return shipName;
    }
}
