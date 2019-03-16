import { TestBed, inject } from '@angular/core/testing';

import { GroupecoursService } from './groupecours.service';

describe('GroupecoursService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GroupecoursService]
    });
  });

  it('should be created', inject([GroupecoursService], (service: GroupecoursService) => {
    expect(service).toBeTruthy();
  }));
});
