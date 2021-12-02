import { ContServiceService } from './cont-service.service';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InputLoginComponent } from './input-login/input-login.component';
import { ButtonLoComponent } from './button-lo/button-lo.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { CadastroPageComponent } from './cadastro-page/cadastro-page.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DashboardComponent } from './dashboard/dashboard.component';
import { NovoFocoComponent } from './novo-foco/novo-foco.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    InputLoginComponent,
    ButtonLoComponent,
    LoginPageComponent,
    CadastroPageComponent,
    DashboardComponent,
    NovoFocoComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [HttpClientModule, ContServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
