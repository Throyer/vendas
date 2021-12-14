import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Page } from '../Page';
import { Cliente } from '../models/Cliente';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  constructor(private http: HttpClient) { }

  public findClientes(pesquisa: any): Observable<Page<Cliente>> {

    const END_POINT = `${environment.API_URL}/clientes`

    return this
      .http
        .get<Page<any>>(END_POINT, { params: pesquisa });
  }
}
