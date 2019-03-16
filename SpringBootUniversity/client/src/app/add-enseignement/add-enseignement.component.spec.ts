import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEnseignementComponent } from './add-enseignement.component';

describe('AddEnseignementComponent', () => {
  let component: AddEnseignementComponent;
  let fixture: ComponentFixture<AddEnseignementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddEnseignementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddEnseignementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
