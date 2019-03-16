import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InscriptionProgramComponent } from './inscription-program.component';

describe('InscriptionProgramComponent', () => {
  let component: InscriptionProgramComponent;
  let fixture: ComponentFixture<InscriptionProgramComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InscriptionProgramComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InscriptionProgramComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
