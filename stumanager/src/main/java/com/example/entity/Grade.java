package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "grade")
public class Grade {
	@EmbeddedId
    private GradeId id;
    
    @Column(name = "Group")
    private String group;
    
    @Column(name="assignmentScore")
    private String assignmentScore;
    
    @Column(name="examScore")
    private String examScore;
    
    @Column(name="practicalScore")
    private String practicalScore;
    
    @Column(name="attendanceScore")
    private String attendanceScore;
    
    @Column(name="finalExamScore")
    private String finalExamScore;
    
    @Column(name="componentScore")
    private String componentScore;
    
    @Column(name="letterGrade")
    private String letterGrade;

    
    public GradeId getId() {
		return id;
	}

	public void setId(GradeId id) {
		this.id = id;
	}

	public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAssignmentScore() {
        return assignmentScore;
    }

    public void setAssignmentScore(String assignmentScore) {
        this.assignmentScore = assignmentScore;
    }

    public String getExamScore() {
        return examScore;
    }

    public void setExamScore(String examScore) {
        this.examScore = examScore;
    }

    public String getPracticalScore() {
        return practicalScore;
    }

    public void setPracticalScore(String practicalScore) {
        this.practicalScore = practicalScore;
    }

    public String getAttendanceScore() {
        return attendanceScore;
    }

    public void setAttendanceScore(String attendanceScore) {
        this.attendanceScore = attendanceScore;
    }

    public String getFinalExamScore() {
        return finalExamScore;
    }

    public void setFinalExamScore(String finalExamScore) {
        this.finalExamScore = finalExamScore;
    }

    public String getComponentScore() {
        return componentScore;
    }

    public void setComponentScore(String componentScore) {
        this.componentScore = componentScore;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }
}

