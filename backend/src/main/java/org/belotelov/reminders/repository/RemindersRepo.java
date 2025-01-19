package org.belotelov.reminders.repository;

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

    public RemindersRepo(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
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
        String sql = "SELECT * FROM reminderstable;";

        return jdbc.query(sql, reminderRowMapper);
    }

    public Reminder findReminderById(long id) {
        String sql = "SELECT * FROM reminderstable WHERE id=(?);";

        return jdbc.query(sql, new Object[]{id}, reminderRowMapper).getFirst();
    }

    public void saveNewReminder(Reminder reminder) {
        String sql = "INSERT INTO reminderstable (title, description, remind) VALUES(?, ?, ?);";
        jdbc.update(sql, reminder.getTitle(),
                reminder.getDescription(),
                Timestamp.valueOf(reminder.getRemind()));
    }

    public void deleteReminderById(long id) {
        String sql = "DELETE FROM reminderstable WHERE id=?;";

        jdbc.update(sql, id);
    }

    public void updateReminder(Reminder reminder) {
        String sql = "UPDATE reminderstable SET title=?, description=?, remind=? WHERE id=?;";

        jdbc.update(sql, reminder.getTitle(),
                reminder.getDescription(),
                Timestamp.valueOf(reminder.getRemind()),
                reminder.getId());
    }
}