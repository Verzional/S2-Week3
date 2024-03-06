package Problem_1;

public class Games {
    private String name;
    private String dev;
    private String genre;
    private int year;
    private int hours;
    private double price;
    private boolean bought;
    
    public Games(double price, String name, String dev, String genre, int year, boolean bought){
        this.price = price;
        this.name = name;
        this.dev = dev;
        this.genre = genre;
        this.year = year;
        this.bought = bought;
        hours = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDev() {
        return dev;
    }

    public void setDev(String dev) {
        this.dev = dev;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }
}
