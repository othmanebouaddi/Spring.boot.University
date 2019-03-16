import { Component, OnInit } from '@angular/core';
import { InscriptionGroupeCoursService } from '../service/inscriptionGroupeCours/inscription-groupe-cours.service';
import { TypeaheadMatch } from 'ngx-bootstrap/typeahead/public_api';
import { FormBuilder, Validators } from '@angular/forms';


@Component({
  selector: 'app-add-inscription-groupe-cours',
  templateUrl: './add-inscription-groupe-cours.component.html',
  styleUrls: ['./add-inscription-groupe-cours.component.css']
})
export class AddInscriptionGroupeCoursComponent implements OnInit {

  
  public displayAdd = false;
  public codeStudent;
  public CoursInitial;
  public groupeCoursInitial;

  constructor(private _inscriptionGroupeCoursService: InscriptionGroupeCoursService, private fb: FormBuilder) { }

  ngOnInit() {
  }

  registrationForm = this.fb.group({
    id: ['', Validators.required],
    noteFinal: ['', Validators.required],
    letterNote: ['', Validators.required],
    codeStudent: ['', Validators.required],
    CoursInitial: ['', Validators.required],
    groupeCoursInitial: ['', Validators.required]

  });

  hint(){
    this.registrationForm.setValue({
      id: 1,
      noteFinal: 90,
      letterNote: 'A',
      codeStudent: 'MICV1',
      CoursInitial: 'INF4375',
      groupeCoursInitial: 'G10'
    })
  }

  onSubmit(){

  	const newInscriptionGroupeCours={
      id: this.registrationForm.value.id,
      noteFinal: this.registrationForm.value.noteFinal,
      letterNote: this.registrationForm.value.letterNote
    }

    this.codeStudent = this.registrationForm.value.codeStudent;
    this.CoursInitial = this.registrationForm.value.CoursInitial;
    this.groupeCoursInitial = this.registrationForm.value.groupeCoursInitial;
    this._inscriptionGroupeCoursService.register(newInscriptionGroupeCours, this.codeStudent, this.CoursInitial, this.groupeCoursInitial)
      .subscribe(
        response => console.log('Succes!', response),
        error => console.error('Error!', error)
      );
  }


  onDisplayAdd(){
    this.displayAdd = !this.displayAdd
  }

}
