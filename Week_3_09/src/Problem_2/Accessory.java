package Problem_2;

public class Accessory {
    private String name;
    private int level;
    private int cost;
    private int health;

    public Accessory(String name, int level, int cost, int health) {
        this.name = name;
        this.level = level;
        this.cost = cost;
        this.health = health;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
