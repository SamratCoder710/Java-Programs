package com.coder.sanam;

import com.sanam.Student;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

interface Parser {
    String parse(String s);
}


class A{

    public  void something(){
        System.out.println("Something A");
    };

    public void kuch(){
        something();

    }

}
class B extends  A{
    public void something(){
        System.out.println("Something B");
    }
}

class ConsoleParser {
    public String print(String input) {
        if (input.length() <= 3) {
            return input.toUpperCase();
        }
        return input.toLowerCase();
    }
}

class StringParser {
    public void convert(String input, Parser parser) {
        String parse = parser.parse(input);
        System.out.println(parse);

    }

}


public class MethodReference {

    public static void main(String[] args) {

//        A objB = new A();
//        objB.something();
//        StringParser sp = new StringParser();
//        ConsoleParser cp = new ConsoleParser();
//        sp.convert("Adi", cp::print);
//        List<String> names = List.of("Sanam", "Aditi", "Shraddha");
//        List<Employee> workers = names.stream().map(Employee::new).toList();
//        Consumer<Employee> consumer =  emp -> System.out.println(emp.toString());
//        workers.forEach(consumer);

        //List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
        //list.stream().filter(n -> n % 2==0).forEach(System.out::println);

        //int[] nums = new int[]{10,15,8,49,25,98,32};
        //Map<Boolean, List<Integer>> collect = Arrays.stream(nums).boxed().collect(Collectors.partitioningBy(num -> num % 2 == 0));
        //System.out.println(collect.get(true));

        //List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
        //myList.stream().map(n -> n+"").filter(s -> s.startsWith("1")).forEach(System.out::println);

        //List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
        //Set<Integer> set = new HashSet<>();
        //myList.stream().filter(num -> !set.add(num)).forEach(System.out::println);
        //myList.stream().distinct().forEach(System.out::println);

        //myList.stream().max(Comparator.comparingInt(a -> a)).ifPresent(System.out::println);

        //myList.stream().min(Comparator.comparingInt(a -> a)).ifPresent(System.out::println);

        //myList.stream().findFirst().ifPresent(System.out::println);

        List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
//        Map<Integer, Long> collect = list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
//        System.out.println(collect);
//
//        String input = "JJava articles are Awesome";
//        LinkedHashMap<Character, Long> collect = input.chars().mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))).collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()));
//        collect.entrySet().stream().filter(e -> e.getValue()>1).map(Map.Entry::getKey).findFirst().ifPresent(System.out::println);

//        Integer i = list.stream().sorted(Collections.reverseOrder()).skip(2).findFirst().orElse(null);
//        System.out.println(i);
//        list.stream().sorted().forEach(System.out::println);

//        boolean b = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().anyMatch(e -> e.getValue() > 1);
//        System.out.println(b);

        //Current date and time using java 8

//        System.out.println(LocalDateTime.now());

//        List<String> list1 = Arrays.asList("Java", "8");
//        List<String> list2 = Arrays.asList("explained", "through", "programs");
//        Stream<String> concat = Stream.concat(list1.stream(), list2.stream());
//        concat.forEach(System.out::println);

//        List<Integer> integerList = Arrays.asList(4,5,6,7,1,2,3);
//        integerList.stream().map(e -> e * e * e).filter(ele -> ele>50).forEach(System.out::println);

//        int arr[] = { 99, 55, 203, 99, 4, 91 };
//        Arrays.parallelSort(arr);
//
//        Arrays.stream(arr).forEach(System.out::println);

//        List<String> lis = Arrays.asList("aa","bb","cc","dd");
//        String collect = lis.stream().map(String::toUpperCase).collect(Collectors.joining(":"));
//        System.out.println(collect);

//        List<Notes> noteLst = new ArrayList<>();
//        noteLst.add(new Notes(1, "note1", 11));
//        noteLst.add(new Notes(2, "note2", 22));
//        noteLst.add(new Notes(3, "note3", 33));
//        noteLst.add(new Notes(4, "note4", 44));
//        noteLst.add(new Notes(5, "note5", 55));
//
//        noteLst.add(new Notes(6, "note4", 66));
//
//        LinkedHashMap<String, Long> collect = noteLst.stream().sorted(Comparator.comparingLong(Notes::getTagId).reversed()).collect(
//                Collectors.toMap(Notes::getNote, Notes::getTagId, (oldValue, newValue) -> oldValue, LinkedHashMap::new)
//        );
//        System.out.println(collect);

        List<Integer> nums = Arrays.asList(2,3,4,5,6,7);
////        Map<String, Long> collect = names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//       System.out.println(collect);
//
//        Map<String, Long> collect = names.stream().filter(x -> Collections.frequency(names, x) > 1).collect(Collectors.groupingBy(e -> e, Collectors.counting()));
//        System.out.println(collect);
//        Optional<Integer> reduce = nums.stream().filter(e -> e % 2 == 0).reduce(Integer::sum);
//
//        System.out.println(reduce.get());
//
//        Map<Integer, Integer> collect = nums.stream().collect(Collectors.toMap(e -> e, e -> Collections.frequency(nums, e)));
//        System.out.println(collect);
//
//        List<Employee> employees = Arrays.asList(new Employee("Shubham",100),
//                new Employee("Aditi",20103),
//                new Employee("Shraddha",32000));
//
//
//        List<Employee> collect2 = employees.stream().sorted((e1, e2) -> e2.getSalary() - e1.getSalary()).collect(Collectors.toList());
//
//        Map<String, Employee> collect1 = employees.stream().collect(Collectors.toMap(e -> e.getName(), e -> e));
//        System.out.println(collect2);


//        List<Integer> words = Arrays.asList(1,2,3,4,5);
//        Integer collect = words.stream().collect(Collectors.toMap(1, (a, b) -> a * b));
//        System.out.println(collect);♦


    }
}
