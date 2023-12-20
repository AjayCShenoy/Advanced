package com.spring.websecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.websecurity.Entity.Issue;

@Repository
public interface IssueRepository extends JpaRepository<Issue,Long> {
    
}
