import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { InscriptionGroupeCours } from '../../inscription-groupe-cours/inscription-groupe-cours';
import { Observable, Subject, EMPTY, throwError} from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};


@Injectable({
  providedIn: 'root'
})
export class InscriptionGroupeCoursService {

  universityApiUrlGet = 'http://localhost:8080/api/inscriptionGroupeCours/allStudentsGroupeCours';
  universityApiUrlGet2 = 'http://localhost:8080/api/inscriptionGroupeCours/allInscriptionGroupeCoursByStudents';
  universityApiUrlPost = 'http://localhost:8080/api/inscriptionGroupeCours';
  constructor(private http: HttpClient) { }


  getInscriptionGroupeCours(): Observable<InscriptionGroupeCours[]> {
    return this.http.get<InscriptionGroupeCours[]>(this.universityApiUrlGet)
  }

  getAllInscriptionGroupeCoursByStudents(codeStudent): Observable<InscriptionGroupeCours[]> {
    return this.http.get<InscriptionGroupeCours[]>(this.universityApiUrlGet2 + '/' + codeStudent)
  }


  register(userData, CodeStudent, CoursInitial, groupeCoursInitial ) {
    return this.http.post<any>(this.universityApiUrlPost + '/'+ CodeStudent + '/' +  CoursInitial + '/' + groupeCoursInitial, userData);
  }
}



