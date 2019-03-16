import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCoursToProgramComponent } from './add-cours-to-program.component';

describe('AddCoursToProgramComponent', () => {
  let component: AddCoursToProgramComponent;
  let fixture: ComponentFixture<AddCoursToProgramComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddCoursToProgramComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddCoursToProgramComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
