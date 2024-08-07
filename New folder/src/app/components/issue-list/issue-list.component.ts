
import { Component, OnInit } from '@angular/core';
import { IssueService } from '../../services/issue.service';
import { Issue } from '../../models/issue.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-issue-list',
  templateUrl: './issue-list.component.html',
  styleUrls: ['./issue-list.component.css']
})
export class IssueListComponent implements OnInit {
  addIssue(): void {
    this.router.navigate(['/add-issue']);
  }
  issues: Issue[] = [];

  constructor(private issueService: IssueService, private router: Router) { }

  ngOnInit(): void {
    this.issueService.getIssues().subscribe(data => {
      this.issues = data;
    });
  }
  editIssue(issueId: number): void {
    this.router.navigate(['/add-issue', issueId]);
  }

  viewComments(issueId: number): void {
    this.router.navigate(['/comments', issueId]);
  }
  deleteIssue(issueId: number): void {
    this.issueService.deleteIssue(issueId).subscribe(() => {
      this.issues = this.issues.filter(issue => issue.id !== issueId);
    });
  }
}
