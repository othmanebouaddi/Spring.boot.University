import { Component, OnInit } from '@angular/core';
import { Enseignement } from './enseignement';
import { EnseignementService } from '../service/enseignement/enseignement.service';
import { TypeaheadMatch } from 'ngx-bootstrap/typeahead/public_api';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-enseignement',
  templateUrl: './enseignement.component.html',
  styleUrls: ['./enseignement.component.css']
})
export class EnseignementComponent implements OnInit {

  public errorMsg;
  public enseignementL: Enseignement[];
  public display = false;
  public displayAdd = false;
  public matricul;

  constructor(private _enseignementService: EnseignementService, private fb: FormBuilder) { }

  ngOnInit() {

  }

registrationForm = this.fb.group({
    matricul: ['', Validators.required],

  });

  hint(){
    this.registrationForm.setValue({
      matricul: 'MICV2'
    })
  }

  onDisplayAdd(){
    this.displayAdd = !this.displayAdd
  }

  onDisplay(){
    this.matricul = this.registrationForm.value.matricul;
    this.display = !this.display
    this._enseignementService.getEnseignementByProf(this.matricul)
      .subscribe(enseignement => this.enseignementL = enseignement,
                    error => this.errorMsg = error);
  }

}
