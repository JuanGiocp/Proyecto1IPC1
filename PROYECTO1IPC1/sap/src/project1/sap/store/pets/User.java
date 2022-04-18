package project1.sap.store.pets;

public abstract class User extends Pet {

    public User(String namePet, int damage, int lifetime, String skills, int experience, String type) {
        super(namePet, damage, lifetime, skills, experience, type);
    }

    @Override
    public int getModAttack(Pet defense) {
        return 0;
    }

    @Override
    public int getNumberDice() {
        return 2;
    }

    @Override
    public int getModDefense(Pet attack) {
        return 0;
    }

}
