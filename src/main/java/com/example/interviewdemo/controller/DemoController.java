package com.example.interviewdemo.controller;

import com.example.interviewdemo.aop.TrackTime;
import com.example.interviewdemo.entity.City;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DemoController {

  @GetMapping("/")
  public ResponseEntity<?> welcomeGreet() {

    return ResponseEntity.ok("Interview Demo application running...");
  }

  @GetMapping("/test")
  public ResponseEntity<String> welcomeGreet(@RequestParam("name") String name)
      throws InterruptedException {

    return ResponseEntity.ok(getMsgBody(name));
  }

  //-- @TrackTime
  @GetMapping("/test1")
  public ResponseEntity<?> welcomeGreet1(@RequestParam("name") String name)
      throws InterruptedException {
    List<City> cityList = City.getCityList().stream().filter(city -> city.getState().equals(name)).collect(Collectors.toList());
    return ResponseEntity.ok(cityList);
  }


  public String getMsgBody(@RequestParam("name") String name) throws InterruptedException {
    Thread.sleep(5000);
    return "Interview Demo application running..." + name;
  }

  /*@PostMapping("/")
  public ResponseEntity<?> postCall() {
    return ResponseEntity.ok("Interview Demo application running...");
  }*/
}
