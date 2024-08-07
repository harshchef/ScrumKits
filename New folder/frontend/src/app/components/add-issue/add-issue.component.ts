import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { IssueService } from '../../services/issue.service';
import { Issue } from '../../models/issue.model';

@Component({
  selector: 'app-add-issue',
  templateUrl: './add-issue.component.html',
  styleUrls: ['./add-issue.component.css']
})
export class AddIssueComponent {
  issue: Issue = {
    id: 0,  // id will be auto-generated by the backend
    title: '',
    description: '',
    resolved: false,
    comments: []  // Initialize comments as an empty array
  };

  constructor(private issueService: IssueService, private router: Router) { }

  saveIssue(): void {
    this.issueService.createIssue(this.issue).subscribe(() => {
      // Navigate back to the issue list after saving the new issue
      this.router.navigate(['/']);
    });
  }
}
