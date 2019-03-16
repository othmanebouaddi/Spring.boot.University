import { Component, OnInit } from '@angular/core';
import { ProfService } from '../service/prof/prof.service';
import { TypeaheadMatch } from 'ngx-bootstrap/typeahead/public_api';
import { Prof } from './prof';



@Component({
  selector: 'app-prof',
  templateUrl: './prof.component.html',
  styleUrls: ['./prof.component.css']
})
export class ProfComponent implements OnInit {


  public errorMsg;
  public profs: Prof[];
  public display = false;
  

  constructor(private _profService: ProfService) { }

  ngOnInit() {
  }

  

  onDisplay(){
    this.display = !this.display
    this._profService.getProfs()
      .subscribe(profs => this.profs = profs,
                    error => this.errorMsg = error);
  }

  



}
