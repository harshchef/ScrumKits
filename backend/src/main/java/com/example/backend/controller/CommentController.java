


package com.example.backend.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.model.Comment;
import com.example.backend.service.CommentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.saveComment(comment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        Comment comment = commentService.getComment(id).orElseThrow(() -> new ResourceNotFoundException("Comment not found for this id :: " + id));
        return ResponseEntity.ok().body(comment);
    }
  

        
    @GetMapping("/by-issue-ids")
    public List<Comment> getCommentsByIssueIdsComplex(@RequestParam List<Long> issueIds) {
        return commentService.getCommentsByIssueIds(issueIds);
    }

    @GetMapping
    public List<Comment> getAllComments() {
        return (List<Comment>) commentService.getAllComments();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody Comment commentDetails) {
        Comment updatedComment = commentService.updateComment(id, commentDetails);
        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }




    @GetMapping("/by-issue-id-text-pattern")
    public List<Comment> getCommentsByIssueIdAndTextPattern(@RequestParam Long issueId, @RequestParam String textPattern) {
        return commentService.getCommentsByIssueIdAndTextPattern(issueId, textPattern);
    }

    // API to get comments by issue ID and sort by text length
    @GetMapping("/by-issue-id-order-by-length")
    public List<Comment> getCommentsByIssueIdOrderByTextLength(@RequestParam Long issueId) {
        return commentService.getCommentsByIssueIdOrderByTextLength(issueId);
    }

    // API to get comments by multiple issue IDs
    @GetMapping("/by-issue-ids")
    public List<Comment> getCommentsByIssueIds(@RequestParam List<Long> issueIds) {
        return commentService.getCommentsByIssueIds(issueIds);
    }

    // API to get comments by issue ID and exclude specific words
    @GetMapping("/by-issue-id-excluding-word")
    public List<Comment> getCommentsByIssueIdExcludingWord(@RequestParam Long issueId, @RequestParam String excludedWord) {
        return commentService.getCommentsByIssueIdExcludingWord(issueId, excludedWord);
    }
}
