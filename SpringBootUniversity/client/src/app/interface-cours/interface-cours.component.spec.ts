import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IntrfaceCoursComponent } from './intrface-cours.component';

describe('IntrfaceCoursComponent', () => {
  let component: IntrfaceCoursComponent;
  let fixture: ComponentFixture<IntrfaceCoursComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IntrfaceCoursComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IntrfaceCoursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
