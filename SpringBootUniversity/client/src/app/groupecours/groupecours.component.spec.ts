import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GroupecoursComponent } from './groupecours.component';

describe('GroupecoursComponent', () => {
  let component: GroupecoursComponent;
  let fixture: ComponentFixture<GroupecoursComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GroupecoursComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GroupecoursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
