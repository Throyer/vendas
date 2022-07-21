import { Component, OnInit, EventEmitter, Input, Output } from '@angular/core';
import { Cliente } from 'src/app/shared/models/Cliente';
import { ClientesService } from 'src/app/shared/vendas/clientes.service';
import { debounceTime, switchMap } from 'rxjs/operators';
import { Page } from 'src/app/shared/Page';

@Component({
  selector: 'app-vendas-form-cliente',
  templateUrl: './vendas-form-cliente.component.html',
  styleUrls: ['./vendas-form-cliente.component.scss']
})
export class VendasFormClienteComponent implements OnInit {

  isLoading = false;

  public clientes: Cliente[] = [];

  typeahead = new EventEmitter<string>();

  @Output()
  clienteChange = new EventEmitter<Cliente>();

  @Input()
  public cliente: Cliente = null;

  constructor(private service: ClientesService) {
    this.typeahead
      .pipe(debounceTime(700), switchMap(pesquisa => this.findClientes(pesquisa)))
      .subscribe(clientes => this.clientes = clientes);
  }

  async findClientes(pesquisa: any) {
    if (pesquisa) {
      this.isLoading = true;

      const isNumber = !Number.isNaN(parseInt(pesquisa));

      const params: any = {};

      if (isNumber) {
        params.codigo = parseInt(pesquisa);
      }

      if (!isNumber) {
        params.nome = pesquisa;
        params.rg = pesquisa;
        params.cpf = pesquisa;
        params.cnpj = pesquisa;
      }

      const page = await this.service.findClientes(params).toPromise();

      this.isLoading = false;

      return page.content
    }
  }

  ngOnInit() { }

}
