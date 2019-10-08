package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int water = 400;
    static int milk = 540;
    static int coffeBeans = 120;
    static int cups = 9;
    static int money = 550;
    static String kindOfCoffee;

    public static void main(String[] args) {
        System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();
        do {
            if (action.equals("buy")) {
                System.out.println("\nWhat do you want to buy? \n" +
                        "1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                kindOfCoffee = scanner.next();
                prepareCoffee(kindOfCoffee);

            } else if (action.equals("fill")) {
                System.out.println("\nWrite how many ml of water do you want to add: ");
                int addWater = scanner.nextInt();
                water += addWater;
                System.out.println("Write how many ml of milk do you want to add: ");
                int addMilk = scanner.nextInt();
                milk += addMilk;
                System.out.println("Write how many grams of coffee beans do you want to add: ");
                int addCoffee = scanner.nextInt();
                coffeBeans += addCoffee;
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                int addCup = scanner.nextInt();
                cups += addCup;
            } else if (action.equals("take")) {
                System.out.println("\nI gave you $" + money);
                money = 0;
            } else if (action.equals("remaining")) {
                printState();
            }
            System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
            action = scanner.next();

        } while (!"exit".equals(action)) ;
    }


    public static boolean prepareCoffee(String kindOfCoffee) {
        if (kindOfCoffee.equals("1")) {
            if (water < 250) {
                System.out.println("Sorry, not enough water!");
                return false;
            }
            water -= 250;

            if (coffeBeans < 16) {
                System.out.println("Sorry, not enough coffee beans!");
                return false;
            }
            coffeBeans -= 16;
            if (cups < 1) {
                System.out.println("Sorry, not enough cups!");
                return false;
            }
            cups -= 1;
            money += 4;

        } else if (kindOfCoffee.equals("2")) {
            if (water < 350) {
                System.out.println("Sorry, not enough water!");
                return false;
            }
            water -= 350;
            if (milk < 75) {
                System.out.println("Sorry, not enough milk!");
                return false;
            }
            milk -= 75;
            if (coffeBeans < 20) {
                System.out.println("Sorry, not enough coffee beans!");
                return false;
            }
            coffeBeans -= 20;
            if (cups < 1) {
                System.out.println("Sorry, not enough cups!");
                return false;
            }
            cups -= 1;
            money += 7;

        } else if (kindOfCoffee.equals("3")) {
            if (water < 200) {
                System.out.println("Sorry, not enough water!");
                return false;
            }
            water -= 200;
            if (milk < 100) {
                System.out.println("Sorry, not enough milk!");
                return false;
            }
            milk -= 100;
            if (coffeBeans < 12) {
                System.out.println("Sorry, not enough coffee beans!");
                return false;
            }
            coffeBeans -= 12;
            if (cups < 1) {
                System.out.println("Sorry, not enough cups!");
                return false;
            }
            cups -= 1;
            money += 6;

        } else if (kindOfCoffee.equals("back")) {
            return false;
        }
        System.out.println("I have enough resources, making you a coffee!\n");
        return true;
    }

    public static void printState() {
        System.out.println("The coffee machine has:");
        System.out.println(CoffeeMachine.water + " of water");
        System.out.println(CoffeeMachine.milk + " of milk");
        System.out.println(CoffeeMachine.coffeBeans + " of coffee beans");
        System.out.println(CoffeeMachine.cups + " of disposable cups");
        System.out.println("$" + CoffeeMachine.money + " of money");
    }
}
