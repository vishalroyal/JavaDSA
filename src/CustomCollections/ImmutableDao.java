package CustomCollections;

public class ImmutableDao
{
    public static void main(String ar[])
    {
       Employee obj=new Employee("vishal",1212131312);

        String s1 = obj.getName();

        System.out.println("Pancard Number: " + s1);

    }
}