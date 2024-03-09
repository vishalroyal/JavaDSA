package ComparatorLogic;

import java.util.Comparator;

public class IdComparator implements Comparator<Employee2> {
    @Override
    public int compare(Employee2 o1, Employee2 o2) {
        return o1.getEmpId()-o2.getEmpId();
    }
}
