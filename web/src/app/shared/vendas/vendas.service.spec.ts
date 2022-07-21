import { TestBed } from '@angular/core/testing';

import { VendasService } from './vendas.service';

describe('VendasService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: VendasService = TestBed.get(VendasService);
    expect(service).toBeTruthy();
  });
});
