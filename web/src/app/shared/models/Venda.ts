import { Cliente } from './Cliente';
import { Item } from './Item';
import { Funcionario } from './Funcinario';

export class Venda {
  id: number;
  cliente: Cliente;
  vendedor: Funcionario;
  itens: Item[];
  data: Date;
  total: number;

  constructor() {
    this.itens = [];
  }

  getTotal() {
    return this.itens.map(item => item.getTotal()).reduce((total, item) => total + item, 0);
  }
}
