import { Login } from './login.model';
import { Component, Inject, OnInit } from '@angular/core';
import { ContServiceService } from '../cont-service.service';
import { DOCUMENT } from '@angular/common';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  lng:Login = new Login();
  resultado: boolean = false;
  

  validar(){
    this.service.usuarioValidar(this.lng).subscribe(val =>{
      this.lng = new Login();
      this.resultado = val;
      if(this.resultado == true){
        this.document.location.href = 'http://localhost:4200/dashboard';
      }
    })
  }



  constructor(private service:ContServiceService, @Inject(DOCUMENT)private document:any) { }

  ngOnInit(): void {
  }

}
