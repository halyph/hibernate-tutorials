package org.javabrains.tutorials.dto;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * UserDetails: halyph
 * Date: 2/22/13
 * Time: 12:14 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;
    @Temporal(TemporalType.DATE)
    private Date jointDate;
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "street", column = @Column(name="HOME_STREET_NAME")),
        @AttributeOverride(name = "city", column = @Column(name="HOME_CITY_NAME")),
        @AttributeOverride(name = "state", column = @Column(name="HOME_STATE_NAME")),
        @AttributeOverride(name = "pincode", column = @Column(name="HOME_PIN_CODE_NAME"))
    })
    private Address homeAddress;
    @Embedded
    private Address officeAddress;
    @Lob
    private String description;

    @ElementCollection
    @JoinTable(name="USER_ADDRESS",
        joinColumns = @JoinColumn(name = "USER_ID")
    )
    private Set<Address> listOfAddresses = new HashSet<Address>();


    public Set<Address> getListOfAddresses() {
        return listOfAddresses;
    }

    public void setListOfAddresses(Set<Address> listOfAddresses) {
        this.listOfAddresses = listOfAddresses;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address address) {
        this.homeAddress = address;
    }

    public Date getJointDate() {
        return jointDate;
    }

    public void setJointDate(Date jointDate) {
        this.jointDate = jointDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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
