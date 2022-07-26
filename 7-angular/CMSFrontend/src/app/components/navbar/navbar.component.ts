import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor() { 
    console.log("In the constructor of the navbar")
  }

  ngOnInit(): void {
    console.log("In the ngOnInit of the navbar")
  }

}
