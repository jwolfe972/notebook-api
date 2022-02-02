package com.jordanbook.notebook.models;



import javax.persistence.*;
import java.util.Date;


@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long userID;



    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String salt;



    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String emailAddress;


    @Column(nullable = false)
    private Date accountCreationDate;



    @Column(nullable = false)
    private boolean accountActivated;



    @Column(nullable = false)
    private boolean accountLocked;


    public User(){}



    public User(String username, String firstName, String lastName, String salt, String password, String emailAddress){


        this.userName = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salt = salt;
        this.password = password;
        this.emailAddress = emailAddress;

        this.accountCreationDate = new Date();
        this.accountActivated = false;
        this.accountLocked = false;


    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Date getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(Date accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public boolean isAccountActivated() {
        return accountActivated;
    }

    public void setAccountActivated(boolean accountActivated) {
        this.accountActivated = accountActivated;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }


    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salt='" + salt + '\'' +
                ", password='" + password + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", accountCreationDate=" + accountCreationDate +
                ", accountActivated=" + accountActivated +
                ", accountLocked=" + accountLocked +
                '}';
    }
}
