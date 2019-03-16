import { Component, OnInit } from '@angular/core';
import { ProgramcoursService } from '../service/programcours/programcours.service';
import { TypeaheadMatch } from 'ngx-bootstrap/typeahead/public_api';
import { FormBuilder, Validators } from '@angular/forms';


@Component({
  selector: 'app-add-cours-to-program',
  templateUrl: './add-cours-to-program.component.html',
  styleUrls: ['./add-cours-to-program.component.css']
})
export class AddCoursToProgramComponent implements OnInit {

  public displayAdd = false;
  public coursId;
  public programId;

  constructor(private _programcoursService: ProgramcoursService, private fb: FormBuilder) { }

  ngOnInit() {
  }

  registrationForm = this.fb.group({
    id: ['', Validators.required],
    optional: ['', Validators.required],
    coursId: ['', Validators.required],
    programId: ['', Validators.required],

  });

  hint(){
    this.registrationForm.setValue({
      id: 1,
      optional: true,
      coursId: 'INF4375',
      programId: 7316
    })
  }

  onSubmit(){

  	const newProgramCours={
      id: this.registrationForm.value.id,
      optional: this.registrationForm.value.optional
    }

    this.coursId = this.registrationForm.value.coursId;
    this.programId = this.registrationForm.value.programId;
    this._programcoursService.register(newProgramCours, this.coursId, this.programId)
      .subscribe(
        response => console.log('Succes!', response),
        error => console.error('Error!', error)
      );
  }


  onDisplayAdd(){
    this.displayAdd = !this.displayAdd
  }

}
