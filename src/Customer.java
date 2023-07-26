public class Customer {
    private String name;
    private String contactNumber;

    public Customer(String name, String contactNumber){
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getName(){
        return name;
    }

    public String getContactNumber(){
        return contactNumber;
    }

    public String toString(){
        return
                "Name : " + name + " , " +
                "Contact Number : " + contactNumber;
    }
}
