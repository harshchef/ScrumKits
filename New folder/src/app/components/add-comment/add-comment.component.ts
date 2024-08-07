

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CommentService } from '../../services/comment.service';
import { Comment } from '../../models/comment.model';

@Component({
  selector: 'app-add-comment',
  templateUrl: './add-comment.component.html',
  styleUrls: ['./add-comment.component.css']
})
export class AddCommentComponent implements OnInit {
  issueId: number | null = null;
  comment: Comment = {
    id: 0,
    text: '',
    issueId: 0
  };
  isEditMode = false;

  constructor(
    private commentService: CommentService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.issueId = +params.get('issueId')!;
      if (this.issueId !== null && !isNaN(this.issueId)) {
        this.comment.issueId = this.issueId; // Ensure issueId is set
      } else {
        console.error('Invalid issueId:', this.issueId);
      }

      const commentId = params.get('commentId');
      if (commentId) {
        this.isEditMode = true;
        this.commentService.getComment(+commentId).subscribe(comment => {
          this.comment = comment;
          // Ensure issueId is set correctly
          this.comment.issueId = this.issueId!;
        });
      }
    });
  }

  saveComment(): void {
    if (this.issueId === null || isNaN(this.issueId)) {
      console.error('Invalid issueId:', this.issueId);
      return; // Prevent saving if issueId is invalid
    }

    if (this.isEditMode) {
      this.commentService.updateComment(this.comment.id, this.comment).subscribe(() => {
        this.router.navigate(['/comments', this.issueId]);
      });
    } else {
      this.commentService.addComment(this.comment).subscribe(() => {
        this.router.navigate(['/comments', this.issueId]);
      });
    }
  }
}
