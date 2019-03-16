import { Component, OnInit } from '@angular/core';
import { Programcours } from './programcours';
import { ProgramcoursService } from '../service/programcours/programcours.service';
import { TypeaheadMatch } from 'ngx-bootstrap/typeahead/public_api';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-program-cours',
  templateUrl: './program-cours.component.html',
  styleUrls: ['./program-cours.component.css']
})
export class ProgramCoursComponent implements OnInit {

  public errorMsg;
  public programcoursL: Programcours[];
  public programcoursLP: Programcours[];
  public display = false;
  public displayProgram = false;
  public id;
  

  constructor(private _programcoursService: ProgramcoursService, private route: ActivatedRoute) { }

  ngOnInit() {

  }


  onDisplay(){
    this.display = !this.display
    this._programcoursService.getProgramscours()
      .subscribe(programcours => this.programcoursL = programcours,
                    error => this.errorMsg = error);
  }

  



}
