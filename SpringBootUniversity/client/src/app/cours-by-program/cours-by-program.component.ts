import { Component, OnInit } from '@angular/core';
import { Programcours } from '../program-cours/programcours';
import { ProgramcoursService } from '../service/programcours/programcours.service';
import { TypeaheadMatch } from 'ngx-bootstrap/typeahead/public_api';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cours-by-program',
  templateUrl: './cours-by-program.component.html',
  styleUrls: ['./cours-by-program.component.css']
})
export class CoursByProgramComponent implements OnInit {

  public errorMsg;
  public programcoursLP: Programcours[];
  public id;

  constructor(private _programcoursService: ProgramcoursService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.id = parseInt(this.route.snapshot.paramMap.get('programId'));
    this._programcoursService.getProgramcours(this.id)
      .subscribe(programcours => this.programcoursLP = programcours,
                    error => this.errorMsg = error);
  }


  onSelect(programcours){
    this.router.navigate(['/cours', programcours]);
  }


}
