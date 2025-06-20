import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ActivityService {

  private BASE_URL = 'http://localhost:8080/api/activities'

  private PRIJAVA_URL = 'http://localhost:8080/api/' 

  constructor(private http: HttpClient) { }

  getActiveActivities() : Observable<any>{
    return this.http.get(this.BASE_URL + '/active');
  }

  getInActiveActivities() : Observable<any>{
    return this.http.get(this.BASE_URL + '/inactive');
  }

  getActivity(id: number) : Observable<any>{
    return this.http.get(this.BASE_URL+'/activity?id='+id);
  }

  createPrijava(prijava: any): Observable<any> {
    return this.http.post('http://localhost:8080/api/prijave/create', prijava);
  }

  getNastavnikActivities(korisnickoIme : string) : Observable<any>{
    return this.http.get(this.BASE_URL+'/nastavnik/'+ korisnickoIme);
  }

  changeActivityStatus(id : number) : Observable<any>{
    return this.http.post(this.BASE_URL+'/changeStatus/'+id, null);
  }

  addActivity(activity : any) : Observable<any> {
    return this.http.post(this.BASE_URL+'/add', activity);
  }


}
