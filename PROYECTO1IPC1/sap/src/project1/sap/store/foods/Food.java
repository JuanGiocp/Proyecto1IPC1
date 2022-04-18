package project1.sap.store.foods;

public abstract class Food {
    protected int ph;
    protected int attack;
    protected String name;
    protected boolean typeEffect = false;

    public Food(int ph, int attack, String name, boolean typeEffect) {
        this.ph = ph;
        this.attack = attack;
        this.name = name;
        this.typeEffect = typeEffect;
    }

    public int getPh() {
        return ph;
    }

    public void setPh(int ph) {
        this.ph = ph;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTypeEffect() {
        return typeEffect;
    }

    public void setTypeEffect(boolean typeEffect) {
        this.typeEffect = typeEffect;
    }

    protected abstract void bonusPh();
    protected abstract void bonusAttack();
}
