import { Component, OnInit } from '@angular/core';
import { StudentService } from '../service/student/student.service';
import { TypeaheadMatch } from 'ngx-bootstrap/typeahead/public_api';
import { FormBuilder, Validators } from '@angular/forms';


@Component({
  selector: 'app-addstudent',
  templateUrl: './addstudent.component.html',
  styleUrls: ['./addstudent.component.css']
})
export class AddstudentComponent implements OnInit {

  
  public displayAdd = false;


  constructor(private _studentService: StudentService, private fb: FormBuilder) { }

  ngOnInit() {
  }


  registrationForm = this.fb.group({
    personid: ['', Validators.required],
    name: ['', Validators.required],
    address: ['', Validators.required],
    codeStudent: ['', Validators.required],
    sex: ['', Validators.required],
    stillStudying: ['', Validators.required]
  });

  hint(){
    this.registrationForm.setValue({
      personid: 101,
      name: 'Michel valion',
      address: 'Canada',
      codeStudent: 'MICV1',
      sex: 'M',
      stillStudying: true
    })
  }

 
  onSubmit(){
    this._studentService.register(this.registrationForm.value)
      .subscribe(
        response => console.log('Succes!', response),
        error => console.error('Error!', error)
      );

  }

  onDisplayAdd(){
    this.displayAdd = !this.displayAdd
  }

}
