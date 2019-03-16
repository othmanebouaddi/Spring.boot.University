import { TestBed, inject } from '@angular/core/testing';

import { InscriptionGroupeCoursService } from './inscription-groupe-cours.service';

describe('InscriptionGroupeCoursService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [InscriptionGroupeCoursService]
    });
  });

  it('should be created', inject([InscriptionGroupeCoursService], (service: InscriptionGroupeCoursService) => {
    expect(service).toBeTruthy();
  }));
});
