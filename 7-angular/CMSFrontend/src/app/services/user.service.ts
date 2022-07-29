import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { IUser } from '../Interfaces/IUser';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  // Inside of here is where we'll be in charge of making our api calls

  // We'll create a user object to store the current user once logged in
  user:IUser = {
    id:0,
    username: ""
  }

  url:string = environment.apiURL;
  // url:string = "http://demoproject-env.eba-gnzwb8nf.us-east-1.elasticbeanstalk.com"

  // Now we need to create the actual method that will allow us to login
  // Dont forget to add headers to make the right content type
  login(username:string, password:string) : Observable<IUser>{

    let headers = {
      headers: new HttpHeaders({
        'Content-Type' : 'application/json'
      })
    };

    return this.http.post<IUser>(`${this.url}/users/login`, JSON.stringify({username, password}), headers)
    // Now we should also catch the errors with RxJS
    .pipe(catchError((e) => {
      return throwError(e);
    }));

    
  }

  // Before we can make an http call we need to pass in the http client
  constructor(private http:HttpClient) { }
}
