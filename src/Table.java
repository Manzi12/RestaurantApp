public class Table {
    private int tableNumber;
    private int capacity;
    private boolean isReserved;
    private Customer reservedBy;

    public Table(int tableNumber, int capacity){
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.isReserved = false;
    }

    public int getTableNumber(){
        return tableNumber;
    }

    public int getCapacity(){
        return capacity;
    }

    public boolean getIsReserved(){
        return isReserved;
    }

    public Customer getReservedBy(){
        return reservedBy;
    }

    public void reserveTable(Customer customer){
        isReserved = true;
        reservedBy = customer;
    }

    public void releaseTable(){
        isReserved = false;
        reservedBy = null;
    }

    public String toString() {
        return "Table " + tableNumber + " (Capacity: " + capacity + ")";
    }
}
