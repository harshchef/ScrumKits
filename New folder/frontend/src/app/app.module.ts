import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CommonModule } from '@angular/common';

import { IssueListComponent } from './components/issue-list/issue-list.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { HomeComponent } from './home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { CommentListComponent } from './components/comment-list/comment-list.component';
import { AddIssueComponent } from './components/add-issue/add-issue.component';
import { AddCommentComponent } from './components/add-comment/add-comment.component';


@NgModule({
  declarations: [
    AppComponent,
AddCommentComponent,
    IssueListComponent,
    AddIssueComponent,
  
    HomeComponent,
    CommentListComponent,
  

  ],
  imports: [
    BrowserModule,
    CommonModule,
      FormsModule,
      ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    
    
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
