package com.spring.websecurity.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

public class User {
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private long id;
    private String name;
    private Boolean subscribed=false;
    @OneToMany(mappedBy = "user")
    private List<Issue> issues;
	public User(long id, String name, Boolean subscribed, List<Issue> issues) {
		super();
		this.id = id;
		this.name = name;
		this.subscribed = subscribed;
		this.issues = issues;
	}
	public User() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getSubscribed() {
		return subscribed;
	}
	public void setSubscribed(Boolean subscribed) {
		this.subscribed = subscribed;
	}
	public List<Issue> getIssues() {
		return issues;
	}
	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", subscribed=" + subscribed + ", issues=" + issues + "]";
	}
    
    

}
