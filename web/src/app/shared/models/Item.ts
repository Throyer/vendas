import { Produto } from './Produto';

export class Item {
  id: number;
  quantidade: number;
  produto: Produto;

  constructor(quantidade: number, produto: Produto) {
    this.quantidade = quantidade;
    this.produto = produto;
  }

  getTotal() {
    return (this.quantidade * this.produto.preco);
  }
}
