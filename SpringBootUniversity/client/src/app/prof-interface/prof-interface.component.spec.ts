import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfInterfaceComponent } from './prof-interface.component';

describe('ProfInterfaceComponent', () => {
  let component: ProfInterfaceComponent;
  let fixture: ComponentFixture<ProfInterfaceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfInterfaceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfInterfaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
