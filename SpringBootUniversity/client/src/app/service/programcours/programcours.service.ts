import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Programcours } from '../../program-cours/programcours';
import { Observable, Subject, EMPTY, throwError} from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class ProgramcoursService {


  public programcoursLP;


  universityApiUrlGet = 'http://localhost:8080/api/coursProgram/allCoursProgram';
  universityApiUrlPost = 'http://localhost:8080/api/coursProgram/createCoursProgram';
  constructor(private http: HttpClient) { }


  getProgramscours(): Observable<Programcours[]> {
    return this.http.get<Programcours[]>(this.universityApiUrlGet)
  }

  getProgramcours(program_initials){
    return this.http.get<Programcours[]>(this.universityApiUrlGet + '/' + program_initials);
    
  }

  register(userData, coursId, programId) {
    return this.http.post<any>(this.universityApiUrlPost + '/'+  coursId  + '/' +  programId, userData);
  }
}

