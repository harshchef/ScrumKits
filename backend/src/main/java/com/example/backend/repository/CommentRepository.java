package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.backend.model.Comment;



public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByIssueId(Long issueId);
   

    // New JPQL query to fetch comments by issue ID and text pattern
    @Query("SELECT c FROM Comment c WHERE c.issue.id = :issueId AND c.text LIKE %:text%")
    List<Comment> findByIssueIdAndTextPattern(@Param("issueId") Long issueId, @Param("text") String textPattern);

      // New Native SQL query to fetch comments by issue ID and sort by text length
    @Query(value = "SELECT * FROM Comment c WHERE c.issue_id = :issueId ORDER BY LENGTH(c.text) DESC", nativeQuery = true)
    List<Comment> findByIssueIdOrderByTextLengthDesc(@Param("issueId") Long issueId);



      // New JPQL query to fetch comments by multiple issue IDs
      @Query("SELECT c FROM Comment c WHERE c.issue.id IN :issueIds")
      List<Comment> findByIssueIdIn(@Param("issueIds") List<Long> issueIds);


    // New JPQL query to fetch comments by issue ID and exclude specific words
    @Query("SELECT c FROM Comment c WHERE c.issue.id = :issueId AND c.text NOT LIKE %:excludedWord%")
    List<Comment> findByIssueIdExcludingWord(@Param("issueId") Long issueId, @Param("excludedWord") String excludedWord);
}
