import { Component, OnInit } from '@angular/core';
import { ProgramService } from '../service/program/program.service';
import { TypeaheadMatch } from 'ngx-bootstrap/typeahead/public_api';
import { Program } from './program';
import { Router } from '@angular/router';

@Component({
  selector: 'app-program',
  templateUrl: './program.component.html',
  styleUrls: ['./program.component.css']
})
export class ProgramComponent implements OnInit {

  public errorMsg;
  public programs: Program[];
  public display = false;
  

  constructor( private _programService: ProgramService, private router: Router) { }

  
  
  ngOnInit() {
  }

  onDisplay(){
    this.display = !this.display
    this._programService.getPrograms()
      .subscribe(programs => this.programs = programs,
                    error => this.errorMsg = error);
  }

  onSelect(program){
    this.router.navigate(['/programcours', program.program_initials]);
  }



}
