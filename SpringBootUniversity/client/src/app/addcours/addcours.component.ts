import { Component, OnInit } from '@angular/core';
import { CoursService } from '../service/cours/cours.service';
import { TypeaheadMatch } from 'ngx-bootstrap/typeahead/public_api';
import { FormBuilder, Validators } from '@angular/forms';



@Component({
  selector: 'app-addcours',
  templateUrl: './addcours.component.html',
  styleUrls: ['./addcours.component.css']
})
export class AddcoursComponent implements OnInit {
  
  public displayAdd = false;

  constructor(private _coursService: CoursService, private fb: FormBuilder) { }

  ngOnInit() {
  }

  registrationForm = this.fb.group({
    initials: ['', Validators.required],
    name: ['', Validators.required],
    credits: ['', Validators.required]

  });

  hint(){
    this.registrationForm.setValue({
      initials: 'INF4375',
      name: "Paradigme d'échange internet",
      credits: 3
    })
  }

  onSubmit(){
    this._coursService.register(this.registrationForm.value)
      .subscribe(
        response => console.log('Succes!', response),
        error => console.error('Error!', error)
      );
  }


  onDisplayAdd(){
    this.displayAdd = !this.displayAdd
  }

}
