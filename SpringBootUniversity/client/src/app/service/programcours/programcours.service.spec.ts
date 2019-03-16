import { TestBed, inject } from '@angular/core/testing';

import { ProgramcoursService } from './programcours.service';

describe('ProgramcoursService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ProgramcoursService]
    });
  });

  it('should be created', inject([ProgramcoursService], (service: ProgramcoursService) => {
    expect(service).toBeTruthy();
  }));
});
