package com.spring.websecurity.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.websecurity.Entity.Issue;
import com.spring.websecurity.Entity.User;
import com.spring.websecurity.Repository.IssueRepository;
import com.spring.websecurity.Repository.UserRepository;
import com.spring.websecurity.websecurity.Exception.UserNotSubscribedException;

import lombok.var;

@RestController
@RequestMapping("/api/v1")
public class LibrarayController {
	  @Autowired
	  
	    private UserRepository userRepository;
	    @Autowired
	    private IssueRepository issueRepository;

	    @PostMapping("/issue-book")
	    public ResponseEntity<Issue> issuebook(@RequestBody Issue issue){
	        Optional<User> user = userRepository.findById(issue.getUser().getId());
	        if(user.isEmpty()){
	            return ResponseEntity.noContent().build();
	        }
	        if(user.get().getSubscribed()==false){
	            throw new UserNotSubscribedException("fghj");
	        }
	        return ResponseEntity.ok().body(issueRepository.save(issue));
	    }
	    @PostMapping("/user")
	    public ResponseEntity<User> createUser(@RequestBody User user){
	        return ResponseEntity.ok().body(userRepository.save(user));
	    }

	    @GetMapping("renew-user-subscription/{id}")
	    public ResponseEntity<User> renewUserSubcription(@PathVariable Long id){
	         Optional<User> user = userRepository.findById(id);
	        if(user.isEmpty()){
	            return ResponseEntity.noContent().build();
	        }
	        user.get().setSubscribed(true);
	        return ResponseEntity.ok().body(userRepository.save(user.get()));
	    }

	    @PutMapping("/user")
	    public ResponseEntity<User> updateUser(@RequestBody User user){
	        User updated = null;
	        Optional<User> u = userRepository.findById(user.getId());
	        if(u.isPresent()){
	            updated = u.get();
	            updated.setId(user.getId());
	            updated.setSubscribed(user.getSubscribed());
	            updated.setName(user.getName());
	            return ResponseEntity.ok(userRepository.save(updated));
	        }
	        else{
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PutMapping("/issue-book")              
	    public ResponseEntity<Issue> updateIssue(@RequestBody Issue issue){
	        Issue issu = null;
//	       
	        Optional<Issue> op = issueRepository.findById(issue.getId());
	        if(op.isPresent()){
	            issu = op.get();
	            issu.setId(issue.getId());
	            issu.setFine(issue.getFine());
	            issu.setPeriod(issue.getPeriod());
	            issu.setIssueDate(issue.getIssueDate());
	            issu.setReturnDate(issue.getReturnDate());
	            return ResponseEntity.ok(issueRepository.save(issu));
	        }
	        else{
	            return ResponseEntity.noContent().build();
	        }
	    }

	    @DeleteMapping("/usr/{id}")
	    public ResponseEntity<String> deleteUser(@PathVariable long id){
	        Optional<User> usr = userRepository.findById(id);
	        if(usr.isEmpty()){
	            ResponseEntity.notFound().build();
	            
	        }
	        else{
	            userRepository.deleteById(id);
	        }
	        return ResponseEntity.ok("deleted");
	    }

	    @DeleteMapping("/issue/{id}")
	    public ResponseEntity<String> deleteIssue(@PathVariable long id){
	       Optional<Issue> op = issueRepository.findById(id);
	       if(op.isEmpty()){
	           ResponseEntity.noContent().build();
	       }
	       else{
	           issueRepository.deleteById(id);
	       }
	        return ResponseEntity.ok("deleted");
	    }

}
