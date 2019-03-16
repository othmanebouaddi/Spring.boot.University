import { Component, OnInit } from '@angular/core';
import { ProfService } from '../service/prof/prof.service';
import { TypeaheadMatch } from 'ngx-bootstrap/typeahead/public_api';
import { FormBuilder, Validators } from '@angular/forms';



@Component({
  selector: 'app-addprof',
  templateUrl: './addprof.component.html',
  styleUrls: ['./addprof.component.css']
})

export class AddprofComponent implements OnInit {
	
  public displayAdd = false;

  constructor(private _profService: ProfService, private fb: FormBuilder) { }

  ngOnInit() {
  }

  registrationForm = this.fb.group({
    personid: ['', Validators.required],
    name: ['', Validators.required],
    address: ['', Validators.required],
    matricul: ['', Validators.required],
    sex: ['', Validators.required],
    salary: ['', Validators.required]
  });

  hint(){
    this.registrationForm.setValue({
      personid: 101,
      name: 'Jacque berger',
      address: 'Canada',
      matricul: 'MICV1',
      sex: 'M',
      salary: 100000
    })
  }

  onSubmit(){
    this._profService.register(this.registrationForm.value)
      .subscribe(
        response => console.log('Succes!', response),
        error => console.error('Error!', error)
      );
  }

  onDisplayAdd(){
    this.displayAdd = !this.displayAdd
  }

}
