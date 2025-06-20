import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PrijavaService {

  private BASE_URL = 'http://localhost:8080/api/prijave'

  constructor(private http : HttpClient) { }

  getPrijaveByStudent(student : string) : Observable<any>{
    return this.http.get(this.BASE_URL +'/student/'+student)
  }

  getPrijaveByAktivnost(aktivnost : string) : Observable<any>{
    return this.http.get(this.BASE_URL +'/aktivnost/'+aktivnost)
  }

  getPrijaveBySala(sala : string) : Observable<any>{
    return this.http.get(this.BASE_URL +'/sala/'+sala)
  }

}
