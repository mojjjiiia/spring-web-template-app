import { TestBed } from '@angular/core/testing';

import { LockAppService } from './lock-app.service';

describe('LockAppService', () => {
  let service: LockAppService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LockAppService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
