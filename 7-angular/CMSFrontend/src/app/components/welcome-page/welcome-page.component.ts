import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'welcome-page',
  templateUrl: './welcome-page.component.html',
  styleUrls: ['./welcome-page.component.css']
})
export class WelcomePageComponent implements OnInit {

  constructor() { 
    console.log("In the welcome page constructor")
  }

  ngOnInit(): void {
    console.log("In the ngOnInit for the welcome-page")
  }

}
