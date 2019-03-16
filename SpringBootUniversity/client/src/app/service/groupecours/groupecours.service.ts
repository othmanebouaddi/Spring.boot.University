import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Groupecours } from '../../groupecours/groupecours';
import { Observable, Subject, EMPTY, throwError} from 'rxjs';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class GroupecoursService {

  universityApiUrlGet = 'http://localhost:8080/api/groupeCours/allGroupeCours';
  universityApiUrlGet2 = 'http://localhost:8080/api/groupeCours/allGroupeCoursBycours';
  universityApiUrlPost = 'http://localhost:8080/api/groupeCours/createGroupeCours';
  constructor(private http: HttpClient) { }


  getGroupecours(): Observable<Groupecours[]> {
    return this.http.get<Groupecours[]>(this.universityApiUrlGet)
  }

  getGroupecoursByCours(initials): Observable<Groupecours[]> {
    return this.http.get<Groupecours[]>(this.universityApiUrlGet2  + '/' + initials);
  }

  register(userData, coursInitials) {
    return this.http.post<any>(this.universityApiUrlPost + '/' + coursInitials, userData);
  }
}
