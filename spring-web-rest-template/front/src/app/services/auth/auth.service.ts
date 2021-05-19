import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EnvironmentService } from '../environments/environment.service';
import { Authentication } from './authentication.interface';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl: string = this.environmentsService.apiUrl;

  constructor(private http: HttpClient, private environmentsService: EnvironmentService) {
  }


  authenticate(login: String, password: String): Observable<Authentication> {
    // function handleSuccess(resp: Authentication): boolean {
    //   localStorage.setItem('currentUser', resp.username as string);
    //   localStorage.setItem('token', resp.token as string);
    //   return true
    // }

    // function handleError(): boolean {
    //   console.warn('Wrong login or passsword')
    //   return false
    // }
      return this.http
        .post<Authentication>(this.apiUrl + '/api/v1/auth/login', { username: login, password: password });
  }

  logout(): void {
    console.log(123)
    localStorage.removeItem('currentUser');
    localStorage.removeItem('token');
  }

  testLogin(): void {
    localStorage.setItem('currentUser', 'mojjjiiia');
    localStorage.setItem('token', 'abacaba123');
  }
  

}

