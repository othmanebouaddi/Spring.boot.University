import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddInscriptionToProgramComponent } from './add-inscription-to-program.component';

describe('AddInscriptionToProgramComponent', () => {
  let component: AddInscriptionToProgramComponent;
  let fixture: ComponentFixture<AddInscriptionToProgramComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddInscriptionToProgramComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddInscriptionToProgramComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
