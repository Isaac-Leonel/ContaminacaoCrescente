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

@NgModule({
  declarations: [
    AppComponent,
    InputLoginComponent,
    ButtonLoComponent,
    LoginPageComponent,
    CadastroPageComponent,
    DashboardComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
