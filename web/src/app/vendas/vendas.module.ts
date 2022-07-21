import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VendaFormComponent } from './venda-form/venda-form.component';
import { HttpClientModule } from '@angular/common/http';
import { NgSelectModule } from '@ng-select/ng-select';
import { FormsModule } from '@angular/forms';
import { VendasFormClienteComponent } from './venda-form/vendas-form-cliente/vendas-form-cliente.component';

@NgModule({
  declarations: [
    VendaFormComponent,
    VendasFormClienteComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    NgSelectModule,
    FormsModule,
  ],
  exports: [
    VendaFormComponent
  ]
})
export class VendasModule { }
