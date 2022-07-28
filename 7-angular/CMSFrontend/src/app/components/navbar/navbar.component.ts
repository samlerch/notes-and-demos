import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  navigateLogin():void{
    // Inside of here we'll set up some navigation to transport us to the login page
    this.router.navigate(['login']);
  }

  // I need to get a router instance so I'll get it in the constructor
  constructor(private router:Router) { 
    console.log("In the constructor of the navbar")
  }

  ngOnInit(): void {
    console.log("In the ngOnInit of the navbar")
  }

}
