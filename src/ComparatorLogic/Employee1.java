package ComparatorLogic;


public class Employee1 implements Comparable<Employee1>{

    String Name;
    int empId;

   public Employee1(String Name, int empId){
        this.Name= Name;
        this.empId=empId;
    }




    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    @Override
    public int compareTo(Employee1 o) {
        return this.empId-o.empId;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "Name='" + Name + '\'' +
                ", empId=" + empId +
                '}';
    }
}
