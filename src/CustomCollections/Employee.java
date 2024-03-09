package CustomCollections;

public final class Employee{

    private final String Name;
    private final int AccNumber;

    public Employee(String Name, int AccNumber)
    {
        this.Name=Name;
        this.AccNumber=AccNumber;
    }

    public String getName(){
        return Name;
    }

    public int getAccNumber(){
        return AccNumber;
    }



}

