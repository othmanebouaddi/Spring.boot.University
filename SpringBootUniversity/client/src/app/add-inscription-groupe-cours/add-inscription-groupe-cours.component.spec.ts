import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddInscriptionGroupeCoursComponent } from './add-inscription-groupe-cours.component';

describe('AddInscriptionGroupeCoursComponent', () => {
  let component: AddInscriptionGroupeCoursComponent;
  let fixture: ComponentFixture<AddInscriptionGroupeCoursComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddInscriptionGroupeCoursComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddInscriptionGroupeCoursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
