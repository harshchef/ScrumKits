import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';

import { IssueListComponent } from './components/issue-list/issue-list.component';

import { CommentListComponent } from './components/comment-list/comment-list.component';
import { AddIssueComponent } from './components/add-issue/add-issue.component';
import { AddCommentComponent } from './components/add-comment/add-comment.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'issues', component: IssueListComponent },
{ path: 'comments/:issueId', component: CommentListComponent },
{ path: 'add-issue', component: AddIssueComponent },
{ path: 'add-comment/:issueId', component: AddCommentComponent } ,
  { path: '**', redirectTo: '', pathMatch: 'full' } // Redirect unknown paths to home
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
