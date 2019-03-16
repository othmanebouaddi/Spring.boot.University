import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InterfaceProgramcoursComponent } from './interface-programcours.component';

describe('InterfaceProgramcoursComponent', () => {
  let component: InterfaceProgramcoursComponent;
  let fixture: ComponentFixture<InterfaceProgramcoursComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InterfaceProgramcoursComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InterfaceProgramcoursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
