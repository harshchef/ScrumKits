export interface Issue {
    id: number;
    title: string;
    description: string;
    resolved: boolean;
    comments: Comment[];
  }
  
  export interface Comment {
    id: number;
    text: string;
    issueId: number;
  }
  