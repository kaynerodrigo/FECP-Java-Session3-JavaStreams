// Kayne Uriel Rodrigo
// FECP 5 - Quiz 1
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JavaStreams {
    /**
     * Instructions:
     * Create a single Java file named JavaStreams.java.
     * Inside the file, implement four activities listed below.
     * Use Streams to complete each task.
     * Use meaningful method names or inline comments.
     * Run your code and make sure the output matches the expected result.
     * Do not use loops — only Streams and Predicates.
     * */

    public static void main(String[] args) {

        // Activity 1: Filter Odd Numbers
        List<Integer> listArr = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Predicate<Integer> isOdd = n -> (n % 2) != 0;

        List<Integer> resultStream = listArr.stream()
                .filter(isOdd)
                .collect(Collectors.toList());

        System.out.println("Odd numbers: " + resultStream);

        // Activity 2: Filter Strings Starting with 'A'
        List<String> namesList = Arrays.asList("Alice", "Adam", "Bob", "Angela", "Brian");

        Predicate<String> startsWithA = s -> s.startsWith("A");

        List<String> nameStreamStartsWithA = namesList.stream()
                .filter(startsWithA)
                .collect(Collectors.toList());

        System.out.println("Names starting with A: " + nameStreamStartsWithA);

        // Activity 3: Square All Numbers (Refactored to use Streams)
        List<Integer> integerList = Arrays.asList(1,2,3,4,5);
        List<Integer> squaredNumbers = integerList.stream()
                .map(n -> n * n) // Square each number
                .collect(Collectors.toList());
        System.out.println("Squared numbers: " + squaredNumbers);


        // Activity 4: Combine Predicates
        List<Integer> integerListEvenGreater5 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Predicate<Integer> isEven = s -> s % 2 == 0;
        Predicate<Integer> greaterThanFive = s -> s > 5;
        Predicate<Integer> combinedPredicate = isEven.and(greaterThanFive);

        List<Integer> filteredIntegerListEvenGreater5 = integerListEvenGreater5.stream()
                .filter(combinedPredicate)
                .collect(Collectors.toList());

        System.out.println("Even and >5: " + filteredIntegerListEvenGreater5);

        // Activity 5: Sort Objects Using Comparator
        List<Person> personObjectsList = Arrays.asList(
                new Person("Jam", 10),
                new Person("Jake", 12),
                new Person("Alice", 13),
                new Person("Bob", 14),
                new Person("Sam", 15)
        );

        System.out.println("\nSorted by Age (Ascending): ");
        List<Person> sortedPeopleByAge = personObjectsList.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());
        sortedPeopleByAge.forEach(System.out::println);

        System.out.println("\nSorted by Name: ");
        List<Person> sortedPeopleByName = personObjectsList.stream()
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());
        sortedPeopleByName.forEach(System.out::println);

        System.out.println("\nSorted by Age (Descending): ");
        List<Person> sortedPeopleByAgeReversed = personObjectsList.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .collect(Collectors.toList());
        sortedPeopleByAgeReversed.forEach(System.out::println);
    }
}