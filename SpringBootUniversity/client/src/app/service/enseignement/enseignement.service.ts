import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Enseignement } from '../../enseignement/enseignement';
import { Observable, Subject, EMPTY, throwError} from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class EnseignementService {

  universityApiUrlGet = 'http://localhost:8080/api/enseignement/allEnseignement';
  universityApiUrlGet2 = 'http://localhost:8080/api/enseignement/allEnseignementByProf';
  universityApiUrlPost = 'http://localhost:8080/api/enseignement/createEnseignement';
  constructor(private http: HttpClient) { }


  getEnseignement(): Observable<Enseignement[]> {
    return this.http.get<Enseignement[]>(this.universityApiUrlGet)
  }

  getEnseignementByProf(matricul): Observable<Enseignement[]> {
    return this.http.get<Enseignement[]>(this.universityApiUrlGet2 + '/' + matricul)
  }


  register(userData, matriculProf, coursInitials, groupeCoursInitials) {
    return this.http.post<any>(this.universityApiUrlPost + '/'+ matriculProf + '/' +  coursInitials + '/' + groupeCoursInitials, userData);
  }
}
