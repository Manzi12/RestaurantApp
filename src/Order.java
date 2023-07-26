import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> items;

    public Order(){
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item){
        items.add(item);
    }

    public double getTotalPrice(){
        double total = 0;
        for (MenuItem item: items){
            total += item.getPrice();
        }
        return total;
    }

    public void dsiplayOrderList(){
        for (MenuItem item : items){
            System.out.println(item);
        }
    }
}
