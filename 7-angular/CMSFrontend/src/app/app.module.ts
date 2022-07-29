import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'

import { AppComponent } from './app.component';
import { WelcomePageComponent } from './components/welcome-page/welcome-page.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CoursePageComponent } from './components/course-page/course-page.component';
import { NewCourseComponent } from './components/new-course/new-course.component';
import { FormsModule } from '@angular/forms';
import { CourseComponent } from './components/course/course.component';
import { DescriptionPipe } from './pipes/description.pipe';
import { AppRoutingModule } from './app-routing.module';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { EnrollComponent } from './components/enroll/enroll.component';



@NgModule({
  declarations: [
    AppComponent,
    WelcomePageComponent,
    NavbarComponent,
    CoursePageComponent,
    NewCourseComponent,
    CourseComponent,
    DescriptionPipe,
    LoginPageComponent,
    EnrollComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
