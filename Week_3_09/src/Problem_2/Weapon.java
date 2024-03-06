package Problem_2;

public class Weapon {
    private String name;
    private int level;
    private int cost;
    private int attack;

    public Weapon(String name, int level, int cost, int attack) {
        this.name = name;
        this.level = level;
        this.cost = cost;
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}
