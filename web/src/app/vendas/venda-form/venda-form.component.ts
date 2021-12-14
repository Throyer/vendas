import { Component, OnInit, EventEmitter, ElementRef, ViewChild } from '@angular/core';
import { ProdutosService } from 'src/app/shared/vendas/produtos.service';
import { Produto } from 'src/app/shared/models/Produto';
import { debounceTime, switchMap } from 'rxjs/operators';
import { Venda } from 'src/app/shared/models/Venda';
import { Item } from 'src/app/shared/models/Item';

@Component({
  selector: 'app-venda-form',
  templateUrl: './venda-form.component.html',
  styleUrls: ['./venda-form.component.scss']
})
export class VendaFormComponent implements OnInit {

  isLoading = false;

  public adicionar: ElementRef;

  public produtos: Produto[] = [];
  public items: Item[] = [];

  typeahead = new EventEmitter<string>();

  public venda: Venda = null;
  public produto: Produto = null;

  constructor(private service: ProdutosService) {
    this.typeahead
      .pipe(debounceTime(700), switchMap(pesquisa => this.findProdutos(pesquisa)))
      .subscribe(produtos => this.produtos = produtos);
  }

  async findProdutos(pesquisa: any) {
    if (pesquisa) {
      this.isLoading = true;

      const isNumber = !Number.isNaN(parseInt(pesquisa));

      const params: any = {};

      if (isNumber) {
        params.codigo = parseInt(pesquisa);
      }

      if (!isNumber) {
        params.nome = pesquisa;
      }

      const page = await this.service.findProdutos(params).toPromise();

      this.isLoading = false;

      return page.content
    }
  }

  adicionarItem(): void {
    if (this.produto) {
      const id = this.produto.id;
      const item = this.venda.itens.find(item => item.produto.id === id);
      if (item) {
        item.quantidade = item.quantidade + 1;
      }
    }

    if (this.produto && this.venda.itens.every(item => item.produto.id !== this.produto.id)) {
      this.venda.itens = [...this.venda.itens, new Item(1, this.produto)];
    }
  }

  removerItem(item: Item): void {
    const itens = this.venda
      .itens
        .filter(_item => _item.produto.id !== item.produto.id);

    this.venda.itens = [...itens];
  }

  ngOnInit() {
    this.venda = new Venda();
  }

}
