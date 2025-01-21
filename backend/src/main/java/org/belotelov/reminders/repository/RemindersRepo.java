package org.belotelov.reminders.repository;

import org.belotelov.reminders.config.DbQueries;
import org.belotelov.reminders.entity.Reminder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class RemindersRepo {

    private final JdbcTemplate jdbc;
    private final DbQueries dbQueries;

    public RemindersRepo(JdbcTemplate jdbc, DbQueries dbQueries) {
        this.jdbc = jdbc;
        this.dbQueries = dbQueries;
    }

    RowMapper<Reminder> reminderRowMapper = (r, i) -> {
        Reminder rowObject = new Reminder();
        rowObject.setId(r.getLong("id"));
        rowObject.setTitle(r.getString("title"));
        rowObject.setDescription(r.getString("description"));
        rowObject.setRemind(r.getObject("remind", LocalDateTime.class));

        return rowObject;
    };

    public List<Reminder> findAllReminders() {
        return jdbc.query(dbQueries.getFindAll(), reminderRowMapper);
    }

    public Reminder findReminderById(long id) {
        return jdbc.query(dbQueries.getFindById(), new Object[]{id}, reminderRowMapper).getFirst();
    }

    public void saveNewReminder(Reminder reminder) {
        jdbc.update(dbQueries.getSaveNewReminder(), reminder.getTitle(),
                reminder.getDescription(),
                Timestamp.valueOf(reminder.getRemind()));
    }

    public void deleteReminderById(long id) {
        jdbc.update(dbQueries.getDeleteById(), id);
    }

    public void updateReminder(Reminder reminder) {
        jdbc.update(dbQueries.getUpdateUser(), reminder.getTitle(),
                reminder.getDescription(),
                Timestamp.valueOf(reminder.getRemind()),
                reminder.getId());
    }
}