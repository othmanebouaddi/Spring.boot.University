import { Component, OnInit } from '@angular/core';
import { CoursService } from '../service/cours/cours.service';
import { TypeaheadMatch } from 'ngx-bootstrap/typeahead/public_api';
import { Cours } from './cours';


@Component({
  selector: 'app-cours',
  templateUrl: './cours.component.html',
  styleUrls: ['./cours.component.css']
})
export class CoursComponent implements OnInit {

  public errorMsg;
  public coursL: Cours[];
  public display = false;
  

  constructor(private _coursService: CoursService) { }

  ngOnInit() {

  }


  onDisplay(){
    this.display = !this.display
    this._coursService.getCours()
      .subscribe(cours => this.coursL = cours,
                    error => this.errorMsg = error);
  }



}
