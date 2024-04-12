package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
	@Id
    @Column(name = "studentID")
    private String studentID;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "gender")
    private String gender;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "userID")
    private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Student(String studentID, String firstname, String lastname, String gender, String email) {
		super();
		this.studentID = studentID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.email = email;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

    
    // Getters and setters
}