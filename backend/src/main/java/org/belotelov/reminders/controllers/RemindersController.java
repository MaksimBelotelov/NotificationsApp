package org.belotelov.reminders.controllers;

import org.belotelov.reminders.entity.Reminder;
import org.belotelov.reminders.services.RemindersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/reminders")
public class RemindersController {
    private RemindersService service;

    public RemindersController(RemindersService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Reminder> getAllReminders() {
        return service.getRemindersList();
    }

    @PostMapping("/create")
    public void createNewReminder(@RequestBody Reminder reminder) {
        service.addNewReminder(reminder);
    }

    @GetMapping("/delete/{id}")
    public void deleteReminderById(@PathVariable("id") long id) {
        service.deleteReminder(id);
    }


    @PostMapping("/update/{id}")
    public void updateReminderById(@PathVariable("id") long id,
                                   @RequestBody Reminder newReminder) {
        service.updateReminder(newReminder, id);
    }
}
