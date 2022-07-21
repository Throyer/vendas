import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VendasFormClienteComponent } from './vendas-form-cliente.component';

describe('VendasFormClienteComponent', () => {
  let component: VendasFormClienteComponent;
  let fixture: ComponentFixture<VendasFormClienteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VendasFormClienteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VendasFormClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
