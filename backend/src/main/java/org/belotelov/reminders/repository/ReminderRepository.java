package org.belotelov.reminders.repository;

import org.belotelov.reminders.entity.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {
}
