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

  lat: number = 0;
  lng: number = 0;

  local:Foco = new Foco();
  result: string = '';

  ngOnInit() {
    this.getUserLocation();
 }

 getUserLocation() {
    if (navigator.geolocation) {
     navigator.geolocation.getCurrentPosition(position => {
         this.lat = position.coords.latitude;
         this.lng = position.coords.longitude;
         this.local.lat = this.lat + "";
         this.local.lng = this.lng + "";
       });
      }
      else {
        alert("Impossivel encontrar localização! Gentileza permitir uso para melhor experiencia com aplicativo.")
      }
  }

  enviarFoco(){ 
    this.service.enviarLocal(this.local).subscribe(loc =>{
      this.local = new Foco();
      this.result = loc;
      
    })
  }

  constructor(private service:ContServiceService, @Inject(DOCUMENT)private document:any) {}


}
