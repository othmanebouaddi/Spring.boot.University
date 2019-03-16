import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InscriptionGroupeCoursComponent } from './inscription-groupe-cours.component';

describe('InscriptionGroupeCoursComponent', () => {
  let component: InscriptionGroupeCoursComponent;
  let fixture: ComponentFixture<InscriptionGroupeCoursComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InscriptionGroupeCoursComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InscriptionGroupeCoursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
