import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router'
import { Observable } from 'rxjs';
import { AuthStateService } from './auth-state.service';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
  })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  
  api_url: string = 'https://apisconnect-bmm2.onrender.com/';
  f: any;

  registerUser(userData: any): Observable<any>{
    return this.http.post<any>(this.api_url + 'api/register/', userData);  
  }
  
  constructor(private http: HttpClient, private router: Router, private authStateService: AuthStateService) { }

  login(username: string, password: string) {
    return this.http.post<any>(this.api_url + 'api/login/', { username, password }, httpOptions)
      .pipe(map(user => {
        if (user && user.token) {
          localStorage.setItem('currentUser', JSON.stringify(user));
        }
        console.log(user.token)
        this.authStateService.setLoggedIn(true);
        this.router.navigate(['/inicio']);
        return user;
      }));
  }

  logout() {
    localStorage.removeItem('currentUser');
    localStorage.removeItem('token');
    this.authStateService.setLoggedIn(false);
    this.router.navigate(['/login']);
  }


// Lista de Usuarios

  getUsers(): Observable<any[]> {
    return this.http.get<any[]>(this.api_url + 'api/listusers/').pipe(
      map(response => response)
    );
  }

  deleteUser(id: number): Observable<any> {
    const url = `${this.api_url}api/listusers/${id}/`; 
    return this.http.delete<any>(url);
  }
}
