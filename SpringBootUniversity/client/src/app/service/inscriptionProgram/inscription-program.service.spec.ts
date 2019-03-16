import { TestBed, inject } from '@angular/core/testing';

import { InscriptionProgramService } from './inscription-program.service';

describe('InscriptionProgramService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [InscriptionProgramService]
    });
  });

  it('should be created', inject([InscriptionProgramService], (service: InscriptionProgramService) => {
    expect(service).toBeTruthy();
  }));
});
