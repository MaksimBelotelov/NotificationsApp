package org.belotelov.reminders.services;

import org.belotelov.reminders.entity.Reminder;
import org.belotelov.reminders.repository.RemindersRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RemindersService {
    private RemindersRepo repo;

    public RemindersService(RemindersRepo repo) {
        this.repo = repo;
    }

    public List<Reminder> getRemindersList() {
        return repo.findAllReminders();
    }

    public Reminder getReminderById(long id) {
        return repo.findReminderById(id);
    }

    public void pushNewReminder(Reminder reminder) {
        // можно сделать валидацию перед сохранением

        repo.saveNewReminder(reminder);
    }

    public void deleteById(long id) {
        repo.deleteReminderById(id);
    }

    public void updateReminderById(Reminder reminder) {
        repo.updateReminder(reminder);
    }
}