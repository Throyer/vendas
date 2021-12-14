import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VendaFormComponent } from './venda-form.component';

describe('VendaFormComponent', () => {
  let component: VendaFormComponent;
  let fixture: ComponentFixture<VendaFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VendaFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VendaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
