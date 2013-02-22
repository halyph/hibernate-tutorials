package org.javabrains.tutorials.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * UserDetails: halyph
 * Date: 2/22/13
 * Time: 12:14 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity(name = "USER_DETAILS")
public class UserDetails {
    @Id
    private int userId;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
