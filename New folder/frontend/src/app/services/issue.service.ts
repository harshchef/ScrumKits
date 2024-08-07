// import { Injectable } from '@angular/core';
// import { HttpClient } from '@angular/common/http';
// import { Observable } from 'rxjs';
// import { Issue } from '../models/issue.model';

// @Injectable({
//   providedIn: 'root'
// })
// export class IssueService {
//   private baseUrl = 'http://localhost:8080/issues';

//   constructor(private http: HttpClient) { }

//   getIssues(): Observable<Issue[]> {
//     return this.http.get<Issue[]>(this.baseUrl);
//   }


//   getCommentsByIssueId(issueId: number): Observable<Comment[]> {
//     return this.http.get<Comment[]>(`${this.baseUrl}/${issueId}`);
//   }
//   getIssue(id: number): Observable<Issue> {
//     return this.http.get<Issue>(`${this.baseUrl}/${id}`);
//   }

//   createIssue(issue: Issue): Observable<Issue> {
//     return this.http.post<Issue>(this.baseUrl, issue);
//   }

//   updateIssue(id: number, issue: Issue): Observable<Issue> {
//     return this.http.put<Issue>(`${this.baseUrl}/${id}`, issue);
//   }

//   deleteIssue(id: number): Observable<void> {
//     return this.http.delete<void>(`${this.baseUrl}/${id}`);
//   }
// }

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Issue } from '../models/issue.model';
import { Comment } from '../models/comment.model'; // Import Comment model

@Injectable({
  providedIn: 'root'
})
export class IssueService {

  private baseUrl = 'http://localhost:8080/issues';

  constructor(private http: HttpClient) { }

  getIssues(): Observable<Issue[]> {
    return this.http.get<Issue[]>(`${this.baseUrl}`);
  }

  getCommentsByIssueId(issueId: number): Observable<Comment[]> {
   
    return this.http.get<Comment[]>(`${this.baseUrl}/${issueId}/comments`);
  }



  createIssue(issue: Issue): Observable<Issue> {
    return this.http.post<Issue>(`${this.baseUrl}`, issue);
  }
}
