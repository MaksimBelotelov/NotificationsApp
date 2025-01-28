package org.belotelov.reminders.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@Entity
@Table(name = "userstab")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String telegram;
    private String name;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Reminder> remindersList;
}
