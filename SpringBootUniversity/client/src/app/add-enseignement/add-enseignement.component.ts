import { Component, OnInit } from '@angular/core';
import { EnseignementService } from '../service/enseignement/enseignement.service';
import { TypeaheadMatch } from 'ngx-bootstrap/typeahead/public_api';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-enseignement',
  templateUrl: './add-enseignement.component.html',
  styleUrls: ['./add-enseignement.component.css']
})
export class AddEnseignementComponent implements OnInit {

  public displayAdd = false;
  public coursInitials;
  public matriculProf;
  public groupeCoursInitials;

  constructor(private _enseignementService: EnseignementService, private fb: FormBuilder) { }

  ngOnInit() {
  }

  registrationForm = this.fb.group({
    id: ['', Validators.required],
    nombreHeurs: ['', Validators.required],
    matriculProf: ['', Validators.required],
    coursInitials: ['', Validators.required],
    groupeCoursInitials:['', Validators.required]

  });

  hint(){
    this.registrationForm.setValue({
      id: 1,
      nombreHeurs: 6,
      matriculProf: 'MICV1',
      coursInitials: 'INF4375',
      groupeCoursInitials: 'G10'
    })
  }

  onSubmit(){

  	const newEnseignement={
      id: this.registrationForm.value.id,
      nombreHeurs: this.registrationForm.value.nombreHeurs
    }
    this.groupeCoursInitials = this.registrationForm.value.groupeCoursInitials
    this.coursInitials = this.registrationForm.value.coursInitials;
    this.matriculProf = this.registrationForm.value.matriculProf;
    this._enseignementService.register(newEnseignement, this.matriculProf, this.coursInitials, this.groupeCoursInitials)
      .subscribe(
        response => console.log('Succes!', response),
        error => console.error('Error!', error)
      );
  }


  onDisplayAdd(){
    this.displayAdd = !this.displayAdd
  }

}
