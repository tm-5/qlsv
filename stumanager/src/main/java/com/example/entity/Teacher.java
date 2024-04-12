package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher {
	@Id
    @Column(name = "teacherID")
    private String teacherID;

    @Column(name = "teachername")
    private String teachername;

    @Column(name = "faculty")
    private String faculty;

    @Column(name = "department")
    private String department;

    @OneToOne
    @JoinColumn(name = "userID")
    private User user;


	public Teacher(String teacherID, String teachername, String faculty, String department, User user) {
		super();
		this.teacherID = teacherID;
		this.teachername = teachername;
		this.faculty = faculty;
		this.department = department;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

    
    // Getters and setters
}
