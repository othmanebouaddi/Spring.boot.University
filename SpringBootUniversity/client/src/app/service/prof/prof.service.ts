import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Prof } from '../../prof/prof';
import { Observable, Subject, EMPTY, throwError} from 'rxjs';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class ProfService {

  universityApiUrlGet = 'http://localhost:8080/api/prof/allProfs';
  universityApiUrlPost = 'http://localhost:8080/api/prof/createProf';
  constructor(private http: HttpClient) { }


  getProfs(): Observable<Prof[]> {
    return this.http.get<Prof[]>(this.universityApiUrlGet)
  }

  register(userData) {
    return this.http.post<any>(this.universityApiUrlPost, userData);
  }
}
