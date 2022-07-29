import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { UserService } from '../services/user.service';

@Injectable({
  providedIn: 'root'
})
export class EnrollGuard implements CanActivate {
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    // return true;

    // This is where we'll do some amount of logic for validation
    // If this returns true, user is allowed to activate the routes.
    // If this is false, the user will not be allowed to access the route

    // Let's create a simple if statement to check and see whether the user id is 0
    // If the user id is 0 nobody is logged in but otherwise we can allow access

    // This means nobody is logged in
    if (this.us.user.id === 0){
      this.router.navigate(['login'])
      return false;
    } else{
      return true;
    }

  }

  constructor(private us:UserService, private router:Router){

  }
  
}
