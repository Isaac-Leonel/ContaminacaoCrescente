import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InputLoginComponent } from './input-login/input-login.component';
import { ButtonLoComponent } from './button-lo/button-lo.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { HomeComponent } from './home/home.component';
import { CadastroPageComponent } from './cadastro-page/cadastro-page.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    InputLoginComponent,
    ButtonLoComponent,
    LoginPageComponent,
    HomeComponent,
    CadastroPageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
