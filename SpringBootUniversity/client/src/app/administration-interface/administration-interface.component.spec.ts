import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdministrationInterfaceComponent } from './administration-interface.component';

describe('AdministrationInterfaceComponent', () => {
  let component: AdministrationInterfaceComponent;
  let fixture: ComponentFixture<AdministrationInterfaceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdministrationInterfaceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdministrationInterfaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
