import { Login } from './login-page/login.model';
import { Usuario } from './cadastro-page/usuario.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContServiceService {

  
  constructor(private http:HttpClient) { }

  usuarioSave (usuario:Usuario):Observable<any>{
    
    return this.http.post("http://localhost:8080/usuario/salvar-usuario", usuario);
  }

  usuarioValidar (login:Login):Observable<any>{
    return this.http.get("http://localhost:8080/usuario/validar-usuario/".concat(login.email)+"/".concat(login.senha));
  }
}
