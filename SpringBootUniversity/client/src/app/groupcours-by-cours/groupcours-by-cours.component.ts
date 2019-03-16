import { Component, OnInit } from '@angular/core';
import { Groupecours } from '../groupecours/groupecours';
import { GroupecoursService } from '../service/groupecours/groupecours.service';
import { TypeaheadMatch } from 'ngx-bootstrap/typeahead/public_api';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-groupcours-by-cours',
  templateUrl: './groupcours-by-cours.component.html',
  styleUrls: ['./groupcours-by-cours.component.css']
})
export class GroupcoursByCoursComponent implements OnInit {

  public errorMsg;
  public groupecoursL: Groupecours[];
  public id;

  constructor(private _groupecoursService: GroupecoursService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('initials');
    console.log(this.id);
    this._groupecoursService.getGroupecoursByCours(this.id)
      .subscribe(groupecours => this.groupecoursL = groupecours,
                    error => this.errorMsg = error);
  }


}
