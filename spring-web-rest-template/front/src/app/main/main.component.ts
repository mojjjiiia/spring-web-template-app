import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth/auth.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  username: string | null;
  token: string| null;
  constructor(private authService: AuthService) {
    this.username = localStorage.getItem('currentUser');
    this.token = localStorage.getItem('token');
   }

  logout() {
    this.authService.logout();
    this.username = null;
    this.token = null;
  }

  testLogin() {
    this.authService.testLogin();
    this.username = localStorage.getItem('currentUser');
    this.token = localStorage.getItem('token');
  }

  ngOnInit(): void {
  }

}
