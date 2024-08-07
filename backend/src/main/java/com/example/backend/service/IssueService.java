

package com.example.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.model.Issue;
import com.example.backend.repository.IssueRepository;

@Service
public class IssueService {

    @Autowired
    private IssueRepository issueRepository;

    public Issue saveIssue(Issue issue) {
        return issueRepository.save(issue);
    }

    public Optional<Issue> getIssue(Long id) {
        return issueRepository.findById(id);
    }

    public void deleteIssue(Long id) {
        issueRepository.deleteById(id);
    }


    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    public Issue updateIssue(Long id, Issue issueDetails) {
        Issue issue = issueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Issue not found for this id :: " + id));

        issue.setTitle(issueDetails.getTitle());
        issue.setDescription(issueDetails.getDescription());
        issue.setResolved(issueDetails.isResolved());

        final Issue updatedIssue = issueRepository.save(issue);
        return updatedIssue;
    }
}
