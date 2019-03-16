import { Component, OnInit } from '@angular/core';
import { InscriptionProgram } from './inscription-program';
import { InscriptionProgramService } from '../service/inscriptionProgram/inscription-program.service';
import { TypeaheadMatch } from 'ngx-bootstrap/typeahead/public_api';
import { FormBuilder, Validators } from '@angular/forms';


@Component({
  selector: 'app-inscription-program',
  templateUrl: './inscription-program.component.html',
  styleUrls: ['./inscription-program.component.css']
})
export class InscriptionProgramComponent implements OnInit {

  public displayAdd = false;
  public errorMsg;
  public codeStudent;
  public inscriptionProgramL: InscriptionProgram[];
  public display = false;
  

  constructor(private _inscriptionProgramService: InscriptionProgramService, private fb: FormBuilder) { }

  ngOnInit() {

  }

  registrationForm = this.fb.group({
    codeStudent: ['', Validators.required],

  });

  hint(){
    this.registrationForm.setValue({
      codeStudent: 'MICV1'
    })
  }

  onDisplayAdd(){
    this.displayAdd = !this.displayAdd
  }

  onDisplay(){
    this.codeStudent = this.registrationForm.value.codeStudent,
    this.display = !this.display
    this._inscriptionProgramService.getInscriptionProgramByStudent(this.codeStudent)
      .subscribe(inscriptionProgram => this.inscriptionProgramL = inscriptionProgram,
                    error => this.errorMsg = error);
  }

}
