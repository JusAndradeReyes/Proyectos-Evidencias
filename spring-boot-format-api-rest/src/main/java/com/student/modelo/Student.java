package com.student.modelo;

import java.util.List;
import java.util.Set;

public class Student {
	
	private Integer id;
	private Set<String> subjectSet;
	private List<Integer> marks;
	private String[] grade;
	
	//CONSTRUCTORS METHODS
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Integer id, Set<String> subjectSet, List<Integer> marks, String[] grade) {
		super();
		this.id = id;
		this.subjectSet = subjectSet;
		this.marks = marks;
		this.grade = grade;
	}
	
	//GETTERS AND SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<String> getSubjectSet() {
		return subjectSet;
	}

	public void setSubjectSet(Set<String> subjectSet) {
		this.subjectSet = subjectSet;
	}

	public List<Integer> getMarks() {
		return marks;
	}

	public void setMarks(List<Integer> marks) {
		this.marks = marks;
	}

	public String[] getGrade() {
		return grade;
	}

	public void setGrade(String[] grade) {
		this.grade = grade;
	}
}
