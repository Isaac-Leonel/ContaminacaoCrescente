import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-novo-foco',
  templateUrl: './novo-foco.component.html',
  styleUrls: ['./novo-foco.component.css']
})
export class NovoFocoComponent implements OnInit {

  causas: String[] = ["Teste","Teste2","Teste3"]  

  profileForm = this.fb.group({
    nome: ['', Validators.required],
    email: ['', Validators.required],
    dataN: ['', Validators.required],
    CPF: ['', Validators.required],
    senha: ['', Validators.required],
  });

  onSubmit() {
    if(this.profileForm.invalid){
      alert("Gentileza preencher todo o formulario!")
    }else{
      console.log(this.profileForm.value);
    }
  }


  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
  }

}
