import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  username: string = "";
  password: string = '';

  onSubmit(): void {
    console.log("Called submit:", this.username, this.password);

    // Underneath this is where we'll make our direct http request

    this.userService.login(this.username, this.password)
      // Now that we've sent the request we need to subscribe to the data that is returned
      .subscribe((data) => {
        console.log(data)
        this.userService.user = {
          id: data.id,
          username: data.username


        }
        this.username = "";
        this.password = "";

        this.router.navigate(['home'])
        console.log(this.userService.user)
      }, (error) => console.log(error))



  }

  // We need to call upon the user service to allows us to subscribe to the information
  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

}
