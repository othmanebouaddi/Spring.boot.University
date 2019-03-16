import { Component, OnInit } from '@angular/core';
import { GroupecoursService } from '../service/groupecours/groupecours.service';
import { TypeaheadMatch } from 'ngx-bootstrap/typeahead/public_api';
import { Groupecours } from './groupecours';




@Component({
  selector: 'app-groupecours',
  templateUrl: './groupecours.component.html',
  styleUrls: ['./groupecours.component.css']
})
export class GroupecoursComponent implements OnInit {

  public errorMsg;
  public groupecoursL: Groupecours[];
  
  public display = false;
  


  constructor( private _groupecoursService: GroupecoursService) { }

  
  
  ngOnInit() {
  }


  onDisplay(){
    this.display = !this.display
    this._groupecoursService.getGroupecours()
      .subscribe(groupecours => this.groupecoursL = groupecours,
                    error => this.errorMsg = error);
  }


}
