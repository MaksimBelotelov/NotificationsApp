package org.belotelov.reminders.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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
    

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reminder> remindersList;
}
