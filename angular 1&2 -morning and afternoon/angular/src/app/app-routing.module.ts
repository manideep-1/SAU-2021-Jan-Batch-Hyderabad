import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { ApiGetComponent } from './components/api-get/api-get.component';
import { CalculatorComponent } from './components/calculator/calculator.component';
import { UserFormComponent } from './components/user-form/user-form.component';

const routes: Routes = [
  { path: '', component: ApiGetComponent},
  { path: 'apidata', component: ApiGetComponent },
  { path: 'calculator', component: CalculatorComponent },
  { path: 'userform', component: UserFormComponent },
  { path: '**', component: CalculatorComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
