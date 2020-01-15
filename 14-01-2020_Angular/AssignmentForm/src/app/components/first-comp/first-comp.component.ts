import { ConnectorService } from './../../services/connector.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-first-comp',
  templateUrl: './first-comp.component.html',
  // styleUrls: ['./first-comp.component.css']
})
export class FirstCompComponent implements OnInit {

  constructor(public connector: ConnectorService) { }

  regForm = new FormGroup({
    fname : new FormControl(''),
    lname : new FormControl(''),
    email : new FormControl(''),
    gender : new FormControl('')
  });

  ngOnInit() {
  }

  send() {
    this.connector.set(this.regForm.value.fname, this.regForm.value.lname, this.regForm.value.email, this.regForm.value.gender);
    console.log('Form has been submitted');
    this.regForm.reset();
  }

}
