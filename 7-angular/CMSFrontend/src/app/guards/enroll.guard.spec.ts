import { TestBed } from '@angular/core/testing';

import { EnrollGuard } from './enroll.guard';

describe('EnrollGuard', () => {
  let guard: EnrollGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(EnrollGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
