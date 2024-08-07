import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Comment } from '../models/issue.model';

@Injectable({
  providedIn: 'root'
})
export class CommentService {
  private baseUrl = 'http://localhost:8080/comments';

  constructor(private http: HttpClient) { }

  getComments(): Observable<Comment[]> {
    return this.http.get<Comment[]>(this.baseUrl);
  }

  getComment(id: number): Observable<Comment> {
    return this.http.get<Comment>(`${this.baseUrl}/${id}`);
  }

  createComment(comment: Comment): Observable<Comment> {
    return this.http.post<Comment>(this.baseUrl, comment);
  }
  addComment(comment: Comment): Observable<Comment> {
    const requestPayload = {
      text: comment.text,
      issue: {
        id: comment.issueId
      }
    };
    return this.http.post<Comment>(`${this.baseUrl}`, requestPayload);
  }
  updateComment(id: number, comment: Comment): Observable<Comment> {
    return this.http.put<Comment>(`${this.baseUrl}/${id}`, comment);
  }
  // In comment.service.ts


  deleteComment(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
