import { Component, OnInit } from '@angular/core';
import { InscriptionProgramService } from '../service/inscriptionProgram/inscription-program.service';
import { TypeaheadMatch } from 'ngx-bootstrap/typeahead/public_api';
import { FormBuilder, Validators } from '@angular/forms';


@Component({
  selector: 'app-add-inscription-to-program',
  templateUrl: './add-inscription-to-program.component.html',
  styleUrls: ['./add-inscription-to-program.component.css']
})
export class AddInscriptionToProgramComponent implements OnInit {

  public displayAdd = false;
  public CodeStudent;
  public program_initials;

  constructor(private _inscriptionProgramService: InscriptionProgramService, private fb: FormBuilder) { }

  ngOnInit() {
  }

  registrationForm = this.fb.group({
    id: ['', Validators.required],
    dateInscription: ['', Validators.required],
    moyenProgram: ['', Validators.required],
    CodeStudent: ['', Validators.required],
    program_initials: ['', Validators.required],

  });

  hint(){
    this.registrationForm.setValue({
      id: 1,
      dateInscription: '01/01/2019',
      moyenProgram: 90,
      CodeStudent: 'MICV1',
      program_initials: 7316 
    })
  }

  onSubmit(){

  	const newInscriptionCours={
      id: this.registrationForm.value.id,
      dateInscription: this.registrationForm.value.dateInscription,
      moyenProgram: this.registrationForm.value.moyenProgram
    }

    this.CodeStudent = this.registrationForm.value.CodeStudent;
    this.program_initials = this.registrationForm.value.program_initials;
    this._inscriptionProgramService.register(newInscriptionCours, this.CodeStudent, this.program_initials)
      .subscribe(
        response => console.log('Succes!', response),
        error => console.error('Error!', error)
      );
  }


  onDisplayAdd(){
    this.displayAdd = !this.displayAdd
  }

}
