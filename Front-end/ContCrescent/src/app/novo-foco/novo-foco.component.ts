import { InfoFoco } from './info-foco.model';
import { Resultado } from './resultado.model';
import { ContServiceService } from './../cont-service.service';
import { Foco } from './foco.model';
import { Component, Inject, OnInit } from '@angular/core';
import { DOCUMENT } from '@angular/common';

@Component({
  selector: 'app-novo-foco',
  templateUrl: './novo-foco.component.html',
  styleUrls: ['./novo-foco.component.css']
})
export class NovoFocoComponent implements OnInit {

  local:Foco = new Foco();
  list:Resultado = new Resultado();
  lists:Array<any> = new Array();

  iFoco:InfoFoco = new InfoFoco();
  focoSalvo: any;
  
  countries = [
    {id: 1, name: "Lixo Quimico"},
    {id: 2, name: "Ação Humana"},
    {id: 3, name: "Lixo Industrial"},
    {id: 4, name: "Esgoto"}
 ];
 selectedValue = '';


  ngOnInit() {
    this.getUserLocation();
    
 }

 getUserLocation() {
    if (navigator.geolocation) {
     navigator.geolocation.getCurrentPosition(position => {
         this.local.lat = position.coords.latitude + "";
         this.local.lng = position.coords.longitude + "";
         this.pegarRef();
       });
      }
      else {
        alert("Impossivel encontrar localização! Gentileza permitir uso para melhor experiencia com aplicativo.")
      }
  }

  pegarRef(){ 
    this.service.enviarLocal(this.local).subscribe(loc =>{
      this.local = new Foco();
      this.lists = loc;
      console.log(this.lists[1]);
    })
  }

  enviarFoco(){
    this.iFoco.idVertice = this.lists[0];
    this.iFoco.causaPoluicao = this.selectedValue;
    console.log(this.iFoco.causaPoluicao, this.iFoco.idVertice);
    this.service.enviarFoco(this.iFoco).subscribe(foco =>{
      this.iFoco = new InfoFoco();
      this.focoSalvo = foco;
    })
  }


  constructor(private service:ContServiceService, @Inject(DOCUMENT)private document:any) {}


}
