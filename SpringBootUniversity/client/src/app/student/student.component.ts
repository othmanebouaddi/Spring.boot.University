import { Component, OnInit } from '@angular/core';
import { StudentService } from '../service/student/student.service';
import { TypeaheadMatch } from 'ngx-bootstrap/typeahead/public_api';
import { Student } from './student';


@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {


  public errorMsg;
  public students: Student[];
  public display = false;
  

  constructor( private _studentService: StudentService) { }

  
  
  ngOnInit() {
    
  }


  onDisplay(){
    this.display = !this.display
    this._studentService.getStudents()
      .subscribe(students => this.students = students,
                    error => this.errorMsg = error);
  }

  



}
