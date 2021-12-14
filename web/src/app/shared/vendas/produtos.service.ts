import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Produto } from '../models/Produto';
import { Page } from '../Page';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProdutosService {

  constructor(private http: HttpClient) { }

  public findProdutos(pesquisa: any): Observable<Page<Produto>> {

    const END_POINT = `${environment.API_URL}/produtos`

    const observable = this
      .http
      .get<Page<Produto>>(END_POINT, { params: pesquisa });

    return observable;
  }

}
