import { Usuario } from './usuario.model';
import { ContServiceService, } from './../cont-service.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cadastro-page',
  templateUrl: './cadastro-page.component.html',
  styleUrls: ['./cadastro-page.component.css']
})
export class CadastroPageComponent implements OnInit {


  modelo:Usuario = new Usuario();

  registrar(){
    this.service.usuarioSave(this.modelo).subscribe(user => {
      this.modelo = new Usuario();

    })
  }

  constructor(private service:ContServiceService) {}

  ngOnInit(): void {}

}
