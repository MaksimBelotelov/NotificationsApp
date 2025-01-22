package org.belotelov.reminders.services;

import org.belotelov.reminders.entity.Reminder;
import org.belotelov.reminders.repository.ReminderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RemindersService {
    private final ReminderRepository repo;

    public RemindersService(ReminderRepository repo) {
        this.repo = repo;
    }


    // CRUD

    public List<Reminder> getRemindersList() {
        return repo.findAll();
    }

    public void addNewReminder(Reminder reminder) {
        repo.save(reminder);
    }

    public void deleteReminder(Long id) {
        repo.deleteById(id);
    }

    public void updateReminder(Reminder reminder, Long id) {
        if (repo.existsById(id)) {
            reminder.setId(id);
            repo.save(reminder);
        }
    }

    // поиск

}