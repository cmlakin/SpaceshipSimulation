import java.util.*;

public class Simulation {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //** gives user a summarized idea of the simulation
        System.out.println("\nThis is a Spaceship simulation. You can create 1 to 9 ships. Then select whether each");
        System.out.println("is a Cargo ship or a Pirate ship, enter the year it was built and the  ships amount of cargo");
        System.out.println("or booty in pounds. This simulation takes place over a 10 x 10 grid in space.");
        System.out.println("Once the ships are created, you can choose to change the type of ship or move your ships");
        System.out.println();

        System.out.print("\nHow many ships would you like for your simulation?: ");

        int numShips = input.nextInt();

        // input validation for correct number range of numShips
        while ((numShips > 9) || (numShips < 1)) {
            System.out.println("Invalid entry. Please choose a number 1 through 9: ");
            numShips = input.nextInt();
        }

        //creates array list of spaceships
        ArrayList<SpaceShip> shipList = new ArrayList<>(numShips);

        //** sets up array of ships
        for (int i = 0; i < numShips; i++) {


            SpaceShip ship; //creating a reference of the spaceship constructor.

            int typeShip; // this will determine cargo or pirate
            System.out.print("\nShip #" + (i + 1) + ": Enter 1 for Cargo or 2 for Pirate: ");
            typeShip = input.nextInt();


            if (typeShip == 1) {
                ship = new CargoShip(i);  //call to create cargo ship
                shipList.add((i), ship);

            } else {
                ship = new PirateShip(i); //call to create pirate ship
                shipList.add((i), ship);

            }
        }
        System.out.println();

        //all variables used inside of do-while loop for simulation
        int choice, tempShipName, tempShipType, answer = 0;
        int shipMove, newX, newY;
        String[][] world = new String[10][10];


        do {

            System.out.println("WORLD VIEW:\n");
            displayWorld(world, shipList);

            //Display list of ships in ArrayList
            System.out.println("\nLIST OF SHIPS: ");
            for (int i = 0; i < shipList.size(); i++) {
                System.out.println((i + 1) + ". " + shipList.get(i));
            }
            System.out.println(" ");

            System.out.println("What would you like to do?");
            System.out.println("1. Change type of ship");
            System.out.println("2. Move ship");

            choice = input.nextInt();

            // choice validation
            while ((choice > 2) || (choice < 1)) {
                System.out.println("Invalid entry. Enter 1 or 2: ");
                choice = input.nextInt();
            }

            // change type of ship
            while (choice == 1) {

                System.out.print("Enter number for which ship you would like to change: ");
                tempShipName = input.nextInt();

                System.out.print("What kind of ship would you like to create? 1 Cargo or 2 Pirate: ");
                tempShipType = input.nextInt();
                //create new cargo ship
                if (tempShipType == 1) {
                    SpaceShip ship;
                    shipList.remove(tempShipName - 1);
                    ship = new CargoShip(tempShipName - 1);  //call to create cargo ship
                    shipList.add((tempShipName - 1), ship);

                    System.out.println("\nLIST OF SHIPS: ");
                    for (int i = 0; i < shipList.size(); i++) {
                        System.out.println((i + 1) + ". " + shipList.get(i));
                    }
                    displayWorld(world, shipList);

                    break;
                }
                // create new pirate ship
                else {
                    SpaceShip ship;
                    shipList.remove(tempShipName - 1);
                    ship = new PirateShip(tempShipName - 1);  //call to create cargo ship
                    shipList.add((tempShipName - 1), ship);
                    //reprints list of ships to confirm change made
                    System.out.println("\nLIST OF SHIPS: ");
                    for (int i = 0; i < shipList.size(); i++) {
                        System.out.println((i + 1) + ". " + shipList.get(i));
                    }
                    displayWorld(world, shipList);

                    break;
                }
            }

            // move ship
            while (choice == 2) {

                System.out.println("Enter the number of ship you would like to move: ");
                shipMove = input.nextInt();

                int pickNew;

                do {
                    System.out.print("Enter new x coordinate: ");
                    newX = input.nextInt();
                    while ( newX < 0 || newX > 9){
                        System.out.println("Invalid input. Enter a number 1 - 10:");
                        newX = input.nextInt() - 1;
                    }
                    System.out.print("Enter new y coordinate: ");
                    newY = input.nextInt();
                    while ( newY < 0 || newY > 9){
                        System.out.println("Invalid input. Enter a number 1 - 10:");
                        newY = input.nextInt();
                    }

                    // move ship to new location that is currently empty in new location
                    if (world[newX][newY] == "**") {
                        //move cargo ship
                        if (shipList.get(shipMove - 1) instanceof CargoShip) {
                            ((CargoShip) shipList.get(shipMove - 1)).CanMove(newX, newY);
                            world[newX][newY] = shipList.get(shipMove - 1).getShipName();

                            displayWorld(world, shipList);

                            //reprints list of ships to confirm change made
                            System.out.println("\nLIST OF SHIPS: ");
                            for (int i = 0; i < shipList.size(); i++) {
                                System.out.println((i + 1) + ". " + shipList.get(i));
                            }

                            break;
                        }
                        //move pirate ship
                        else {
                            ((PirateShip) (shipList.get(shipMove - 1))).CanMove(newX, newY);
                            world[newX][newY] = shipList.get(shipMove - 1).getShipName();

                            displayWorld(world, shipList);

                            //reprints list of ships to confirm change made
                            System.out.println("\nLIST OF SHIPS: ");
                            for (int i = 0; i < shipList.size(); i++) {
                                System.out.println((i + 1) + ". " + shipList.get(i));
                            }

                            break;
                        }
                    }
                    // choose new coordinates or take over ship in new location
                    else {
                        System.out.println("Abort! Abort! You are about to crash into another ship!!");
                        System.out.println("What would you like to do?");
                        System.out.println("1. Enter new coordinates and avoid collision.");
                        System.out.println("2. Quit");
                        pickNew = input.nextInt();
                    }
                    //break;
                } while (pickNew == 1);

                displayWorld(world, shipList);

                //reprints list of ships to confirm change made
                System.out.println("\nLIST OF SHIPS: ");
                for (int i = 0; i < shipList.size(); i++) {
                    System.out.println((i + 1) + ". " + shipList.get(i));
                }
            }

            // user can play again or quit
            System.out.print("\nWould you like to make another selection? ");
            System.out.print(" Enter 1. Yes or 2. Quit ");
            answer = input.nextInt();

            // answer validation
            while ((answer > 2) || (answer < 1)) {
                System.out.println("Invalid entry. Enter 1 or 2: ");
                answer = input.nextInt();
            }

            if (answer == 2) {
                System.out.print("\nYou have exited the simulation. Thank you for playing.");
            }

        } while (answer == 1);
    }

    private static void displayWorld(String[][] world, ArrayList<SpaceShip> shipList) {
        //Display world with ship placement
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                world[i][j] = "**";
                for (int l = 0; l < shipList.size(); l++) {

                    if (shipList.get(l).getX() - 1 == i && shipList.get(l).getY() - 1 == j) {

                        if (shipList.get(l) instanceof PirateShip)
                            world[i][j] = shipList.get(l).getShipName();
                        else
                            world[i][j] = shipList.get(l).getShipName();
                    }
                }
                System.out.print("|" + world[i][j]);
            }
            System.out.print("|\n");
        }
    }
}
