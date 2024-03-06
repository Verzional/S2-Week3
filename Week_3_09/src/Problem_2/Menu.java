package Problem_2;

import java.util.*;

public class Menu {

    int option;
    int choice;
    int ownedW;
    int ownedA;
    int rarity;
    int previousAttack = 0;
    int previousHealth = 0;
    String newName;
    boolean validName = false;
    boolean newValidName = false;

    private final ArrayList<Weapon> weapons = new ArrayList<>();
    private final ArrayList<Accessory> accessories = new ArrayList<>();
    private final ArrayList<Weapon> shopWeapons = new ArrayList<>();
    private final ArrayList<Accessory> shopAccessories = new ArrayList<>();

    Character Yobel = new Character("None", "None", "Yobel", 50000, 0, 0);
    Character Player = new Character("None", "None", "", 50000, 0, 0);

    Weapon Willas = new Weapon("Willas", 0, 0, 0);
    Weapon Gauntlets = new Weapon("Willas' Gauntlets", 0, 0, 0);
    Weapon Sword = new Weapon("Willas' Sword", 0, 0, 0);
    Weapon Knife = new Weapon("Willas' Knife", 0, 0, 0);

    Accessory Necklace = new Accessory("Willas' Necklace", 0, 0, 0);
    Accessory Ring = new Accessory("Willas' Ring", 0, 0, 0);
    Accessory Pants = new Accessory("Willas' Pants", 0, 0, 0);
    Accessory Suit = new Accessory("Willas' Suit", 0, 0, 0);

    Random rand = new Random();
    Scanner scan = new Scanner(System.in);

    public void name() {
        while (!validName) {
            System.out.print("Player Name: ");
            newName = scan.next();
            if (newName.equalsIgnoreCase("Yobel")) {
                System.out.println("Player's name cannot be Yobel. Please choose another name.");
            } else {
                Player.setName(newName);
                validName = true;
            }
        }

        Yobel.setAttack(rand.nextInt(1, 5));
        Player.setAttack(rand.nextInt(1, 5));
        Yobel.setHealth(rand.nextInt(10, 50));
        Player.setHealth(rand.nextInt(10, 50));

        System.out.println("Willas: Hello Travelers. What are your names?");
        System.out.println("Yobel: Hey! I'm Yobel, and this is... " + Player.getName());
        System.out.println("Well then, Welcome Yobel and " + Player.getName() + "");

        start();
    }

    public void start() {
        do {
            System.out.println("=== Welcome to Willas' Wacky Wares ===");
            System.out.println("Money: " + Player.getMoney() + "\nWeapons Owned: " + ownedW + "\nAccessories Owned: " + ownedA);
            System.out.println("\nWhat do you want to do?");
            System.out.println("""
                           [1] Character Details
                           [2] Check Inventory
                           [3] Enter Store
                           [0] Quit""");
            System.out.print("Choose: ");
            option = scan.nextInt();
            System.out.println("---------------------------");

            switch (option) {
                case 1 ->
                    details();
                case 2 ->
                    inventory();
                case 3 ->
                    store();
                case 0 ->
                    exit();
            }
        } while (option != 0);

    }

    public void details() {
        System.out.println("""
                           Which Character
                           [1] Yobel""");
        System.out.println("[2] " + Player.getName() + "\n[0] Return");
        System.out.print("Choose: ");
        option = scan.nextInt();

        switch (option) {
            case 1 ->
                yobelDetails();
            case 2 ->
                playerDetails();
            case 0 ->
                start();
        }
    }

    public void yobelDetails() {
        System.out.println("===== Yobel's Stats =====");
        System.out.println("Health: " + Yobel.getHealth());
        System.out.println("Attack: " + Yobel.getAttack());
        System.out.println("Weapon: " + Yobel.getEquipW());
        System.out.println("Accessory: " + Yobel.getEquipA());
        System.out.println("=========================");
        System.out.println("""
                           What do you want to do?
                           [1] Rename Character
                           [2] Equip Weapon
                           [3] Equip Accessory
                           [0] Return""");
        System.out.print("Choose: ");
        option = scan.nextInt();

        switch (option) {
            case 1 -> {
                System.out.println("===== RENAMING CHARACTER =====");
                System.out.println("You cannot rename Yobel!");
            }
            case 2 ->
                changeWeaponY();
            case 3 ->
                changeAccessoryY();
            case 0 ->
                start();
        }

    }

    public void playerDetails() {
        System.out.println("===== " + Player.getName() + "'s Stats =====");
        System.out.println("Health: " + Player.getHealth());
        System.out.println("Attack: " + Player.getAttack());
        System.out.println("Weapon: " + Player.getEquipW());
        System.out.println("Accessory: " + Player.getEquipA());
        System.out.println("=========================");
        System.out.println("""
                           What do you want to do?
                           [1] Rename Character
                           [2] Equip Weapon
                           [3] Equip Accessory
                           [0] Return""");
        System.out.print("Choose: ");
        option = scan.nextInt();

        switch (option) {
            case 1 -> {
                while (!newValidName) {
                    System.out.print("New Player Name: ");
                    newName = scan.next();
                    if (newName.equalsIgnoreCase("Yobel")) {
                        System.out.println("Player's name cannot be Yobel. Please choose another name.");
                    } else {
                        Player.setName(newName);
                        newValidName = true;
                    }
                }
                newValidName = false;
            }
            case 2 ->
                changeWeaponP();
            case 3 ->
                changeAccessoryP();
            case 0 ->
                start();
        }
    }

    public void changeWeaponY() {
        System.out.println("===== EQUIPPING WEAPON =====");
        System.out.println("Current Weapon: " + Yobel.getEquipW());
        if (weapons.isEmpty()) {
            System.out.println("Inventory is Empty");
            yobelDetails();
        } else {
            for (int i = 0; i < weapons.size(); i++) {
                Weapon weapon = weapons.get(i);
                System.out.println("[" + (i + 1) + "] " + weapon.getName() + " Lv. " + weapon.getLevel() + " | Cost: " + weapon.getCost() + " | Attack: " + weapon.getAttack());
            }
            System.out.print("Choose a weapon to equip (0 to cancel): ");
            choice = scan.nextInt();
            if (choice >= 1 && choice <= weapons.size()) {
                Yobel.setAttack(Yobel.getAttack() - previousAttack);
                Weapon chosenWeapon = weapons.get(choice - 1);
                if (chosenWeapon.getName().equals(Yobel.getEquipW())) {
                    System.out.println("Error: " + Yobel.getName() + " already has " + chosenWeapon.getName() + " equipped.");
                } else if (chosenWeapon.getName().equals(Player.getEquipW())) {
                    System.out.println("Error: " + Player.getName() + " already has " + chosenWeapon.getName() + " equipped.");
                } else {
                    previousAttack = Yobel.getAttack();
                    Yobel.setEquipW(chosenWeapon.getName());
                    Yobel.setAttack(previousAttack + chosenWeapon.getAttack());
                    System.out.println("You have equipped: " + chosenWeapon.getName());
                    previousAttack = chosenWeapon.getAttack();
                }
            } else if (choice == 0) {
                System.out.println("Cancelled equipping a weapon.");
            } else {
                System.out.println("Invalid choice. Please try again.");
                changeWeaponY();
            }
        }

        yobelDetails();
    }

    public void changeWeaponP() {
        System.out.println("===== EQUIPPING WEAPON =====");
        System.out.println("Current Weapon: " + Player.getEquipW());
        if (weapons.isEmpty()) {
            System.out.println("Inventory is Empty");
            playerDetails();
        } else {
            for (int i = 0; i < weapons.size(); i++) {
                Weapon weapon = weapons.get(i);
                System.out.println("[" + (i + 1) + "] " + weapon.getName() + " Lv. " + weapon.getLevel() + " | Cost: " + weapon.getCost() + " | Attack: " + weapon.getAttack());
            }
            System.out.print("Choose a weapon to equip (0 to cancel): ");
            choice = scan.nextInt();
            if (choice >= 1 && choice <= weapons.size()) {
                Player.setAttack(Player.getAttack() - previousAttack);
                Weapon chosenWeapon = weapons.get(choice - 1);
                if (chosenWeapon.getName().equals(Player.getEquipW())) {
                    System.out.println("Error: " + Player.getName() + " already has " + chosenWeapon.getName() + " equipped.");
                } else if (chosenWeapon.getName().equals(Yobel.getEquipW())) {
                    System.out.println("Error: " + Yobel.getName() + " already has " + chosenWeapon.getName() + " equipped.");
                } else {
                    previousAttack = Player.getAttack();
                    Player.setEquipW(chosenWeapon.getName());
                    Player.setAttack(previousAttack + chosenWeapon.getAttack());
                    System.out.println("You have equipped: " + chosenWeapon.getName());
                    previousAttack = chosenWeapon.getAttack();
                }
            } else if (choice == 0) {
                System.out.println("Cancelled equipping a weapon.");
            } else {
                System.out.println("Invalid choice. Please try again.");
                changeWeaponY();
            }
        }
        playerDetails();
    }

    public void changeAccessoryY() {
        System.out.println("===== EQUIPPING ACCESSORY =====");
        System.out.println("Current Accessory: " + Yobel.getEquipA());
        if (accessories.isEmpty()) {
            System.out.println("Inventory is Empty");
            yobelDetails();
        } else {
            for (int i = 0; i < accessories.size(); i++) {
                Accessory accessory = accessories.get(i);
                System.out.println("[" + (i + 1) + "] " + accessory.getName() + " Lv. " + accessory.getLevel() + " | Cost: " + accessory.getCost() + " | Health: " + accessory.getHealth());
            }
            System.out.print("Choose an accessory to equip (0 to cancel): ");
            choice = scan.nextInt();
            if (choice >= 1 && choice <= accessories.size()) {
                Yobel.setHealth(Yobel.getHealth() - previousHealth);
                Accessory chosenAccessory = accessories.get(choice - 1);
                if (chosenAccessory.getName().equals(Yobel.getEquipA())) {
                    System.out.println(Yobel.getName() + " already has " + chosenAccessory.getName() + " equipped.");
                } else {
                    previousHealth = Yobel.getHealth();
                    Yobel.setEquipA(chosenAccessory.getName());
                    Yobel.setHealth(previousHealth + chosenAccessory.getHealth());
                    System.out.println("You have equipped: " + chosenAccessory.getName());
                    previousHealth = chosenAccessory.getHealth();
                }
            } else if (choice == 0) {
                System.out.println("Cancelled equipping an accessory.");
            } else {
                System.out.println("Invalid choice. Please try again.");
                changeAccessoryY();
            }
        }
        yobelDetails();
    }

    public void changeAccessoryP() {
        System.out.println("===== EQUIPPING ACCESSORY =====");
        System.out.println("Current Accessory: " + Player.getEquipA());
        if (accessories.isEmpty()) {
            System.out.println("Inventory is Empty");
            playerDetails();
        } else {
            for (int i = 0; i < accessories.size(); i++) {
                Accessory accessory = accessories.get(i);
                System.out.println("[" + (i + 1) + "] " + accessory.getName() + " Lv. " + accessory.getLevel() + " | Cost: " + accessory.getCost() + " | Health: " + accessory.getHealth());
            }
            System.out.print("Choose an accessory to equip (0 to cancel): ");
            choice = scan.nextInt();
            if (choice >= 1 && choice <= accessories.size()) {
                Yobel.setHealth(Yobel.getHealth() - previousHealth);
                Accessory chosenAccessory = accessories.get(choice - 1);
                if (chosenAccessory.getName().equals(Player.getEquipA())) {
                    System.out.println(Player.getName() + " already has " + chosenAccessory.getName() + " equipped.");
                } else {
                    previousHealth = Player.getHealth();
                    Player.setEquipA(chosenAccessory.getName());
                    Player.setHealth(previousHealth + chosenAccessory.getHealth());
                    System.out.println("You have equipped: " + chosenAccessory.getName());
                    previousHealth = chosenAccessory.getHealth();
                }
            } else if (choice == 0) {
                System.out.println("Cancelled equipping an accessory.");
            } else {
                System.out.println("Invalid choice. Please try again.");
                changeAccessoryP();
            }
        }
        playerDetails();
    }

    public void inventory() {
        System.out.println("""
                           ----- CHECKING INVENTORY -----
                           [1] Check Weapons
                           [2] Check Accessories
                           [0] Return""");
        System.out.print("Choose: ");
        option = scan.nextInt();

        switch (option) {
            case 1 ->
                checkWeapon();
            case 2 ->
                checkAccessory();
            case 0 ->
                start();
        }
    }

    public void checkWeapon() {
        if (weapons.isEmpty()) {
            System.out.println("Inventory is Empty");
            inventory();
        } else {
            System.out.println("=== Weapons Inventory ===");
            for (int i = 0; i < weapons.size(); i++) {
                Weapon weapon = weapons.get(i);
                System.out.println("[" + (i + 1) + "] " + weapon.getName() + " Lv. " + weapon.getLevel() + " | Cost: " + weapon.getCost() + " | Attack: " + weapon.getAttack());
            }
        }
        inventory();
    }

    public void checkAccessory() {
        if (accessories.isEmpty()) {
            System.out.println("Inventory is Empty");
            inventory();
        } else {
            System.out.println("=== Accessories Inventory ===");
            for (int i = 0; i < accessories.size(); i++) {
                Accessory accessory = accessories.get(i);
                System.out.println("[" + (i + 1) + "] " + accessory.getName() + " Lv. " + accessory.getLevel() + " | Cost: " + accessory.getCost() + " | Health: " + accessory.getHealth());
            }
        }
        inventory();
    }

    public void store() {
        System.out.println("""
                           Willas: Welcome to my store, how can i help you?
                           [1] Buy Weapon
                           [2] Buy Accessories
                           [0] Return""");
        System.out.print("Choose: ");
        option = scan.nextInt();
        System.out.println("---------------------------");

        switch (option) {
            case 1 ->
                buyWeapon();
            case 2 ->
                buyAccessory();
            case 3 ->
                start();
        }
    }

    public void buyWeapon() {
        shopWeapons.clear();
        System.out.println("Money: " + Player.getMoney());
        for (int i = 0; i < 5; i++) {
            rarity = rand.nextInt(100);
            setWeapon();

            System.out.print("[" + (i + 1) + "] ");
            Weapon weapon;
            if (rarity < 10) {
                weapon = new Weapon(Willas.getName(), Willas.getLevel(), Willas.getCost(), Willas.getAttack());
            } else if (rarity >= 10 && rarity < 40) {
                weapon = new Weapon(Gauntlets.getName(), Gauntlets.getLevel(), Gauntlets.getCost(), Gauntlets.getAttack());
            } else if (rarity >= 40 && rarity < 70) {
                weapon = new Weapon(Sword.getName(), Sword.getLevel(), Sword.getCost(), Sword.getAttack());
            } else {
                weapon = new Weapon(Knife.getName(), Knife.getLevel(), Knife.getCost(), Knife.getAttack());
            }
            shopWeapons.add(weapon);
            System.out.println(weapon.getName() + " Lv. " + weapon.getLevel() + " | Cost: " + weapon.getCost() + " | Attack: " + weapon.getAttack());
        }

        System.out.println("[6] Reroll (Costs 50)");
        System.out.println("[0] Return");
        System.out.print("Choose: ");
        choice = scan.nextInt();
        System.out.println("---------------------------");

        if (choice == 6) {
            Player.setMoney(Player.getMoney() - 50);
            buyWeapon();
        } else if (choice == 0) {
            start();
        } else if (choice >= 1 && choice <= 5) {
            Weapon chosenWeapon = shopWeapons.get(choice - 1);
            if (Player.getMoney() >= chosenWeapon.getCost()) {
                Player.setMoney(Player.getMoney() - chosenWeapon.getCost());
                weapons.add(chosenWeapon);
                System.out.println("Added " + chosenWeapon.getName() + " to your inventory.");
                System.out.println("---------------------------");
                ownedW++;
                buyWeapon();
            } else {
                System.out.println("You don't have enough money to buy " + chosenWeapon.getName());
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public void buyAccessory() {
        shopAccessories.clear();
        System.out.println("Money: " + Player.getMoney());
        for (int i = 0; i < 5; i++) {
            rarity = rand.nextInt(100);
            setAccessory();

            System.out.print("[" + (i + 1) + "] ");
            Accessory accessory;
            if (rarity < 10) {
                accessory = new Accessory(Suit.getName(), Suit.getLevel(), Suit.getCost(), Suit.getHealth());
            } else if (rarity > 10 && rarity < 40) {
                accessory = new Accessory(Pants.getName(), Pants.getLevel(), Pants.getCost(), Pants.getHealth());
            } else if (rarity > 41 && rarity < 70) {
                accessory = new Accessory(Ring.getName(), Ring.getLevel(), Ring.getCost(), Ring.getHealth());
            } else {
                accessory = new Accessory(Necklace.getName(), Necklace.getLevel(), Necklace.getCost(), Necklace.getHealth());
            }
            shopAccessories.add(accessory);
            System.out.println(accessory.getName() + " Lv. " + accessory.getLevel() + " | Cost: " + accessory.getCost() + " | Health: " + accessory.getHealth());
        }

        System.out.println("[6] Reroll (Costs 50)");
        System.out.println("[0] Return");
        System.out.print("Choose: ");
        choice = scan.nextInt();
        System.out.println("---------------------------");

        if (choice == 6) {
            Player.setMoney(Player.getMoney() - 50);
            buyAccessory();
        } else if (choice == 0) {
            start();
        } else if (choice >= 1 && choice <= 5) {
            Accessory chosenAccessory = shopAccessories.get(choice - 1);
            if (Player.getMoney() >= chosenAccessory.getCost()) {
                Player.setMoney(Player.getMoney() - chosenAccessory.getCost());
                accessories.add(chosenAccessory);
                System.out.println("Added " + chosenAccessory.getName() + " to your inventory.");
                System.out.println("---------------------------");
                ownedA++;
                buyAccessory();
            } else {
                System.out.println("You don't have enough money to buy " + chosenAccessory.getName());
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public void exit() {
        System.out.println("Thank you for playing Yobel's Fantasy World!");
        System.exit(0);
    }

    public void setWeapon() {
        Knife.setLevel(rand.nextInt(1, 30));
        Knife.setAttack(rand.nextInt(1, 3) + Knife.getLevel());
        Knife.setCost(rand.nextInt(100, 200) + (Knife.getLevel() * 2));

        Sword.setLevel(rand.nextInt(1, 30));
        Sword.setAttack(rand.nextInt(4, 6) + Sword.getLevel());
        Sword.setCost(rand.nextInt(201, 300) + (Sword.getLevel() * 2));

        Gauntlets.setLevel(rand.nextInt(1, 30));
        Gauntlets.setAttack(rand.nextInt(7, 9) * (2 + Gauntlets.getLevel()));
        Gauntlets.setCost(rand.nextInt(301, 400) + (Gauntlets.getLevel() * 2));

        Willas.setLevel(rand.nextInt(1, 30));
        Willas.setAttack(rand.nextInt(10, 15) * (2 + Willas.getLevel()));
        Willas.setCost(rand.nextInt(401, 500) + (Willas.getLevel() * 2));
    }

    public void setAccessory() {
        Necklace.setLevel(rand.nextInt(1, 30));
        Necklace.setHealth(rand.nextInt(1, 5) * (Necklace.getLevel() / 2) + (Necklace.getLevel() * 3));
        Necklace.setCost(rand.nextInt(100, 200) + (Necklace.getLevel() * 2));

        Ring.setLevel(rand.nextInt(1, 30));
        Ring.setHealth(rand.nextInt(6, 10) * (Ring.getLevel() / 2) + (Ring.getLevel() * 3));
        Ring.setCost(rand.nextInt(201, 300) + (Ring.getLevel() * 2));

        Pants.setLevel(rand.nextInt(1, 30));
        Pants.setHealth(rand.nextInt(11, 15) * (Pants.getLevel() / 2) + (Pants.getLevel() * 3));
        Pants.setCost(rand.nextInt(301, 400) + (Pants.getLevel() * 2));

        Suit.setLevel(rand.nextInt(1, 30));
        Suit.setHealth(rand.nextInt(16, 20) * (Suit.getLevel() / 2) + (Suit.getLevel() * 3));
        Suit.setCost(rand.nextInt(401, 500) + (Suit.getLevel() * 2));
    }
}
