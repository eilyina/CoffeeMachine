package machine;

import java.util.Scanner;

public class CoffeeMachine {
    int countWater;
    int countMilk;
    int countBeans;
    int disposableCups;
    int cash;

    CoffeeMachine() {
        countWater = 400;
        countMilk = 540;
        countBeans = 120;
        disposableCups = 9;
        cash = 550;
    }

    private void fillCoffeeMachineStatus(int water, int milk, int beans, int cups) {
        countWater += water;
        countMilk += milk;
        countBeans += beans;
        disposableCups += cups;
    }

    private void buyCoffee(String kindOfCoffee) {
        switch (kindOfCoffee) {
            case "1":
                countWater -= 250;
                countBeans -= 16;
                cash += 4;
                disposableCups -= 1;
                break;
            case "2":
                countWater -= 350;
                countMilk -= 75;
                countBeans -= 20;
                cash += 7;
                disposableCups -= 1;
                break;
            case "3":
                countWater -= 200;
                countMilk -= 100;
                countBeans -= 12;
                cash += 6;
                disposableCups -= 1;
                break;


        }
    }

    private boolean checkResources(String kindOfCoffee) {
        int water = 0, beans = 0, cups = 0, milk = 0;
        switch (kindOfCoffee) {
            case "1":
                water = countWater - 250;
                beans = countBeans - 16;
                cups = disposableCups - 1;
                break;
            case "2":
                water = countWater - 350;
                milk = countMilk - 75;
                beans = countBeans - 20;
                cups = disposableCups - 1;
                break;
            case "3":
                water = countWater - 200;
                milk = countMilk - 100;
                beans = countBeans - 12;
                cups = disposableCups - 1;
                break;
        }
        if (water < 0 || milk < 0 || beans < 0 || cups < 0) {
            System.out.print("Sorry, not enough ");
            if (water < 0) {
                System.out.print("water");
            }
            if (milk < 0) {
                System.out.print("milk");
            }
            if (beans < 0) {
                System.out.print("coffee beans");
            }
            if (beans < 0) {
                System.out.print("disposable cups");
            }
            System.out.print("!");
            return false;
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }
    }

    private void takeMoney() {

        System.out.println("I gave you $" + cash);
        cash = 0;
    }


    private void coffeeMachineStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(countWater + " ml of water");
        System.out.println(countMilk + " ml of milk");
        System.out.println(countBeans + " g of coffee beans");
        System.out.println(disposableCups + " disposable cups");
        System.out.println("$" + cash + " of money");

    }


    public static void main(String[] args) {
        
       /* System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
              "Coffee is ready!");*/
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        String str = "";
        while (!str.equals("exit")) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            Scanner scanner = new Scanner(System.in);
            str = scanner.nextLine();
            if (str.equals("exit")) {
                System.exit(0);
            }
            if (str.equals("remaining")) {
                coffeeMachine.coffeeMachineStatus();
            }
            if (str.equals("buy")) {
                System.out.println("1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                str = scanner.nextLine();
                if (coffeeMachine.checkResources(str)) {
                    coffeeMachine.buyCoffee(str);
                }
            }
            if (str.equals("fill")) {
                System.out.println("Write how many ml of water you want to add: ");
                str = scanner.nextLine();
                int countWater = Integer.parseInt(str);
                System.out.println("Write how many ml of milk you want to add: ");
                str = scanner.nextLine();
                int countMilk = Integer.parseInt(str);
                System.out.println("Write how many grams of coffee beans you want to add:");
                str = scanner.nextLine();
                int countBeans = Integer.parseInt(str);
                System.out.println("Write how many disposable cups of coffee you want to add:");
                str = scanner.nextLine();
                int cups = Integer.parseInt(str);
                coffeeMachine.fillCoffeeMachineStatus(countWater, countMilk, countBeans, cups);
            }
            if (str.equals("take")) {
                coffeeMachine.takeMoney();
            }
            // coffeeMachine.coffeeMachineStatus();
        }
    }

}
