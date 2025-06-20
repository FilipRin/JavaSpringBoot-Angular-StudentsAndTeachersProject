import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

interface LoginResponse{
  message:string;
  success: boolean;
}

@Injectable({
  providedIn: 'root'
})


export class AuthService {

  private BASE_URL = "http://localhost:8080"

  constructor(private http: HttpClient) { }

  login(username: string, password: string, tip: string){
    return this.http.post<LoginResponse>(this.BASE_URL + "/api/auth/login", {
      korisnickoIme: username,
      lozinka: password,
      tip: tip
    })
  }

  static logout(){
    localStorage.removeItem('userData')
  }

}
