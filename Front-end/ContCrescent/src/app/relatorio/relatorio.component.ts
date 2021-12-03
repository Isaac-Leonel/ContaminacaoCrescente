import { Relatorio } from './relatorio.model';
import { Component, OnInit } from '@angular/core';
import { ContServiceService } from '../cont-service.service';

@Component({
  selector: 'app-relatorio',
  templateUrl: './relatorio.component.html',
  styleUrls: ['./relatorio.component.css']
})
export class RelatorioComponent implements OnInit {

  modelRelatorio:Relatorio = new Relatorio();
  list:Array<any> = new Array();

  cont: number = 0;

  gerarRelatorio(){
    this.service.receberRelatorio().subscribe(rel =>{
      this.modelRelatorio = new Relatorio();
      this.list = rel;
    })
  }

  constructor(private service:ContServiceService) { }

  ngOnInit(): void {
  }

}
