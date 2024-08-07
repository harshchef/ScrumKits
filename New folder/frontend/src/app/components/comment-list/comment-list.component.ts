
// import { Component, OnInit } from '@angular/core';
// import { ActivatedRoute } from '@angular/router';
// import { IssueService } from '../../services/issue.service';
// import { Comment } from '../../models/comment.model';

// @Component({
//   selector: 'app-comment-list',
//   templateUrl: './comment-list.component.html',
//   styleUrls: ['./comment-list.component.css'] // corrected typo
// })
// export class CommentListComponent implements OnInit {
//   comments: Comment[] = [];

//   constructor(private issueService: IssueService, private route: ActivatedRoute) { }

//   ngOnInit(): void {
//     // Get issueId from the route parameters and convert it to a number
//     const issueId = Number(this.route.snapshot.paramMap.get('issueId'));
//     if (issueId) {
//       this.issueService.getCommentsByIssueId(issueId).subscribe(data => {
//         this.comments = data;
//       });
//     } else {
//       console.error('Issue ID not found in route parameters');
//     }
//   }
// }
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { IssueService } from '../../services/issue.service';
import { Comment } from '../../models/comment.model';

@Component({
  selector: 'app-comment-list',
  templateUrl: './comment-list.component.html',
  styleUrls: ['./comment-list.component.css']
})
export class CommentListComponent implements OnInit {
  comments: Comment[] = [];
  issueId: number | null = null;

  constructor(private issueService: IssueService, private route: ActivatedRoute, private router: Router) {
    this.route.paramMap.subscribe(params => {
      this.issueId = +params.get('issueId')!;
    });
  }

  ngOnInit(): void {
    if (this.issueId !== null) {
      this.issueService.getCommentsByIssueId(this.issueId).subscribe(data => {
        this.comments = data;
      });
    }
  }

  addComment(): void {
    this.router.navigate(['/add-comment', this.issueId]);
  }
}
