package com.ak.microservice.hotelmicro.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user-service")
public class User {
@Id
    private String userId;
  @Column(name="USERNAME")
    private String username;
    @Column(name="EMAIL",nullable = false,unique = true)
    private String email;
    @Column(name="ABOUT")
    private String about;

    @Transient
    private List<Rating> ratings= new ArrayList<>();
}
