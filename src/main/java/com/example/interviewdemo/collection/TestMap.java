package com.example.interviewdemo.collection;

import lombok.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TestMap {

  public static void main(String[] args) {
    //
      Map<User, Integer> userMap = getUsersMap();
    System.out.println("userMap = " + userMap);
    System.out.println("userMap.size() = " + userMap.size());
  }

  public static Map<User, Integer> getUsersMap(){
      User u1 = User.builder().age(20).name("abc").build();
      User u2 = User.builder().age(20).name("abc1").build();
      User u3 = User.builder().age(20).name("abc").build();

      Map<User, Integer> userMap =new HashMap<>();
      userMap.put(u1,1);
      userMap.put(u2,2);
      userMap.put(u3,3);
      return  userMap;
  }
}


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
class User {
  private String name;
  private int age;

  /*@Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return age == user.age && Objects.equals(name, user.name);
  }*/
 
  @Override
  public int hashCode() {
    return Objects.hash(name, age);
  }
  /*@Override
  public int hashCode() {
    return 1;
  }*/
}
