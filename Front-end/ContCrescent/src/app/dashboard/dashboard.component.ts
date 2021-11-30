import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  lat: number = 0;
  lng: number = 0;

  ngOnInit() {
    this.getUserLocation();
 }

 getUserLocation() {
    if (navigator.geolocation) {
     navigator.geolocation.getCurrentPosition(position => {
         this.lat = position.coords.latitude;
         this.lng = position.coords.longitude;
         console.log(this.lat + " e " + this.lng)
       });
      }
      else {
        alert("Impossivel encontrar localização! Gentileza permitir uso para melhor experiencia com aplicativo.")
      }
}
}
