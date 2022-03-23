package com.example.interviewdemo.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class TestStream {

  public static void main(String[] args) throws Exception {

    UserData userData = new UserData();
    List<User> userDataList = userData.getUserData();
    // for each iteration
    userDataList.forEach(System.out::println);

    // print all user names only
    List<String> userNames =
        userDataList.stream().map(user -> user.getName()).collect(Collectors.toList());
    System.out.println("userNames = " + userNames);

    // find user whose city is null
    List<User> nullCityUsers =
        userDataList.stream()
            .filter(user -> Objects.isNull(user.getCity()))
            .collect(Collectors.toList());
    System.out.println("nullCityUsers = " + nullCityUsers);

    // get list of all users mobile nos
    Collection<Long> usersMobileNos =
        userDataList.stream()
            .flatMap(user -> user.getMobileNos().stream())
            .collect(Collectors.toList());
    System.out.println("usersMobileNos = " + usersMobileNos);

    // get list of all users mobile nos
    long count = userDataList.stream().flatMap(user -> user.getMobileNos().stream()).count();

    // get list of all users mobile nos and do summation
    long sum =
        userDataList.stream()
            .flatMap(user -> user.getMobileNos().stream())
            .reduce(0L, (a, b) -> a + b);

    System.out.println("usersMobileNos sum= " + sum);

    // get max age of the users
    Optional<Integer> maxAge =
        userDataList.stream().map(user -> user.getAge()).max(Integer::compareTo);
    Optional<Integer> maxAge1 = userDataList.stream().map(User::getAge).max(Integer::compareTo);

    System.out.println("maxAge = " + maxAge);

    // get min age of the users
    Optional<Integer> minAge =
        userDataList.stream().map(user -> user.getAge()).min(Integer::compareTo);
    User minAge1 =
        userDataList.stream().min((user1, user2) -> user1.getAge().compareTo(user2.getAge())).get();
    User minAge2 = userDataList.stream().min(Comparator.comparing(User::getAge)).get();

    System.out.println("minAge = " + minAge);
    System.out.println("minAge1 = " + minAge1);
    System.out.println("minAge2 = " + minAge2);

    // Optional with stream

    Optional<User> anyNullCityUser =
        userDataList.stream().filter(user -> Objects.isNull(user.getCity())).findFirst();

    //    System.out.println(
    //        "anyNullCityUser = "
    //            + anyNullCityUser.orElseThrow(() -> new Exception("No user found with city
    // null")));

    // Optional with stream

    Predicate<User> isNullPredicate = (user) -> Objects.isNull(user.getName());

    Optional<User> anyNullNameUser =
        //-- userDataList.stream().filter(user -> Objects.isNull(user.getName())).findFirst();
        userDataList.stream().filter(isNullPredicate).findFirst();

    // System.out.println("anyNullCityUser = " + anyNullNameUser.orElseThrow(() -> new Exception("No
    // user found with name null")));

    // Sorting User list based on name and then age
    System.out.println("=======================================");
    System.out.println("Sorting User list based on name and then age");
    Comparator<User> nameComparator1 = (user1, user2) -> user1.getName().compareTo(user2.getName());

    Comparator<User> nameComparator = Comparator.comparing(User::getName);
    Comparator<User> ageComparator = Comparator.comparing(User::getAge);
    Comparator<User> nameAgeComparator = nameComparator.thenComparing(ageComparator);

    List<User> sortedUserList =
        userDataList.stream().sorted(nameAgeComparator).collect(Collectors.toList());
    sortedUserList.forEach(System.out::println);

    System.out.println("=======================================");

    Function<User, HashMap<Integer, String>> mapFun =  (user) -> {
      HashMap<Integer, String> userIdMap = new HashMap<>();
      userIdMap.put(user.getId(), user.getName());
      return userIdMap;
    };

    // get map from user name and id
    List<Map<Integer, String>> resultMapList =
        userDataList.stream()
            .map(
                user -> {
                      HashMap<Integer, String> userIdMap = new HashMap<>();
                      userIdMap.put(user.getId(), user.getName());
                      return userIdMap;
                    })
            .collect(Collectors.toList());

    // get map from user name and id
    List<Map<Integer, String>> resultMapList1 =
        userDataList.stream().map(mapFun).collect(Collectors.toList());


    System.out.println("get map from user name and id list");
    resultMapList.forEach(System.out::println);
    System.out.println("get map from user name and id list1");
    resultMapList1.forEach(System.out::println);

    System.out.println("=======================================");

    // grouping demo
    // -- https://mkyong.com/java8/java-8-collectors-groupingby-and-mapping-example
    // get map which contains city as key and count of no. of user from that city
    Map<String, Long> collect =
        userDataList.stream().collect(Collectors.groupingBy(User::getCity, Collectors.counting()));
    System.out.println(
        "get map which contains city as key and count of no. of user from that city \n using group by=");
    for (Map.Entry<String, Long> entry : collect.entrySet()) {

      System.out.println("entry " + entry.getKey() + "=" + entry.getValue());
    }

    Map<String, Object> collectMap =
        // -- userDataList.stream().collect(Collectors.toMap(User::getCity, user -> user));
            userDataList.stream()
            .collect(Collectors.toMap(User::getCity, user -> user, (user1, user2) -> user2));

    System.out.println(
        "get map which contains city as key and users from that city \n using toMap=");
    for (Map.Entry<String, Object> entry : collectMap.entrySet()) {

      System.out.println("entry " + entry.getKey() + "=" + entry.getValue());
    }

    System.out.println("=======================================");
    // create users group by city
    Map<String, List<User>> groupByCityMap =
            userDataList.stream().collect(Collectors.groupingBy(User::getCity));
    System.out.println("groupByCityMap = " + groupByCityMap);

    int[] intArr = {1,2,3,4};

    Arrays.stream(intArr).boxed().forEach(System.out::println);
  }
}

@Data
@AllArgsConstructor
class User {

  private int id;
  private String name;
  private Integer age;
  private String city;
  private List<Long> mobileNos;
  private List<String> travelledCities;
}

@Data
class UserData {

  public List<User> getUserData() {
    return Arrays.asList(
        new User(
            1,
            "user1",
            30,
            "pune",
            Arrays.asList(123l, 456l, 789l),
            Arrays.asList("satara", "karad", "pune")),
        new User(
            2,
            "user2",
            25,
            "satara",
            Arrays.asList(123l, 456l, 789l),
            Arrays.asList("kolhapur", "karad", "satara")),
        new User(
            3,
            "user3",
            25,
            "satara",
            Arrays.asList(123l, 456l, 789l),
            Arrays.asList("navi mumbai", "sangli", "pune")),
        new User(
            5,
            "user3",
            20,
            "kolhapur",
            Arrays.asList(123l, 456l, 789l),
            Arrays.asList("navi mumbai", "sangli", "pune")),
        new User(
            4,
            "user4",
            40,
            "pune",
            Arrays.asList(123l, 456l, 789l),
            Arrays.asList("navi mumbai", "sangli", "pune")),
        new User(
            4,
            "user4",
            35,
            "satara",
            Arrays.asList(123l, 456l, 789l),
            Arrays.asList("navi mumbai", "sangli", "pune")),
        new User(
            6,
            "user4",
            40,
            "karad",
            Arrays.asList(123l, 456l, 789l),
            Arrays.asList("sangli", "karad", "pune")));
  }
}
