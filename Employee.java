public class Employee {
    private int employeeID;
    private String name;

    public void setID(int id){
        this.employeeID = id;
    }

    public void setname(String name){
        this.name = name;
    }

    public int getID(){
        return this.employeeID;
    }

    public String getName(){
        return this.name;
    }
}