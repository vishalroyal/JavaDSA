package CustomCollections;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class VishalList
{

    Object objArray [];
    int size = 0;
    public VishalList()
    {
        objArray=new Object[10];
    }
    public void add(Object obj)
    {
        if(size== objArray.length)
            increaseCapacity();
        objArray[size++]=obj;
    }

    public int size()
    {
        return size;
    }

    public Object get(int index)
    {
        if(index<0 || index>=size)
            throw new ArrayIndexOutOfBoundsException("invalid index "+ index);
        return objArray[index];
    }

    public void display()
    {
        for(int i=0;i<size;i++)
        {
            System.out.println(objArray[i]);
        }
    }


    private void increaseCapacity() {
       int newCapacity= (objArray.length*3)/2;
       objArray=Arrays.copyOf(objArray,newCapacity);
    }


    public static void main(String args[])
    {
        VishalList vishalList =new VishalList();
        vishalList.add("vishal");
        vishalList.add("abhi");
        vishalList.display();
        System.out.println(vishalList.size());
        System.out.println(vishalList.get(1));
    }

}

/*
class VishalList
{
    Object [] objArray;
    int size = 0;

    public VishalList()
    {
        objArray=new Object[10];
    }


    public void add(Object obj)
    {
        if(size== objArray.length)
            increaseCapacity();
        objArray[size++]=obj;

    }

    private void increaseCapacity() {
       int newCapacity= (objArray.length*3)/2;
       objArray= Arrays.copyOf(objArray,newCapacity);
    }

    public int size()
    {
        return size;
    }

    public void display() {
        for (int i = 0; i < size; i++)
        {
            System.out.println(objArray[i]);
        }
    }

    public Object get(int index)
    {
        if(index<0 || index>=size)
            throw new ArrayIndexOutOfBoundsException("Invalid index" + index);
        return objArray[index];
    }





    public static void main(String args[])
{

    VishalList ls=new VishalList();
    ls.add("vishal");
    ls.display();
    System.out.println(ls.size());
}

}


 */
