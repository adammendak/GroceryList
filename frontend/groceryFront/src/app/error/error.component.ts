import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html'
})
export class ErrorComponent implements OnInit {

  errorImage: string = 'assets/errorPage.png';
  constructor() { }

  ngOnInit() {
  }

}
