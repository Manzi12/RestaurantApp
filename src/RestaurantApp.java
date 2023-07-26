import java.util.Scanner;

public class RestaurantApp {
    public static void main(String[] args) {
        MenuItem burger = new MenuItem("Burger", 10.99);
        MenuItem chips = new MenuItem("Chips", 3.99);
        MenuItem drinks = new MenuItem("all Drinks", 2.99);
        MenuItem salad = new MenuItem("Salad", 5.99);

        Menu menu = new Menu();
        menu.addMenuItem(burger);
        menu.addMenuItem(chips);
        menu.addMenuItem(drinks);
        menu.addMenuItem(salad);

        Order order = new Order();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu");
            menu.displayMenu();

            System.out.println("Enter the Item number to add to your order (0 to finish)");
            choice = scanner.nextInt();

            if (choice > 0 && choice <= menu.getMenuSize()){
                MenuItem selectedItem = menu.getMenuItem(choice);
                order.addItem(selectedItem);
                System.out.println(selectedItem.getName() + " added to your oder");
            } else if (choice !=0) {
                System.out.println("Invalid choice. please try again");

            }
        } while (choice !=0);
            System.out.println("Your Orders ");
            for (MenuItem item : order.getItems()){
                System.out.println(item.getName() + "- $" + item.getPrice());
            }
            System.out.println("Total : $" + order.getTotalPrice());
            scanner.close();
        }
    }
