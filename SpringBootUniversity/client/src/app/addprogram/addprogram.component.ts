import { Component, OnInit } from '@angular/core';
import { ProgramService } from '../service/program/program.service';
import { TypeaheadMatch } from 'ngx-bootstrap/typeahead/public_api';
import { FormBuilder, Validators } from '@angular/forms';



@Component({
  selector: 'app-addprogram',
  templateUrl: './addprogram.component.html',
  styleUrls: ['./addprogram.component.css']
})
export class AddprogramComponent implements OnInit {

  public displayAdd = false;

  constructor(private _programService: ProgramService, private fb: FormBuilder) { }

  ngOnInit() {
  }

  registrationForm = this.fb.group({
    program_initials: ['', Validators.required],
    name: ['', Validators.required],
    cycle: ['', Validators.required]
  });

  hint(){
    this.registrationForm.setValue({
      program_initials: 7316,
      name: 'Informatique et génie logiciel',
      cycle: 'BACCALAUREAT'
    })
  }

  onSubmit(){
    this._programService.register(this.registrationForm.value)
      .subscribe(
        response => console.log('Succes!', response),
        error => console.error('Error!', error)
      );
  }


  onDisplayAdd(){
    this.displayAdd = !this.displayAdd
  }

}
