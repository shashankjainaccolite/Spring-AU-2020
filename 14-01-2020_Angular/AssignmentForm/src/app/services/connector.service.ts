import { Injectable } from '@angular/core';

@Injectable()
export class ConnectorService {
  data = [];
  i = 0;
  set(fname, lname, email, gender) {
    this.data[this.i] = new Array(fname, lname, email, gender);
    this.i++;
  }

  get() {
    return this.data;
  }
  constructor() { }
}
