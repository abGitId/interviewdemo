package com.example.interviewdemo.entity;

import javax.persistence.*;

@Entity
public class Library {

  @Id @GeneratedValue private long libraryId;

  private String name;

  @JoinColumn(name = "address_id")
  @OneToOne
  private Address address;
}
