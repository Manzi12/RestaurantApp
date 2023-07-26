import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> menuItems;

    public Menu(){
        menuItems = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item){
        menuItems.add(item);
    }

    public int getMenuSize(){
        return menuItems.size();
    }

    public MenuItem getMenuItem(int index){
        if (index >= 0 && index < menuItems.size()){
            return menuItems.get(index -1);
        }

        return null;
    }

    public void displayMenu(){
        for (int i=0; i< menuItems.size(); i++){
            MenuItem item = menuItems.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - $" + item.getPrice());
        }
    }

}
