import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InputLoginComponent } from './input-login/input-login.component';
import { ButtonLoComponent } from './button-lo/button-lo.component';

@NgModule({
  declarations: [
    AppComponent,
    InputLoginComponent,
    ButtonLoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
