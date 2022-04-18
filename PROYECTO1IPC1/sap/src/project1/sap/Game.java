package project1.sap;

import project1.sap.store.Store;
import project1.sap.store.pets.Pet;
import project1.sap.util.Util;

public class Game {
    private final int numArrPetsForBattle = 5;
    private Pet[] users = new Pet[numArrPetsForBattle];
    private Pet[] bots = new Pet[numArrPetsForBattle];
    public static int round = 1;
    public Game() {
    }
    public void modArena(){
        menuInGame();
        /*printCharacters(users, "List of User Team");
        printCharacters(bots, "List of Bot Team");*/
        Util.requestEnter("Press enter to continue");
        battleRound(users, bots);
        System.out.println("Battle result");
        /*printCharacters(users, "List of Heroes");
        printCharacters(bots, "List of Beasts");*/
        Store.costInitBot = 10;
        Store.costInit = 10;
        Game.round += 1;
        new Game().menuInGame();
        Pet.printTwoCharactersTeam(users, bots, (getPosAlive(users, 0)>=0));
        Util.requestEnter("Press enter to continue");
    }

    public void menuInGame(){
        Store store = new Store();
        int option;
        do {
            System.out.println("\t\t************************************");
            System.out.println("\t\t*********** 1. Buy Pets ************");
            System.out.println("\t\t*********** 2. Buy Food ************");
            System.out.println("\t\t*********** 3. Order Pets **********");
            System.out.println("\t\t*********** 4. Merge Pets **********");
            System.out.println("\t\t*********** 5. Sell Pets ***********");
            System.out.println("\t\t************************************");
            option = Util.requestNumber("select an option to continue ", 1, 5);

            switch (option) {
                case 1:
                    System.out.println("\t\t*********** Buy Pets ************");
                    store.viewPet(round);
                    users = new Pet[numArrPetsForBattle];
                    initPets(users, true);
                    bots = new Pet[numArrPetsForBattle];
                    initPets(bots, false);
                    return;
                case 2:
                    System.out.println("\t\t*********** 2. Buy Food ************");
                    return;
                case 3:
                    System.out.println("\t\t*********** 3. Order Pets **********");
                    return;
                case 4:
                    System.out.println("\t\t*********** 4. Merge Pets **********");
                    store.mergePetsUser();
                    return;
                case 5:
                    System.out.println("\t\t*********** 5. Sell Pets ***********");
                    return;
            }
        } while (option >0);
    }

    public int getPosAlive(Pet[] group, int initPos) {
        int tmpPos = initPos;
        do {
            if ((tmpPos >= group.length)){
                if (initPos>0){
                    tmpPos = 0;
                }
                else{
                    break;
                }
            }
            if (group[tmpPos].isAlive()) {
                return tmpPos;
            } else {
                tmpPos++;
            }
        } while (tmpPos != initPos);
        return -1;
    }

    public void battleRound(Pet[] user, Pet[] bot){
        System.out.println("\n\nRolling the dice to select which team to attack first");
        boolean botFirst = Util.generateRandomNumber(0, 1)==0;
        System.out.println("The "+(botFirst?"BOT":"USER")+" team attack first.\n");
        Util.requestEnter("Press enter to continue.");

        int posH = 0;
        int posB = 0;
        while (true) {
            posH = getPosAlive(user, posH);
            posB = getPosAlive(bot, posB);

            if ((posH>=0)&&(posB>=0)){
                if (botFirst){
                    fightRounder(bot[posB], user[posH]);
                }
                else{
                    fightRounder(user[posH], bot[posB]);
                }
                posB++;
                posH++;
            }
            else{
                System.out.println("\n********* The battle is over");
                break;
            }

        }

    }

    private void fightRounder(Pet ch1, Pet ch2){
        System.out.println("\n********************** ROUND **********************\n");
        Pet.fightBattle(ch1, ch2);
        if (ch2.isAlive()){
            Pet.fightBattle(ch2, ch1);
        }
        else{
            System.out.println("          "+ch2.getNamePet() + " can not attack, because is dead. ");
        }
        System.out.println("\n********************** END OF ROUND **********************\n");
    }


    public void initPets(Pet[] init, boolean isUser) {
        Store sto = new Store();
        for (int i = 0; i < init.length; i++) {
            if (isUser) {
                init[i] = sto.buyPets(round);
            } else {
                init[i] = sto.buyPetsBot(round);
            }
        }
    }

    public void printCharacters(Pet[] group, String title){
        System.out.println("\n"+title+"\n");
        for (int i = 0; i < group.length; i++) {
            System.out.println(group[i].toString());
        }
    }

}
