import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Program } from '../../program/program';
import { Observable, Subject, EMPTY, throwError} from 'rxjs';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class ProgramService {

  universityApiUrlGet = 'http://localhost:8080/api/program/allPrograms';
  universityApiUrlPost = 'http://localhost:8080/api/program/createProgram';
  constructor(private http: HttpClient) { }


  getPrograms(): Observable<Program[]> {
    return this.http.get<Program[]>(this.universityApiUrlGet)
  }

  register(userData) {
    return this.http.post<any>(this.universityApiUrlPost, userData);
  }
}
