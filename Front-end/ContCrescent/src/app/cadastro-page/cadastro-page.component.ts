import {
  Component,
  OnInit
} from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-cadastro-page',
  templateUrl: './cadastro-page.component.html',
  styleUrls: ['./cadastro-page.component.css']
})
export class CadastroPageComponent implements OnInit {



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

  ngOnInit(): void {}

}
