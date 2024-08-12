

package com.example.backend.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.model.Comment;
import com.example.backend.model.Issue;
import com.example.backend.service.CommentService;
import com.example.backend.service.IssueService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/issues")
public class IssueController {
     @Autowired
    private CommentService commentService;
    @Autowired
    private IssueService issueService;

    @PostMapping
    public Issue createIssue(@RequestBody Issue issue) {
        return issueService.saveIssue(issue);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Issue> getIssueById(@PathVariable Long id) {
        Issue issue = issueService.getIssue(id).orElseThrow(() -> new ResourceNotFoundException("Issue not found for this id :: " + id));
        return ResponseEntity.ok().body(issue);
    }
        @GetMapping("/resolved")
    public List<Issue> getResolvedIssues() {
        return issueService.getAllIssues().stream()
                           .filter(Issue::isResolved)
                           .collect(Collectors.toList());
    }

    @GetMapping("/unresolved")
    public List<Issue> getUnresolvedIssues() {
        return issueService.getAllIssues().stream()
                           .filter(issue -> !issue.isResolved())
                           .collect(Collectors.toList());
    }
    
    @GetMapping
    public List<Issue> getAllIssues() {
        return issueService.getAllIssues();
    }


    @GetMapping("/{issueId}/comments")
    public ResponseEntity<List<Comment>> getCommentsByIssueId(@PathVariable Long issueId) {
        List<Comment> comments = commentService.getCommentsByIssueId(issueId);
        return ResponseEntity.ok(comments);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Issue> updateIssue(@PathVariable Long id, @RequestBody Issue issueDetails) {
        Issue updatedIssue = issueService.updateIssue(id, issueDetails);
        return ResponseEntity.ok(updatedIssue);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIssue(@PathVariable Long id) {
        issueService.deleteIssue(id);
        return ResponseEntity.noContent().build();
    }
}
