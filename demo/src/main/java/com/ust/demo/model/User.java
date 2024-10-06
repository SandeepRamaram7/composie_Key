package com.ust.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Users")
public class User {

    @EmbeddedId
    private UserPK id;

    private String firstName;
    private String lastName;
    private String email;
    private boolean isActive;

}
