import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoursGroupecoursComponent } from './cours-groupecours.component';

describe('CoursGroupecoursComponent', () => {
  let component: CoursGroupecoursComponent;
  let fixture: ComponentFixture<CoursGroupecoursComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoursGroupecoursComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoursGroupecoursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
