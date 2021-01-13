import { customdate } from './components/user-form/customdate.pipe';
import { CommonModule } from '@angular/common';
import { CalculatorComponent } from './components/calculator/calculator.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserFormComponent } from './components/user-form/user-form.component';
import { ApiGetComponent } from './components/api-get/api-get.component';
// import { MybootstrapModule } from './modules/mybootstrap/mybootstrap.module';
import { HttpClientModule } from '@angular/common/http';
import { NavbarComponent } from './components/navbar/navbar/navbar.component';
@NgModule({
  declarations: [
    AppComponent,
    CalculatorComponent,
    UserFormComponent,
    ApiGetComponent,
    customdate,
    NavbarComponent   
  ],
  imports: [
    AppRoutingModule,
    CommonModule,
    BrowserModule,
    // MybootstrapModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }