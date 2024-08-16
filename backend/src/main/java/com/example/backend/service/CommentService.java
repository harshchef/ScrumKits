

package com.example.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.model.Comment;
import com.example.backend.repository.CommentRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
  
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Optional<Comment> getComment(Long id) {
        return commentRepository.findById(id);
    }
  


    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    public Iterable<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment updateComment(Long id, Comment commentDetails) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found for this id :: " + id));

        comment.setText(commentDetails.getText());
        comment.setIssue(commentDetails.getIssue()); 
    
        final Comment updatedComment = commentRepository.save(comment);
        return updatedComment;
    }


    public List<Comment> getCommentsByIssueIds(List<Long> issueIds) {
        return commentRepository.findByIssueIdIn(issueIds);
    }
    public List<Comment> getCommentsByIssueId(Long issueId) {
        return commentRepository.findByIssueId(issueId);
    }




    public List<Comment> getCommentsByIssueIdAndTextPattern(Long issueId, String textPattern) {
        return commentRepository.findByIssueIdAndTextPattern(issueId, textPattern);
    }

    public List<Comment> getCommentsByIssueIdOrderByTextLength(Long issueId) {
        return commentRepository.findByIssueIdOrderByTextLengthDesc(issueId);
    }



    public List<Comment> getCommentsByIssueIdExcludingWord(Long issueId, String excludedWord) {
        return commentRepository.findByIssueIdExcludingWord(issueId, excludedWord);
    }


}
