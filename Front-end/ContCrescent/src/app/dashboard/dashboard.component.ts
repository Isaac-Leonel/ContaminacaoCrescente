import { Component, OnInit } from '@angular/core';
import { ContServiceService } from '../cont-service.service';
import { Foco } from '../novo-foco/foco.model';
import { Resultado } from '../novo-foco/resultado.model';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {



  ngOnInit() {
 }


  constructor() {}

}

