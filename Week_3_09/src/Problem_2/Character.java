package Problem_2;

public class Character {

    private String equipW;
    private String equipA;
    private String name;
    private int money;
    private int attack;
    private int health;

    public Character(String equipW, String equipA, String name, int money, int attack, int health) {
        this.equipW = equipW;
        this.equipA = equipA;
        this.name = name;
        this.money = money; 
        this.attack = attack;
        this.health = health;
    }

    public String getEquipW() {
        return equipW;
    }

    public void setEquipW(String equipW) {
        this.equipW = equipW;
    }

    public String getEquipA() {
        return equipA;
    }

    public void setEquipA(String equipA) {
        this.equipA = equipA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
