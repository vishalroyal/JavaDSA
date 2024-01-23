package ComparatorLogic;

public class Employee2 {
    String Name;
    int EmpId;
    Double Salary;

    public Employee2(String Name,int EmpId, Double salary){
        this.Name=Name;
        this.EmpId=EmpId;
        this.Salary=salary;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getEmpId() {
        return EmpId;
    }

    public void setEmpId(int empId) {
        EmpId = empId;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "Name='" + Name + '\'' +
                ", EmpId=" + EmpId +
                ", Salary=" + Salary +
                '}';
    }
}
