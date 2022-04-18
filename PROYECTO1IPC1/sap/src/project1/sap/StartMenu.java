package project1.sap;

import project1.sap.store.Store;
import project1.sap.util.Util;

public class StartMenu {

    public StartMenu() {
        int option;
        do {
            System.out.println("\t\t***********************************");
            System.out.println("\t\t********* Super Auto Pets *********");
            System.out.println("\t\t********* 1. Start Game ***********");
            System.out.println("\t\t************ 2. General Reports ***");
            System.out.println("\t\t*************** 3. Exit ***********");
            System.out.println("\t\t***********************************");

            option = Util.requestNumber("Select an option", 1, 3);
            switch (option) {
                case 1: 
                    gameMode();
                    break;
                case 2: 
                    reportsG();
                    break;
                case 3:
                    System.out.println("***** Thanks For Playing, Have A Great Day :<");
                    System.out.println("***" + "\n**");
                    System.out.println("* Coming out....");
                    break;
            }
        } while (option !=3);
    }

    public void gameMode() {
        int opModGame;
        do {
            System.out.println("\n\t\t************************************");
            System.out.println("\t\t************ Game Mode *************");
            System.out.println("\t\t************************************");
            System.out.println("\t\t*********** 1. Arena Mode **********");
            System.out.println("\t\t*********** 2. Versus Mode *********");
            System.out.println("\t\t*********** 3. Creative Mode *******");
            System.out.println("\t\t*********** 4. Back ****************");
            System.out.println("\t\t************************************");

            opModGame = Util.requestNumber("select an option to continue ", 1, 4);
            switch (opModGame) {
                case 1:
                    System.out.println("\n\t\t************************************");
                    System.out.println("\t\t******** Game in Arena Mode ********");
                    new Game().modArena();
                    break;
                case 2:
                    System.out.println("\n\t\t************************************");
                    System.out.println("\t\t******** Game in Versus Mode ********");
                    Store s = new Store();
                    s.viewPet(1);
                    break;
                case 3: 
                    System.out.println("Game in Creative Mode");
                    break;
                case 4:
                    return;
            }
        } while (opModGame >0);
    }

    public void reportsG(){
        System.out.println("Reports...");
    }
}