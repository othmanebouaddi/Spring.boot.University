import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoursByProgramComponent } from './cours-by-program.component';

describe('CoursByProgramComponent', () => {
  let component: CoursByProgramComponent;
  let fixture: ComponentFixture<CoursByProgramComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoursByProgramComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoursByProgramComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
