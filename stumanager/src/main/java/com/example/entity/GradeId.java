package com.example.entity;

import java.io.Serializable;

import jakarta.persistence.*;

@Embeddable
public class GradeId implements Serializable {
    @Column(name = "studentID")
    private String studentID;

    @Column(name = "subjectID")
    private String subjectID;

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}

	public GradeId(String studentID, String subjectID) {
		super();
		this.studentID = studentID;
		this.subjectID = subjectID;
	}

	public GradeId() {
		super();
		// TODO Auto-generated constructor stub
	}

}