import java.util.*;

public class CargoShip extends SpaceShip implements CanMove{

    Scanner input = new Scanner(System.in);

    private int cargo;


    public CargoShip(int i) {

        super.shipName = "C" + i;
        System.out.print("How many pounds of cargo does it have?: ");
        cargo = input.nextInt();
    }

    @Override
    public String toString(){
        //change the spaceship to string to print ship name and year built.
        return super.toString() + ", Cargo: " + cargo + " lbs.";
    }

    @Override
    public void CanMove(int x, int y){
        this.x = x;
        this.y = y;
        setX(x);
        setY(y);
    }
// Keeping these here to use for when I figure out how to make them battle properly.
//    public int getCargo(){
//        return cargo;
//    }
//
//    public void setCargo(int cargo){
//        this.cargo = cargo;
//    }
}

