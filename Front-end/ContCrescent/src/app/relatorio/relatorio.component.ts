import { Relatorio } from './relatorio.model';
import { Component, OnInit } from '@angular/core';
import { ContServiceService } from '../cont-service.service';

@Component({
  selector: 'app-relatorio',
  templateUrl: './relatorio.component.html',
  styleUrls: ['./relatorio.component.css']
})
export class RelatorioComponent implements OnInit {

  relatorio:Array<any> = new Array();
  modelRelatorio:Relatorio = new Relatorio();

  gerarRelatorio(){
    this.service.receberRelatorio().subscribe(rel =>{
      this.modelRelatorio = new Relatorio();
      this.relatorio = rel;
      console.log(this.relatorio[0], this.relatorio[1])
    })
  }

  constructor(private service:ContServiceService) { }

  ngOnInit(): void {
  }

}
