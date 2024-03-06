package Problem_1;

import java.util.*;

public class Menu {

    int option;
    int newHours;
    String newName;
    String newDesc;
    double newBalance;

    User Player = new User();
    Games Siege = new Games(200000, "Tom Clancy's Rainbow Six Siege", "Ubisoft", "FPS", 2015, false);
    Games Warframe = new Games(100000, "Warframe", "Digital Extremes", "MMORPG", 2013, false);
    Games RE = new Games(500000, "Resident Evil 4", "CAPCOM", "Survival Horror", 2023, false);
    Scanner scan = new Scanner(System.in);

    public void register() {
        try {
            System.out.print("Username: ");
            newName = scan.next() + scan.nextLine();
            Player.setUsername(newName);

            System.out.print("Profile Description: ");
            newDesc = scan.next() + scan.nextLine();
            Player.setDesc(newDesc);

            System.out.print("Starting UAP Balance: ");
            newBalance = scan.nextDouble();
            Player.setBalance(newBalance);

            menu();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please try again.");
        }

    }

    public void menu() {
        do {
            System.out.println("\nWelcome to UAP!");
            System.out.println("--------------------");
            System.out.println("UAP Balance: " + Player.getBalance() + "\nUAP Level: " + Player.getLevel() + "\nHours Streamed: " + Player.getHours());
            System.out.println("--------------------");
            try {
                System.out.println("""
                           Menu: 1. Buy a Game
                                 2. Show Library
                                 3. Sell Game
                                 4. Stream
                                 5. UAP Profile
                                 0. Exit""");
                System.out.print("Choose: ");
                option = scan.nextInt();
                System.out.println("--------------------");
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice, please try again.");
            }

            switch (option) {
                case 1 ->
                    buy();
                case 2 ->
                    show();
                case 3 ->
                    sell();
                case 4 ->
                    stream();
                case 5 ->
                    profile();
                case 0 ->
                    exit();
                default -> {
                    System.out.println("Invalid input, please try again.");
                }
            }
        } while (option != 0);
    }

    public void buy() {
        try {
            System.out.println("What are you buying?");
            System.out.println("Your UAP Balance: " + Player.getBalance());
            System.out.println("1. " + "[" + Siege.getPrice() + "] " + Siege.getName() + " - " + Siege.getDev() + " - " + Siege.getGenre() + " - " + Siege.getYear());
            System.out.println("2. " + "[" + Warframe.getPrice() + "] " + Warframe.getName() + " - " + Warframe.getDev() + " - " + Warframe.getGenre() + " - " + Warframe.getYear());
            System.out.println("3. " + "[" + RE.getPrice() + "] " + RE.getName() + " - " + RE.getDev() + " - " + RE.getGenre() + " - " + RE.getYear());
            System.out.print("Choose: ");
            option = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid choice, please try again.");
        }

        switch (option) {
            case 1 -> {
                if (Siege.isBought() == false) {
                    if (Player.getBalance() >= Siege.getPrice()) {
                        Player.setBalance(Player.getBalance() - Siege.getPrice());
                        System.out.println("Successfully bought " + Siege.getName() + ", +2 Level!");
                        Player.setLevel(Player.getLevel() + 2);
                        Siege.setBought(true);
                    } else {
                        System.out.println("Insufficient Funds!");
                    }
                } else {
                    System.out.println("You already have this game.");
                }
            }
            case 2 -> {
                if (Warframe.isBought() == false) {
                    if (Player.getBalance() >= Warframe.getPrice()) {
                        Player.setBalance(Player.getBalance() - Warframe.getPrice());
                        System.out.println("Successfully bought " + Warframe.getName() + ", +2 Level!");
                        Player.setLevel(Player.getLevel() + 2);
                        Warframe.setBought(true);
                    } else {
                        System.out.println("Insufficient Funds!");
                    }
                } else {
                    System.out.println("You already have this game.");
                }
            }
            case 3 -> {
                if (RE.isBought() == false) {
                    if (Player.getBalance() >= RE.getPrice()) {
                        Player.setBalance(Player.getBalance() - RE.getPrice());
                        System.out.println("Successfully bought " + RE.getName() + ", +2 Level!");
                        Player.setLevel(Player.getLevel() + 2);
                        RE.setBought(true);
                    } else {
                        System.out.println("Insufficient Funds!");
                        return;
                    }
                } else {
                    System.out.println("You already have this game");
                }
            }
            case 4 ->
                menu();
            default -> {
                System.out.println("Invalid input, please try again.");
            }
        }
    }

    public void show() {
        if (Siege.isBought()) {
            System.out.println("1. " + Siege.getName() + " - " + Siege.getDev() + " - " + Siege.getGenre() + " - " + Siege.getYear());
        }
        if (Warframe.isBought()) {
            System.out.println("2. " + Warframe.getName() + " - " + Warframe.getDev() + " - " + Warframe.getGenre() + " - " + Warframe.getYear());
        }
        if (RE.isBought()) {
            System.out.println("3. " + RE.getName() + " - " + RE.getDev() + " - " + RE.getGenre() + " - " + RE.getYear());
        }
        if (Siege.isBought() == false && Warframe.isBought() == false && RE.isBought() == false) {
            System.out.println("Nothing to show here.");
        }
    }

    public void sell() {
        try {
            if (Siege.isBought() == false && Warframe.isBought() == false && RE.isBought() == false) {
                System.out.println("Nothing to show here.");
                return;
            }
            System.out.println("What are you selling? (50% of Original Price)");
            if (Siege.isBought()) {
                System.out.println("1. " + "[Selling for 100000.0] " + Siege.getName() + " - " + Siege.getDev() + " - " + Siege.getGenre() + " - " + Siege.getYear());
            }
            if (Warframe.isBought()) {
                System.out.println("2. " + "[Selling for 50000.0] " + Warframe.getName() + " - " + Warframe.getDev() + " - " + Warframe.getGenre() + " - " + Warframe.getYear());
            }
            if (RE.isBought()) {
                System.out.println("3. " + "[Selling for 250000.0] " + RE.getName() + " - " + RE.getDev() + " - " + RE.getGenre() + " - " + RE.getYear());
            }

            System.out.print("Choose (0 to Exit): ");
            option = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid choice, please try again.");
        }

        switch (option) {
            case 1 -> {
                if (Siege.isBought()) {
                    Player.setBalance(Siege.getPrice() * 0.5 + Player.getBalance());
                    System.out.println("Successfully sold " + Siege.getName());
                    Siege.setBought(false);
                } else {
                    System.out.println("You don't have this game.");
                }
            }
            case 2 -> {
                if (Warframe.isBought()) {
                    Player.setBalance(Warframe.getPrice() * 0.5 + Player.getBalance());
                    System.out.println("Successfully sold " + Warframe.getName());
                    Warframe.setBought(false);
                } else {
                    System.out.println("You don't have this game.");
                }
            }
            case 3 -> {
                if (RE.isBought()) {
                    Player.setBalance(RE.getPrice() * 0.5 + Player.getBalance());
                    System.out.println("Successfully sold " + RE.getName());
                    RE.setBought(false);
                } else {
                    System.out.println("You don't have this game.");
                }
            }
            case 0 ->
                menu();
            default -> {
                System.out.println("Invalid input, please try again.");
            }
        }
    }

    public void stream() {
        try {
            if (Siege.isBought() || Warframe.isBought() || RE.isBought()) {
                System.out.println("Hours Streamed: " + Player.getHours());
                System.out.print("How many hours are you streaming?:");
                newHours = scan.nextInt();
                System.out.println("Streaming for " + newHours + " Hours");
                Player.setHours(newHours + Player.getHours());
                System.out.println("Streaming Done! You got " + (newHours * 100000) + " UAP Balance, Great Work!");
                Player.setBalance(Player.getBalance() + newHours * 100000);
            } else {
                System.out.println("You need to buy a game first.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid choice, please try again.");
        }
    }

    public void profile() {
        System.out.println("Here's your Profile \n");
        System.out.println("Username: " + Player.getUsername() + "\nDescription: " + Player.getDesc() + "\nBalance: " + Player.getBalance() + "\nLevel: " + Player.getLevel() + "\nHours Streamed: " + Player.getHours());
        System.out.print("\nDo you want to edit your profile? (Y/N): ");
        String choice = scan.next();

        if (choice.equalsIgnoreCase("Y")) {
            System.out.print("New Username: ");
            newName = scan.next();
            Player.setUsername(newName);

            System.out.print("New Description: ");
            newDesc = scan.next();
            Player.setDesc(newDesc);

            System.out.println("UAP Profile successfully updated!");
        } else {
            System.out.println("Back to Menu!");
        }
    }

    public void exit() {
        System.out.println("Thank you for using UAP!");
        System.exit(0);
    }
}
