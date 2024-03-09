package StreamsAPI;

public class Employee {

    String Name;
    String City;
    String Id;
    Double Salary;

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Name='" + Name + '\'' +
                ", City='" + City + '\'' +
                ", Id='" + Id + '\'' +
                ", Salary=" + Salary +
                '}';
    }


    public Employee(String name, String city, String id,Double salary) {
        Name = name;
        City = city;
        Id = id;
        Salary=salary;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }





}
