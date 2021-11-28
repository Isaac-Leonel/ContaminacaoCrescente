import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-button-lo',
  templateUrl: './button-lo.component.html',
  styleUrls: ['./button-lo.component.css']
})
export class ButtonLoComponent implements OnInit {

  @Input() textButton: string = " ";
  constructor() { }

  ngOnInit(): void {
  }

}
