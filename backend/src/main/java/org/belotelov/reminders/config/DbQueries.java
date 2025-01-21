package org.belotelov.reminders.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "db")
public class DbQueries {
    private String findAll;
    private String findById;
    private String saveNewReminder;
    private String deleteById;
    private String updateUser;

    public String getFindAll() {
        return findAll;
    }

    public String getFindById() {
        return findById;
    }

    public void setFindById(String findById) {
        this.findById = findById;
    }

    public void setFindAll(String findAll) {
        this.findAll = findAll;
    }

    public String getSaveNewReminder() {
        return saveNewReminder;
    }

    public void setSaveNewReminder(String saveNewReminder) {
        this.saveNewReminder = saveNewReminder;
    }

    public String getDeleteById() {
        return deleteById;
    }

    public void setDeleteById(String deleteById) {
        this.deleteById = deleteById;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}
