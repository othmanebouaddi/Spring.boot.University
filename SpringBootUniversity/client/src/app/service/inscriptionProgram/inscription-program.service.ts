import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { InscriptionProgram } from '../../inscription-program/inscription-program';
import { Observable, Subject, EMPTY, throwError} from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class InscriptionProgramService {

  universityApiUrlGet = 'http://localhost:8080/api/studentProgram/allStudentProgram';
  universityApiUrlGet2 = 'http://localhost:8080/api/studentProgram/allInscriptionProgramByStudent';
  universityApiUrlPost = 'http://localhost:8080/api/inscriptionProgram';
  constructor(private http: HttpClient) { }


  getInscriptionProgram(): Observable<InscriptionProgram[]> {
    return this.http.get<InscriptionProgram[]>(this.universityApiUrlGet)
  }

  getInscriptionProgramByStudent(codeStudent): Observable<InscriptionProgram[]> {
    return this.http.get<InscriptionProgram[]>(this.universityApiUrlGet2 + '/' + codeStudent)
  }


  register(userData, CodeStudent, Program_initials) {
    return this.http.post<any>(this.universityApiUrlPost + '/'+ CodeStudent + '/' +  Program_initials, userData);
  }
}
