import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cadastro-page',
  templateUrl: './cadastro-page.component.html',
  styleUrls: ['./cadastro-page.component.css']
})
export class CadastroPageComponent implements OnInit {


  senha: any = '';

  verificarSenha(){
    console.log(this.senha)
  }

  constructor() { }

  ngOnInit(): void {
  }

}
