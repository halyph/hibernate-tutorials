package org.javabrains.tutorials.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: halyph
 * Date: 2/26/13
 * Time: 4:41 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Role {

    @Id @GeneratedValue
    private int roleId;
    private String roleName;

    @ManyToMany(mappedBy = "role")
    private Collection<User> users = new ArrayList<User>();

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
