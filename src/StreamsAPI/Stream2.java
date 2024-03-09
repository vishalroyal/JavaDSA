package StreamsAPI;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Stream2 {

    public static void main(String args[])
   {

       //sum of list
       List<Integer> integerList= Arrays.asList(1,4,3,2,4,4,43,45);
       List<Integer> integerList1=Arrays.asList(22,223,334,221,432,432);
       Optional<Integer> optionalInteger=integerList.stream().reduce((a, b)->a+b);
       System.out.println("sum "+optionalInteger.get());


       //multiply and average
       Double d=integerList.stream().map(a->a*a).mapToInt(e->e).average().getAsDouble();
       System.out.println("avg "+d.floatValue());


       //no starting with 2
       List<Integer>integers=integerList1.stream().map(Object::toString).filter(e->e.startsWith("2")).map(Integer:: valueOf).collect(Collectors.toList());
       System.out.println("2's starting with "+integers);

       //duplicate no different way
       Set<Integer> duplicateNum= integerList.stream().filter(e-> Collections.frequency(integerList,e)>1).collect(Collectors.toSet());
       System.out.println("Duplicate No's  "+duplicateNum);

       //duplicate no third way different way
      Set<Integer> dupNum=new HashSet<>();
      Set<Integer> dupNum1=  integerList.stream().filter(e-> !dupNum.add(e)).collect(Collectors.toSet());
      System.out.println("Duplicate No' set way  "+dupNum1);

      //max no
       int max= integerList1.stream().max(Comparator.comparing(Integer::valueOf)).get();
       System.out.println("max no bro "+max);

       //min no
       int min=  integerList1.stream().min(Comparator.comparing(Integer::valueOf)).get();
       System.out.println("min no bro "+min);

       //sort the list
       List<Integer> sortedList= integerList.stream().sorted().collect(Collectors.toList());
       System.out.println("sorted set "+ sortedList);

       //sort the list in reverorder
       List<Integer> reversedList = integerList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
       System.out.println("reversed List "+reversedList );

       //get first 5 distinct nos and their sum
       int aasas= integerList.stream().sorted().distinct().limit(5).reduce((a, b) -> a + b).get();
       System.out.println("first 5 no's sum "+ aasas);

       //second highest
       int secondHigh=integerList.stream().distinct().sorted(Collections.reverseOrder()).skip(1).findFirst().get();
       System.out.println("Second High "+secondHigh);

       //Second smallest
       int secondSmall=integerList.stream().distinct().sorted().skip(1).findFirst().get();
       System.out.println("Second Small "+secondSmall);

       List<Integer> integerList3= Arrays.asList(1,4,3,2,4,4,43,45);
       int sum=integerList3.stream().filter(a->a%2==0).reduce((a,b)->a+b).get();
       System.out.println(sum);







   }

}
