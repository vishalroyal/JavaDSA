package StreamsAPI;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream1 {

    public static void main(String args[]) {

            //1st example

            Employee e1 = new Employee("vishal", "mumbai", "34",5000.00);
            Employee e2 = new Employee("kishal", "pune", "35",7000.00);
            Employee e3 = new Employee("bishal", "dubai", "36",10000.00);
            Employee e4=new Employee("sidhesh","pune","37",750000.00);
            Employee e5=new Employee("sidheshwar","pune","38",950000.00);
            Employee e6=new Employee("bhavna","mumbai","39",990000.00);


            List<Employee> employeeList = new ArrayList<>();
            employeeList.add(e1);
            employeeList.add(e2);
            employeeList.add(e3);
            employeeList.add(e4);
            employeeList.add(e5);
            employeeList.add(e6);

            //fetch the records based on city
         Map<String,List<Employee>> listMap  =  employeeList.stream().collect(Collectors.groupingBy(employee -> employee.City));
         listMap.forEach((key,value)->System.out.println("city "+key+ " employees "+value));

        //using reduce operation
        Integer arr[]={1,2,3,4};
        Optional<Integer> inter= Arrays.asList(arr).stream().reduce((a, b)->a*b);
        System.out.println(inter.get());


        //Compare get the records by city and name and compare them
        employeeList.sort(Comparator.comparing(Employee::getCity).thenComparing(Employee::getName));
        employeeList.forEach(e->System.out.println(e));

        //check the given name's('vishal') count in the below array
        String [] strings={"Amit","Visha","visha","her","fufa","bhavna","gublya","bhavna"};
        long count= Arrays.asList(strings).stream().filter(e->"vishal".equalsIgnoreCase(e)).count();
        System.out.println(count);

        //get the list of Employees who's id > 34
        List<Employee>employeeList1=employeeList.stream().filter(e->Integer.parseInt(e.getId())>34).collect(Collectors.toList());
        employeeList1.forEach(e->System.out.println(e.getId()));

        //Count the vowels in given string
        String s="helllo world";
        long intw= s.chars().filter((e)-> (e=='a'||  e =='e' || e== 'i' || e=='o' || e=='u' )).distinct().count();
        System.out.println("intw "+intw);

        //Count the vowels in given string
        long countOfVowwles=Arrays.stream(s.split("")).filter(a->"aeiouAEIOU".contains(a)).distinct().count();
        System.out.println("countOfVowwles "+ countOfVowwles);

        //character and its count
        Map<String,Long> charCount = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
        System.out.println("char and its count "+ charCount);

        //String and its occurance in that string
        List<String> stringList = Arrays.asList("vishal","bhavna","vish","bhav","vishal","bhavna");
        Map<String,Long> mapOfCounting = stringList.stream().collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
        System.out.println("name and its occurances "+ mapOfCounting);


        //Citywise Employee's Max salary
        Map<String, Optional<Employee>> employeeSalary= employeeList.stream().collect(Collectors.groupingBy(Employee::getCity,Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        employeeSalary.forEach((key,value)-> System.out.println("Employee salary citywise "+key +"  "+ value ));

        //find the second highest from an array using stream
        Integer numArray[]={34,552,32,232,43};
        Integer secondHighest= Arrays.stream(numArray).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(secondHighest);


        //10th example most imp even/odd without modulus operator
        int n=100;
        if((n/2)*2==n)
            System.out.println("no is even");
         else
            System.out.println("no is odd");

        //another way to do even odd is bitwise operator
        System.out.println("enter a number");
        //Scanner in = new Scanner(System.in);
        //int no = Integer.parseInt(in.nextLine());
        System.out.println("your entered no  : "+ 35);
        if((35&1)==0)
            System.out.println("even ahe bhau");
        else
            System.out.println("odd ahe bhau ");


        //smallest missing number in array
        int arr1[]={1,9,2,3,5,6,8};
        Arrays.sort(arr1);
        int temp=1;
        for(int i=0;i< arr1.length;i++) {
            if(arr1[i] == temp) {
                //System.out.println("already there bro");
                temp++;
            } else {
                System.out.println("missing no ahe bhau " + temp);
                break;
            }}

        //first repeative and non-repetative character
        String sq="hello world";
        Map<Character,Long> counts= sq.chars().mapToObj(i-> (char)i).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
        Optional<Character> firstNon= counts.entrySet().stream().filter((e)->e.getValue()==1).map(Map.Entry::getKey).findFirst();
        System.out.println("non repeating one "+ firstNon.get());
        Optional<Character> firstRepeat= counts.entrySet().stream().filter((e)->e.getValue()>1).map(e->e.getKey()).findFirst();
        System.out.println("repeating one "+ firstRepeat.get());


        //find common elements from two array
        Set<Integer> finalInteger=new HashSet<>();
        Set<Integer> finalSet=new HashSet<>();
        int arrr1[]={34,45,67,87,89};
        int arrr2[]={24,65,78,45,34,56};

        for(int i=0;i<arrr1.length;i++) {
            finalInteger.add(arrr1[i]);
        }
        for(int i=0;i<arrr2.length;i++) {
            if (finalInteger.contains(arrr2[i]))
                finalSet.add(arrr2[i]);
        }
        for(Integer j:finalSet)
            System.out.println("Common numbers bro "+j);


        //List Of Cities in employee List
        List<String> eCity= employeeList.stream().map(Employee::getCity).collect(Collectors.toList());
        System.out.println("cities "+ eCity);

        //reverse string using stream
        String so="vishal";
        String reversed=  Stream.of(so)
                    .map(word->new StringBuilder(word).reverse())
                    .collect(Collectors.joining(" "));
        System.out.println(reversed +" using stringbuilder");

        //reverse using charArray
        char [] achars=so.toCharArray();
        IntStream.range(0,so.length())
                .mapToObj(i -> achars[(achars.length - 1) - i]).forEach(e->System.out.print(e));
        System.out.println();


        //split the string without using split function
        String str = "geekss@for@geekss";
        System.out.println(" split no without split funtn");
        for(int i = 0; i <str.length();i++) {
            if(str.charAt(i)=='@') {
                System.out.println();
                continue;
            }
           System.out.print(str.charAt(i));

        }

        //reverse a number normal way
        String sdf="";
        for (int i=so.length()-1;i>=0;i--)
            sdf=sdf+so.charAt(i);
        System.out.println('\n'+"Normal way "+ sdf);


        //repeated and non repeated way
        String asr="Vishal hello";
        Map<Character,Long> characterLongMap= asr.chars().mapToObj(i->(char)i).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
        characterLongMap.entrySet().stream().forEach(System.out::println);
        Character nonRepeated=  characterLongMap.entrySet().stream().filter(e->e.getValue()==1).map(e->e.getKey()).findFirst().get();
        Character repeated=   characterLongMap.entrySet().stream().filter(e->e.getValue()>1).map(e->e.getKey()).findFirst().get();
        System.out.println("first non repeated "+ nonRepeated + " , First repeated "+ repeated );

        //Longest subsequence
        String asasa="java";
        char[] asaasa=asasa.toCharArray();
        int longsub=0;
        String Longest="";
        Map<Character,Integer> integerMap=new LinkedHashMap<>();
        for(int i=0 ;i<asaasa.length;i++) {
            if (!integerMap.containsKey(asaasa[i]))
                integerMap.put(asaasa[i], i);
            else {
                i = integerMap.get(asaasa[i]);
                integerMap.clear();
            }

            if (integerMap.size() > longsub) {
                longsub = integerMap.size();
                Longest = integerMap.keySet().toString();
            }
        }
        System.out.println(longsub + "   " + Longest);


        String arr12 [] ={"3","30","34","5","9"};
        Arrays.stream(arr12).sorted(Comparator.reverseOrder()).forEach(System.out::print);

    }




    }







