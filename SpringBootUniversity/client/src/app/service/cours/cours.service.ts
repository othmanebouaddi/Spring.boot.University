import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Cours } from '../../cours/cours';
import { Observable, Subject, EMPTY, throwError} from 'rxjs';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};


@Injectable({
  providedIn: 'root'
})
export class CoursService {

  universityApiUrlGet = 'http://localhost:8080/api/cours/allCours';
  universityApiUrlPost = 'http://localhost:8080/api/cours/createCours';
  constructor(private http: HttpClient) { }


  getCours(): Observable<Cours[]> {
    return this.http.get<Cours[]>(this.universityApiUrlGet)
  }

  register(userData) {
    return this.http.post<any>(this.universityApiUrlPost, userData);
  }


}
