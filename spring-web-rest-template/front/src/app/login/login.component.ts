import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms'
import { AuthService } from '../services/auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  constructor(private authService: AuthService) { }

  async onSubmit(form: NgForm) {
    let success: boolean = await this.authService.authenticate(form.value.login, form.value.password);
    if (success) {
      //redirect
    }
    else {
      // alert message
    }

  }

  ngOnInit(): void {
  }

}
