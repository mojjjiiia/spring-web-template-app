import { Injectable } from '@angular/core';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-spinner',
  templateUrl: './spinner.component.html',
  styleUrls: ['./spinner.component.css']
})
export class SpinnerComponent implements OnInit {
  static LOCK_APP: boolean = false;

  getState() {
    return SpinnerComponent.LOCK_APP;
  }

  constructor() { }

  ngOnInit(): void {
  }

}
