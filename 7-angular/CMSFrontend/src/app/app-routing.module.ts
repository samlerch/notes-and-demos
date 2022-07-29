import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CoursePageComponent } from './components/course-page/course-page.component';
import { EnrollComponent } from './components/enroll/enroll.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { WelcomePageComponent } from './components/welcome-page/welcome-page.component';
import { EnrollGuard } from './guards/enroll.guard';

const routes: Routes = [
    {path:'', redirectTo: "/home", pathMatch:'full'},
    {path:'home', component:WelcomePageComponent},
    {path:'courses', component:CoursePageComponent},
    {path:'login', component:LoginPageComponent},
    {path:'enroll',component:EnrollComponent, canActivate:[EnrollGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }