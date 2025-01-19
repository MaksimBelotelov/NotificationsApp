package org.belotelov.reminders.controllers;

import org.belotelov.reminders.entity.Reminder;
import org.belotelov.reminders.services.RemindersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public Reminder getReminderById(@PathVariable("id") long id) {
        return service.getReminderById(id);
    }

    @PostMapping("/create")
    public void createNewReminder(@RequestBody Reminder newReminder) {
        service.pushNewReminder(newReminder);
    }

    @GetMapping("/delete/{id}")
    public void deleteReminderById(@PathVariable("id") long id) {
        service.deleteById(id);
    }

    @PostMapping("/update/{id}")
    public void updateReminderById(@PathVariable("id") long id,
                                   @RequestBody Reminder newReminder) {
        newReminder.setId(id);
        service.updateReminderById(newReminder);
    }
}
