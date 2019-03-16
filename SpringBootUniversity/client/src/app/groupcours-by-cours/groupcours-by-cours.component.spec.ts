import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GroupcoursByCoursComponent } from './groupcours-by-cours.component';

describe('GroupcoursByCoursComponent', () => {
  let component: GroupcoursByCoursComponent;
  let fixture: ComponentFixture<GroupcoursByCoursComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GroupcoursByCoursComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GroupcoursByCoursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
