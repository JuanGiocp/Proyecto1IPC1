package project1.sap.store.pets;

import project1.sap.battlefield.IBattlefieldType;

public class Species extends Pet implements IBattlefieldType {

    public Species(String namePet, int damage, int lifetime, String skills, int experience, String type) {
        super(namePet, damage, lifetime, skills, experience, type);
    }

    @Override
    public int getNumberDice() {
        return 0;
    }

    @Override
    public int getModAttack(Pet defense) {
        return 0;
    }

    @Override
    public int getModDefense(Pet attack) {
        return 0;
    }

    @Override
    public int moreLife() {
        String type1 = "aquatic";
        String type2 = "desert";
        String type3 = "domestic";
        String type4 = "flying";
        String type5 = "insect";
        String type6 = "mammal";
        String type7 = "reptile";
        String type8 = "solitaire";
        String type9 = "terrestrial";

        if (type1.contains((getType()))) {
            setLifetime(this.getLifetime()+1);
        } else if (type2.contains(getType())) {
            setLifetime(this.getLifetime()+1);
        } else if (type3.contains(getType())) {
            setLifetime(this.getLifetime() + 1);
        } else if (type4.contains(getType())) {
            setLifetime(this.getLifetime()+1);
        } else if (type5.contains(getType())) {
            setLifetime(this.getLifetime() + 1);
        } else if (type6.contains(getType())) {
            setLifetime(this.getLifetime()+1);
        } else if (type7.contains(getType())) {
            setLifetime(this.getLifetime() + 1);
        } else if (type8.contains(getType())) {
            setLifetime(this.getLifetime()+1);
        } else if (type9.contains(getType())) {
            setLifetime(this.getLifetime() + 1);
        }
        return 0;
    }

    @Override
    public int moreDamage() {
        String type1 = "aquatic";
        String type2 = "desert";
        String type3 = "domestic";
        String type4 = "flying";
        String type5 = "insect";
        String type6 = "mammal";
        String type7 = "reptile";
        String type8 = "solitaire";
        String type9 = "terrestrial";

        if (type1.contains((getType()))) {
            setDamage(this.getDamage()+1);
        } else if (type2.contains(getType())) {
            setDamage(this.getDamage()+1);
        } else if (type3.contains(getType())) {
            setDamage(this.getDamage() + 1);
        } else if (type4.contains(getType())) {
            setDamage(this.getDamage()+1);
        } else if (type5.contains(getType())) {
            setDamage(this.getDamage() + 1);
        } else if (type6.contains(getType())) {
            setDamage(this.getDamage()+1);
        } else if (type7.contains(getType())) {
            setDamage(this.getDamage() + 1);
        } else if (type8.contains(getType())) {
            setDamage(this.getDamage()+1);
        } else if (type9.contains(getType())) {
            setDamage(this.getDamage() + 1);
        }
        return 0;
    }
}
