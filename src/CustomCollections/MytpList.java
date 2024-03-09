package CustomCollections;

import java.util.Arrays;

public class MytpList {

    public static int capacity=10;
    int size =0;

    Object[] objArray;

    public MytpList()
    {
        objArray=new Object[capacity];
    }

    public void add(Object obj)
    {
        if(size== objArray.length)
            increaseCapacity();
        objArray[size++]=obj;
    }

    private void increaseCapacity() {
        int newCapacity= (objArray.length * 3)/2;
        objArray= Arrays.copyOf(objArray,newCapacity);
    }

    public int size()
    {
        return size;
    }

    public Object get(int index)
    {
        if(index<0 || index>=objArray.length)
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


    public static void main(String args[])
    {
        MytpList vishalList =new MytpList();
        vishalList.add("vishal");
        vishalList.add("abhi");
        vishalList.display();
        System.out.println(vishalList.size());
        System.out.println(vishalList.get(1));
    }





}
