import { TestBed } from '@angular/core/testing';

import { ClientesService } from './clientes.service';

describe('ClientesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ClientesService = TestBed.get(ClientesService);
    expect(service).toBeTruthy();
  });
});
