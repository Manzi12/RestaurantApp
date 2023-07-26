import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RestaurantApp {

//    static Menu menu = new Menu();
    public static void main(String[] args) {
        List<Table> tables = new ArrayList<>();
        tables.add(new Table(1,4));
        tables.add(new Table(2,2));
        tables.add(new Table(3,6));

        Menu menu = new Menu();
        menu.addMenuItem(new MenuItem("Burger",9.00));
        menu.addMenuItem(new MenuItem("Salad",9.99));
        menu.addMenuItem(new MenuItem("all drinks",3.00));
        menu.addMenuItem(new MenuItem("Chips",4.00));

        List<Customer> customers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("1. Display Menu");
            System.out.println("2. Take Order");
            System.out.println("3. Reserve Table");
            System.out.println("4. Show Tables");
            System.out.println("0. Exit");
            System.out.println("Enter your choice:");

            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Menu");
                    menu.displayMenu();
                    System.out.println("----------------------------------");
                    break;

                case 2:
                    Order order = takeOrder(scanner, menu);
                    displayOrder(order);
                    break;

                case 3:
                    Customer customer = createCustomer(scanner);
                    reserveTable(scanner, tables,customer);
                    break;

                case 4:
                    showTables(tables);
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice, try again");
                    break;
            }
        } while (choice != 0);
        scanner.close();

    }

    private static Order takeOrder(Scanner scanner, Menu menu){
        Order order = new Order();
        int choice;

        do {
            System.out.println("Menu:");
            menu.displayMenu();

            System.out.println("Enter the item number to add to your order (0 to finish):");
            choice = scanner.nextInt();

            if (choice > 0 && choice <= menu.getMenuSize()) {
                MenuItem selectedItem = menu.getMenuItem(choice);
                order.addItem(selectedItem);
                System.out.println(selectedItem.getName() + " added to your order.");
            } else if (choice != 0) {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        return order;

        }


    private static void displayOrder(Order order){
        System.out.println("\nYour order:");
        for (MenuItem item : order.getItems()) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        System.out.println("Total: $" + order.getTotalPrice());
        System.out.println("----------------------------------------------");
    }


    private static Customer createCustomer(Scanner scanner){
        scanner.nextLine();
        System.out.println("Enter customerr name");
        String name = scanner.nextLine();

        System.out.println("Enter your contact number");
        String contactNumber = scanner.nextLine();

        Customer customer = new Customer(name, contactNumber);
        System.out.println("Customer details : " + customer);
        return customer;
    }

    private static void reserveTable(Scanner scanner, List<Table> tables, Customer customer){
        System.out.println("Available table");
        showAvailableTables(tables);

        System.out.println("Enter the table number to reserve : ");
        int tableNumber = scanner.nextInt();

        for (Table table : tables){
            if (table.getTableNumber() == tableNumber){
                if (table.getIsReserved()){
                    System.out.println("Table " + tableNumber + "is already reserved");
                } else {
                    table.reserveTable(customer);
                    System.out.println("Table " + tableNumber + " reserved succussfully by " + customer.getName());
                }
                return;
            }
        }
    }

    private static void showTables(List<Table> tables){
        System.out.println("Tables ");
        for (Table table: tables){
            System.out.println(table);
            if (table.getIsReserved()){
                System.out.println("(Reserved by " + table.getReservedBy().getName() + ")");
            } else {
                System.out.println("Available");
            }
        }
    }

    private static void showAvailableTables(List<Table> tables){
        System.out.println("Available tables: ");
        for (Table table : tables){
            if (!table.getIsReserved()){
                System.out.println(table);
            }
        }
    }


}

