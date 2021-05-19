import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms'
import { Router } from '@angular/router';
import { AuthService } from '../services/auth/auth.service';
import { LockAppService } from '../services/lockApp/lock-app.service';
import { SpinnerComponent } from '../spinner/spinner.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  constructor(
    private authService: AuthService, 
    private lockAppService: LockAppService,
    private router: Router,
    private spinner: SpinnerComponent
    ) { }

  async onSubmit(form: NgForm) {
    this.lockAppService.showSpinner();
    this.authService.authenticate(form.value.login, form.value.password).subscribe(
      (authentication) => {
        this.lockAppService.hideSpinner();
        localStorage.setItem('currentUser', authentication.username as string);
        localStorage.setItem('token', authentication.token as string);
        this.router.navigate(['/']);

      }, 
      () => console.log(this.lockAppService.hideSpinner()
        )
      )

    // let success: boolean = await this.authService.authenticate(form.value.login, form.value.password);
    // if (success) {
      //redirect
    // }
    // else {
      // alert message
    // }
    // this.lockAppService.hideSpinner();

  }

  ngOnInit(): void {
  }

}
