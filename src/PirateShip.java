import java.util.*;

public class PirateShip extends SpaceShip implements CanMove {

    Scanner input = new Scanner(System.in);

    private int booty;

    public PirateShip(int i) {

        super.shipName = "P" + i;
        System.out.print("How many pounds of booty does it have?: ");
        booty = input.nextInt();
    }

    @Override
    public String toString(){
        return super.toString() + ", Booty: " + booty + "lbs.";
    }

    @Override
    public void CanMove(int x, int y){
        this.x = x;
        this.y = y;
        setX(x);
        setY(y);
    }
// Keeoing for when I figure out how to make them battle properly.
//    public int getBooty(){
//        return booty;
//    }
//
//    public void setBooty(int booty){
//        this.booty = booty;
//    }
}
