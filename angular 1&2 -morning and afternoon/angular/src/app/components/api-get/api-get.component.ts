import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/services/api/api.service';

@Component({
  selector: 'app-api-get',
  templateUrl: './api-get.component.html',
  styleUrls: ['./api-get.component.css']
})
export class ApiGetComponent implements OnInit {

  constructor(private apiserv:ApiService) {
    this.getApiData();
   }

  ngOnInit() {
    this.apiRecords = [];
  }

  apiRecords = [];

  getApiData(){
    this.apiserv.getRecords().subscribe( (response) =>{
      this.apiRecords = response;
    });
  }

}
