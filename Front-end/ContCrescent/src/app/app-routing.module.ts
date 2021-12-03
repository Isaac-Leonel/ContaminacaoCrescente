import { RelatorioComponent } from './relatorio/relatorio.component';
import { NovoFocoComponent } from './novo-foco/novo-foco.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CadastroPageComponent } from './cadastro-page/cadastro-page.component';
import { ModuleWithProviders, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginPageComponent } from './login-page/login-page.component';

const routes: Routes = [
  { path: '', component: LoginPageComponent},
  { path: 'cadastro', component: CadastroPageComponent},
  { path: 'dashboard', component: DashboardComponent},
  { path: 'novofoco', component: NovoFocoComponent},
  { path: 'relatorio', component: RelatorioComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
