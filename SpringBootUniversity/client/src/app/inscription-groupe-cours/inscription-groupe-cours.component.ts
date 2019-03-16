import { Component, OnInit } from '@angular/core';
import { InscriptionGroupeCours } from './inscription-groupe-cours';
import { InscriptionGroupeCoursService } from '../service/inscriptionGroupeCours/inscription-groupe-cours.service';
import { TypeaheadMatch } from 'ngx-bootstrap/typeahead/public_api';
import { FormBuilder, Validators } from '@angular/forms';


@Component({
  selector: 'app-inscription-groupe-cours',
  templateUrl: './inscription-groupe-cours.component.html',
  styleUrls: ['./inscription-groupe-cours.component.css']
})
export class InscriptionGroupeCoursComponent implements OnInit {

  public displayAdd = false;
  public errorMsg;
  public codeStudent;
  public inscriptionGroupeCoursL: InscriptionGroupeCours[];
  public display = false;
  

  constructor(private _inscriptionGroupeCoursService: InscriptionGroupeCoursService, private fb: FormBuilder) { }

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
    this._inscriptionGroupeCoursService.getAllInscriptionGroupeCoursByStudents(this.codeStudent)
      .subscribe(inscriptionGroupeCours => this.inscriptionGroupeCoursL = inscriptionGroupeCours,
                    error => this.errorMsg = error);
  }

}
