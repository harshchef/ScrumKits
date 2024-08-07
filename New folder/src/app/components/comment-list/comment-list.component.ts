
// import { Component, OnInit } from '@angular/core';
// import { ActivatedRoute, Router } from '@angular/router';
// import { IssueService } from '../../services/issue.service';
// import { Comment } from '../../models/comment.model';
// import { CommentService } from '../../services/comment.service';

// @Component({
//   selector: 'app-comment-list',
//   templateUrl: './comment-list.component.html',
//   styleUrls: ['./comment-list.component.css']
// })
// export class CommentListComponent implements OnInit {
//   comments: Comment[] = [];
//   issueId: number | null = null;

//   constructor(private issueService: IssueService, private route: ActivatedRoute, private router: Router,private commentService: CommentService) {
//     this.route.paramMap.subscribe(params => {
//       this.issueId = +params.get('issueId')!;
//     });
//   }

//   ngOnInit(): void {
//     if (this.issueId !== null) {
//       this.issueService.getCommentsByIssueId(this.issueId).subscribe(data => {
//         this.comments = data;
//       });
//     }
//   }
//   editComment(commentId: number): void {
//     this.router.navigate(['/add-comment', this.issueId, commentId], );
//   }
//   addComment(): void {
//     this.router.navigate(['/add-comment', this.issueId]);
//   }
//   deleteComment(commentId: number): void {
//     if (confirm('Are you sure you want to delete this comment?')) {
//       this.commentService.deleteComment(commentId).subscribe(() => {
//         this.comments = this.comments.filter(comment => comment.id !== commentId);
//       });
//     }
//   }
// // }


// import { Component, OnInit } from '@angular/core';
// import { ActivatedRoute, Router } from '@angular/router';
// import { IssueService } from '../../services/issue.service';
// import { Comment } from '../../models/comment.model';
// import { CommentService } from '../../services/comment.service';

// @Component({
//   selector: 'app-comment-list',
//   templateUrl: './comment-list.component.html',
//   styleUrls: ['./comment-list.component.css']
// })
// export class CommentListComponent implements OnInit {
//   comments: Comment[] = [];
//   issueId: number | null = null;

//   constructor(private issueService: IssueService, private route: ActivatedRoute, private router: Router, private commentService: CommentService) {
//     this.route.paramMap.subscribe(params => {
//       this.issueId = +params.get('issueId')!;
//     });
//   }

//   ngOnInit(): void {
//     if (this.issueId !== null) {
//       this.issueService.getCommentsByIssueId(this.issueId).subscribe(data => {
//         this.comments = data;
//       });
//     }
//   }



//   addComment(): void {
//     this.router.navigate(['/add-comment', this.issueId]);
//   }

//   deleteComment(commentId: number): void {
//     if (confirm('Are you sure you want to delete this comment?')) {
//       this.commentService.deleteComment(commentId).subscribe(() => {
//         this.comments = this.comments.filter(comment => comment.id !== commentId);
//       });
//     }
//   }
// }
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { IssueService } from '../../services/issue.service';
import { Comment } from '../../models/comment.model';
import { CommentService } from '../../services/comment.service';

@Component({
  selector: 'app-comment-list',
  templateUrl: './comment-list.component.html',
  styleUrls: ['./comment-list.component.css']
})
export class CommentListComponent implements OnInit {
  comments: Comment[] = [];
  issueId: number | null = null;

  constructor(
    private issueService: IssueService,
    private route: ActivatedRoute,
    private router: Router,
    private commentService: CommentService
  ) {
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

  editComment(commentId: number): void {
    this.router.navigate(['/add-comment', this.issueId, commentId]);
  }

  deleteComment(commentId: number): void {
    if (confirm('Are you sure you want to delete this comment?')) {
      this.commentService.deleteComment(commentId).subscribe(() => {
        this.comments = this.comments.filter(comment => comment.id !== commentId);
      });
    }
  }
}
