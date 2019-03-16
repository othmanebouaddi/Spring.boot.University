import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddgroupecoursComponent } from './addgroupecours.component';

describe('AddgroupecoursComponent', () => {
  let component: AddgroupecoursComponent;
  let fixture: ComponentFixture<AddgroupecoursComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddgroupecoursComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddgroupecoursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
