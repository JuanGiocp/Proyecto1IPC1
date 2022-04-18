package project1.sap.store.pets;

import project1.sap.util.Util;

/**
 * Abstract class with based for a pets fighting
 * @author Juan Giovani Casia Perez
 * @version 1.0
 */

public abstract class Pet {
    private static final String[][] characterString = {{
            "                               ",
            " _   _    ___    ___    _ __  ",
            "| | | | // __|  / _ \\ | '__| ",
            "| |_| | \\__\\ |  __// | |    ",
            " \\_,_| ||__//  \\___| |_|   ",
            "                               "
    }, {
            "   _                  _   ",
            "  | |                | |  ",
            "  | |__       ___    | |_ ",
            "  | '_ \\   // _ \\  | __|",
            "  | |_) || || (_) || | |__ ",
            "  |_.__//   \\ _ //   \\_||"
    }};
    private String namePet;
    private int lifetime;
    private int damage;
    private String skills;
    private int experience;
    private String type;


    /**
     * @param namePet     attribute indicating the name of the pet
     * @param damage      attribute indicating the attack of the pet
     * @param lifetime    attribute indicating the lifetime of the pet.
     * @param skills      attribute indicating the skill.
     * @param experience  attribute indicating the more experience.
     * @param type        attribute indicating the type of the pet
     */
    public Pet(String namePet, int damage, int lifetime, String skills, int experience, String type) {
        this.namePet = namePet;
        this.lifetime = lifetime;
        this.damage = damage;
        this.skills = skills;
        this.experience = experience;
        this.type = type;

    }

    public Pet(){}

    /***
     * Method for verified if the pet is alive.
     * @return return True if is alive, FALSE if death
     */
    public boolean isAlive() {
        return lifetime > 0;
    }

    @Override
    public String toString() {
        return "\n" + getNamePet() + " [" + getLifetime() + "/" + getDamage() + "]" + "\tExp: " + getExperience() +
                "\n  skills: " + getSkills() + ((this.isAlive()) ? ",         is alive." : ",      is dead.")+
                "\n  name: " + getType();
    }

    abstract public int getModAttack(Pet defense);

    abstract public int getNumberDice();

    abstract public int getModDefense(Pet attack);

    public void prepareAttack(Pet p2) {
        int amount = Util.rollDiceNTimesGreaterNumber(this.getNumberDice(), getDamage(), "Preparing the attack of " + this.getNamePet()) + this.getModAttack(p2);
        this.setDamage(amount);
    }

    public String getNamePet() {
        return namePet;
    }

    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }

    public int getLifetime() {
        return lifetime;
    }

    public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClassName(){
        return this.getClass().getSimpleName();
    }

    public void defend(Pet p1) {
        this.setLifetime(this.getModDefense(p1) + this.getLifetime());
        if (p1.getDamage() > this.getLifetime()) {
            int damage = p1.getDamage() - this.getLifetime();
            this.lifetime -= damage;
            if (this.lifetime < 0) {
                this.lifetime = 0;
            }
            System.out.println("     " + p1.getNamePet() + "'s attack was successful. " + this.getNamePet()
                    + " receive "+ damage +" damage, and ended up with " + this.getLifetime() + " life.");
        } else {
            System.out.println("     " + p1.getNamePet()+" attack was completely block by "+this.getNamePet());
        }
    }

    public static void fightBattle(Pet attacker, Pet defender){
        System.out.println("\n\n*****    Initiating fight    *****\n");
        printTwoCharacters(attacker, defender);
        attacker.prepareAttack(defender);
        defender.defend(attacker);
        System.out.println("\n");
        Util.requestEnter("Press to see results");
        printTwoCharacters(attacker, defender);
        Util.requestEnter("\n*****    Fight Ended    *****\nPress enter to continue\n");
        System.out.println();

    }

    public static void printTwoCharacters(Pet char1, Pet char2) {
        String spaceBetween = "           ";
        String spaceBetweenVrs = "    VRS    ";
        int pos1 = (char1 instanceof User) ? 1 : 0;
        int pos2 = (char1 instanceof Bot) ? 1 : 0;
        for (int i = 0; i < characterString[0].length; i++) {
            System.out.println(Pet.characterString[pos1][i] + spaceBetween + Pet.characterString[pos2][i]);
        }
        System.out.println(Util.fixStringLength(17, "Attacker") + spaceBetween
                + Util.fixStringLength(17, "Defender"));
        System.out.println(
                Util.fixStringLength(17, char1.getNamePet()) + spaceBetweenVrs + Util.fixStringLength(17, char2.getNamePet()));
        System.out.println(Util.fixStringLength(17, char1.getClassName()) + spaceBetween
                + Util.fixStringLength(17, char2.getClassName()));
        System.out.println(Util.fixStringLength(17, "Life: " + char1.getLifetime()) + spaceBetween
                + Util.fixStringLength(17, "Life: " + char2.getLifetime()));
        System.out.println(Util.fixStringLength(17,
                "Attack: " + ((char1.getDamage() == 0) ? " not set" : char1.getDamage())) + spaceBetween
                + Util.fixStringLength(17, "Attack: " + ((char2.getDamage() == 0) ? " not set" : char2.getDamage())));
    }

    public static void printTwoCharactersTeam(Pet[] char1, Pet[] char2, boolean firstWon) {
        String spaceBetween =    "           ";
        String spaceBetweenVrs = "    VRS    ";
        int pos1 = (char1[0] instanceof User)?1:0;
        int pos2 = (char1[0] instanceof Bot)?1:0;
        for (int i = 0; i < characterString[0].length; i++) {
            System.out.println(Pet.characterString[pos1][i] + spaceBetween + Pet.characterString[pos2][i]);
        }
        System.out.println(Util.fixStringLength(17, (firstWon?"WINNERS":"LOSERS")) + spaceBetween
                + Util.fixStringLength(17, (firstWon?"LOSERS":"WINNERS")));
        for (int j = 0; j < char2.length; j++) {
            System.out.println(
                    Util.fixStringLength(17, char1[j].getNamePet()+((char1[j].isAlive()?"-alive":"-dead")))
                            + spaceBetweenVrs +
                            Util.fixStringLength(17, char2[j].getNamePet()+((char2[j].isAlive()?"-alive":"-dead"))));
        }
    }
}
