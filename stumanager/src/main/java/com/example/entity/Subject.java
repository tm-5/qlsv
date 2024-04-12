package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "subject",schema="qlsv")
public class Subject {

    @Id
    @Column(name = "subjectID", nullable = false)
    private String subjectID;

    @Column(name = "subjectname", nullable = false)
    private String subjectName;

    @Column(name = "credit", nullable = false)
    private String credit;

	public Subject(String subjectID, String subjectName, String credit) {
		super();
		this.subjectID = subjectID;
		this.subjectName = subjectName;
		this.credit = credit;
	}


	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

}
