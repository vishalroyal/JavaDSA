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

         Map<String,List<Employee>> listMap  =  employeeList.stream().collect(Collectors.groupingBy(employee -> employee.City));
         listMap.forEach((key,value)->System.out.println("city "+key+ " employees "+value));

        //2nd example
        Integer arr[]={1,2,3,4};
        List<Integer>multiList= Arrays.asList(arr);

       Optional<Integer> inter= multiList.stream().reduce((a, b)->a*b);
       System.out.println(inter.get());


       //3rd Example
       employeeList.sort(Comparator.comparing(Employee::getCity).thenComparing(Employee::getName));
       employeeList.forEach(e->System.out.println(e));

       //4th example
       String [] strings={"Amit","Visha","visha","her","fufa","bhavna","gublya","bhavna"};
       Stream<String> stringStream=Arrays.asList(strings).stream();
       long count= stringStream.filter(e->"vishal".equalsIgnoreCase(e)).count();
       System.out.println(count);

       Supplier<Stream<String>> stremSupplier=()-> Stream.of(strings);
       long Count=stremSupplier.get().filter(e->e.equalsIgnoreCase("visha")).count();
       stremSupplier.get().forEach(e->System.out.println(e));

        //5th Example
        List<Employee>employeeList1=employeeList.stream().filter(e->Integer.parseInt(e.getId())>34).collect(Collectors.toList());
        employeeList1.forEach(e->System.out.println(e.getId()));

        //6th Example
        String s="helllo world";
        long intw= s.chars().filter((e)-> (e=='a'||  e =='e' || e== 'i' || e=='o' || e=='u' )).distinct().count();
        System.out.println(intw);

        //other way to do 6th example
        long countOfVowwles=Arrays.stream(s.split("")).filter(a->"aeiouAEIOU".contains(a)).distinct().count();
        System.out.println(countOfVowwles);

       Map<String,Long> charCount= Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        for (Map.Entry<String, Long> JK : charCount.entrySet()) {
            if(JK.getValue()>1)
            {
                System.out.println("Duplicates "+JK.getKey());
            }
        }
       charCount.forEach((key,value)-> System.out.println(" Char "+ key + " value "+value));


        //7th example
        List<String> stringList=Arrays.asList("vishal","bhavna","vish","bhav","vishal","bhavna");

     Map<String,Long> mapOfCounting=  stringList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
     mapOfCounting.forEach((key,value)->System.out.println(" key "+ key + " value "+value));


        //8th example
       Map<String, Optional<Employee>> employeeSalary= employeeList.stream().collect(Collectors.groupingBy(Employee::getCity,Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        employeeSalary.forEach((key,value)-> System.out.println(key +"  "+ value ));

        //9th exapmle find the second highest from an array using stream
        Integer numArray[]={34,552,32,232,43};
        Integer secondHighest= Arrays.stream(numArray).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(secondHighest);


        //10th example most imp even/odd without modulus operator
        int n=100;
        if((n/2)*2==n) {
            System.out.println("no is even");
        }
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
        for(int i=0;i< arr1.length;i++)
        {
            if(arr1[i] == temp) {
                //System.out.println("already there bro");
                temp++;
            }
            else {
                System.out.println("missing no ahe bhau " + temp);
                break;
            }
        }

        //10th example first repeative and non-repetative character

           String sq="hello world";
           Map<Character,Long> counts= sq.chars().mapToObj(i-> (char)i).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));

           Optional<Character> firstNon= counts.entrySet().stream().filter((e)->e.getValue()==1).map(e->e.getKey()).findFirst();
           System.out.println("non repeating one "+ firstNon.get());

           Optional<Character> firstRepeat= counts.entrySet().stream().filter((e)->e.getValue()>1).map(e->e.getKey()).findFirst();
           System.out.println("repeating one "+ firstRepeat.get());


        //11th example to find common elements from two array
        Set<Integer> finalInteger=new HashSet<>();
        Set<Integer> finalSet=new HashSet<>();
        int arrr1[]={34,45,67,87,89};
        int arrr2[]={24,65,78,45,34,56};


        for(int i=0;i<arrr1.length;i++)
        {
            finalInteger.add(arrr1[i]);

        }
        for(int i=0;i<arrr2.length;i++) {
            if (finalInteger.contains(arrr2[i]))
                finalSet.add(arrr2[i]);

        }
        for(Integer j:finalSet)
            System.out.println("Common numbers bro "+j);



        //List Of Cities in employee
        List<String> eCity= employeeList.stream().map(e->e.getCity()).collect(Collectors.toList());
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
        {
            sdf=sdf+so.charAt(i);
        }
        System.out.println('\n'+"Normal way "+ sdf);



        String asr="Vishal hello";
      Map<Character,Long> characterLongMap= asr.chars().mapToObj(i->(char)i).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
        characterLongMap.entrySet().stream().forEach(System.out::println);
      Character nonRepeated=  characterLongMap.entrySet().stream().filter(e->e.getValue()==1).map(e->e.getKey()).findFirst().get();
        Character repeated=    characterLongMap.entrySet().stream().filter(e->e.getValue()>1).map(e->e.getKey()).findFirst().get();

        System.out.println("first non repeated "+ nonRepeated + " , First repeated "+ repeated );


        String tobeReverse="hello world";
        String [] splited=tobeReverse.split(" ");
        char [] aabc=splited[0].toCharArray();

        String reversedString = IntStream.range(0, aabc.length)
                .mapToObj(i -> String.valueOf(aabc[aabc.length - 1 - i]))
                .collect(Collectors.joining());
        char [] aabc1=splited[1].toCharArray();

        String reversedString1 = IntStream.range(0, aabc1.length)
                .mapToObj(i -> String.valueOf(aabc1[aabc1.length - 1 - i]))
                .collect(Collectors.joining());
       System.out.println(reversedString+reversedString1);

       String sdsbja="programming";
       Set<Character> abcasa=new LinkedHashSet<>();

      Set<Character>sasgahshg=  sdsbja.chars().mapToObj(e-> (char)e).collect(Collectors.toCollection(LinkedHashSet::new));

        for(Character sasa:sasgahshg)
            System.out.print(sasa);
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
        Arrays.stream(arr12).sorted(Collections.reverseOrder()).forEach(System.out::print);

    }




    }







