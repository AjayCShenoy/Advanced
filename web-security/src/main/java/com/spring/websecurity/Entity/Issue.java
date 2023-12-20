package com.spring.websecurity.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity



public class Issue {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDate issueDate;

    private LocalDate returnDate;

    private Integer period;

    private Integer fine;
    @ManyToOne
    @JoinColumn(name = "user id")
    private User user;
    
    public Issue() {
		super();
	}
    
	public Issue(Long id, LocalDate issueDate, LocalDate returnDate, Integer period, Integer fine, User user) {
		super();
		this.id = id;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.period = period;
		this.fine = fine;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public Integer getFine() {
		return fine;
	}

	public void setFine(Integer fine) {
		this.fine = fine;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Issue [id=" + id + ", issueDate=" + issueDate + ", returnDate=" + returnDate + ", period=" + period
				+ ", fine=" + fine + ", user=" + user + "]";
	}
    
	
}
