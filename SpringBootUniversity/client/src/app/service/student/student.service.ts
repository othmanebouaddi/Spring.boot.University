import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Student } from '../../student/student';
import { Observable, Subject, EMPTY, throwError} from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};


@Injectable()
export class StudentService {

  universityApiUrlGet = 'http://localhost:8080/api/student/allStudents';
  universityApiUrlPost = 'http://localhost:8080/api/student/createStudent';
  constructor(private http: HttpClient) { }



  getStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(this.universityApiUrlGet)
  }

  register(userData) {
    return this.http.post<any>(this.universityApiUrlPost, userData);
  }


}
