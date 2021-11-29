import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-input-login',
  templateUrl: './input-login.component.html',
  styleUrls: ['./input-login.component.css']
})
export class InputLoginComponent implements OnInit {

  @Input() tipoDeTexto: String = 'Email';

  @Input() idInput: String = ' ';

  @Input() ModelPegar: String = ' ';


  constructor() { }

  ngOnInit(): void {
  }

}
