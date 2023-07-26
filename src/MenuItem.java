public class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price){
        this.name = name;
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuItem" + "\n" +
                "name = " + name + "\n" +
                "price=" + price + "\n";

    }
}
