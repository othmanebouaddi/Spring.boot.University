import { Component, OnInit } from '@angular/core';
import { GroupecoursService } from '../service/groupecours/groupecours.service';
import { TypeaheadMatch } from 'ngx-bootstrap/typeahead/public_api';
import { FormBuilder, Validators } from '@angular/forms';


@Component({
  selector: 'app-addgroupecours',
  templateUrl: './addgroupecours.component.html',
  styleUrls: ['./addgroupecours.component.css']
})
export class AddgroupecoursComponent implements OnInit {


  public displayAdd= false;
  public coursInitials;

  constructor(private _groupecoursService: GroupecoursService, private fb: FormBuilder) { }

  ngOnInit() {
  }
  registrationForm = this.fb.group({
    groupeCoursId: ['', Validators.required],
    initials: ['', Validators.required],
    year: ['', Validators.required],
    season: ['', Validators.required],
    coursInitials: ['', Validators.required]

  });

  hint(){
    this.registrationForm.setValue({
      groupeCoursId: 100,
      initials: 'G10',
      year: 2019,
      season: 'AUTOMUN',
      coursInitials : 'INF4375'

    })
  }


  onSubmit(){

    const newGroupeCours={
      groupeCoursId: this.registrationForm.value.groupeCoursId,
      initials: this.registrationForm.value.initials,
      year: this.registrationForm.value.year,
      season: this.registrationForm.value.season
    }

    this.coursInitials = this.registrationForm.value.coursInitials;
    this._groupecoursService.register(newGroupeCours, this.coursInitials)
      .subscribe(
        response => console.log('Succes!', response),
        error => console.error('Error!', error)
      );
  }

  onDisplayAdd(){
    this.displayAdd= !this.displayAdd
  }

}
