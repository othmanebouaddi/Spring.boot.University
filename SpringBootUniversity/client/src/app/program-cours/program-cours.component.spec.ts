import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProgramCoursComponent } from './program-cours.component';

describe('ProgramCoursComponent', () => {
  let component: ProgramCoursComponent;
  let fixture: ComponentFixture<ProgramCoursComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProgramCoursComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProgramCoursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
