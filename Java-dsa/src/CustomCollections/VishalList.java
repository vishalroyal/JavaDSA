package CustomCollections;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;


class VishalList<T> extends AbstractList<T>
{
    private List<T> internalList;

    public VishalList(){
        this.internalList=new ArrayList<>();
    }

    @Override
    public T get(int index) {
        return internalList.get(index);
    }

    @Override
    public int size() {
        return internalList.size();
    }

    @Override
    public boolean add(T element){
     return   internalList.add(element);
    }


    @Override
    public String toString()
    {
        return internalList.toString();
    }


}


