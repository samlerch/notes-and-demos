import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Subject, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ICourse } from '../Interfaces/ICourse';
import { COURSES } from '../mock-courses';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  // courses:ICourse[] = [
  //   {
  //     courseNum:"MATH101",
  //     name:"Intro to Math",
  //     description: "Learn the basics of math",
  //     availableSeats:21
  //   },
  //   {
  //     courseNum:"READ101",
  //     name:"Intro to Reading",
  //     description: "Learn how to read",
  //     availableSeats:21
  //   },
  //   {
  //     courseNum:"HIST101",
  //     name:"Intro to History",
  //     description: "Learn the wars",
  //     availableSeats:21
  //   },
  //   {
  //     courseNum:"SCI101",
  //     name:"Intro to Science",
  //     description: "Learn to science",
  //     availableSeats:21
  //   }
  // ];

  // getCourses():ICourse[]{
  //   // This is fine if we expect to have a hardcoded list inside our web application that we plan to use
  //   //return this.courses;

  //   // However, if we want to create a dynamic list that maybe updates with some sort of database we'd make some api calls here 
  //   // instead to pull the information directly from the database

  //   // For now though, we'll export this to an external file and pull from there to emulate coming from an external resource.
  //   return COURSES;
  // }

  // addCourse(course:ICourse):ICourse[]{
  //   let courses :ICourse[] = COURSES;
  //   courses.push(course)
  //   return courses;
  // }

  // The use of the external file COURSES should show where we plan to make external calls to some sort of database
  // For us this will be us calling upon our backend to do our work for us.


  courses: ICourse[] = [];


  constructor(private http: HttpClient) { }

  // We have two methods that we need to implement so that everything compiles the way we expect it to
  // We need to create getCourses() and addCourse()

  // Before we saw how to make a request and return an observable, now we'll use a subject
  subject: Subject<ICourse[]> = new Subject<ICourse[]>();

  // Don't forget to add the http client to the constructor of the service

  // Let's add a url
  // url:string = 'http://demoproject-env.eba-gnzwb8nf.us-east-1.elasticbeanstalk.com'

  // We'll actually declare our apiUrl from the environments file

  url: string = environment.apiURL;

  //Get Courses from backend
  getCourses(): void {
    // Recall that to make our http request we'll call upon the http client and then specify our method and what we expect to recieve from the db
    this.http.get<ICourse[]>(`${this.url}/courses`)
      .pipe(
        catchError((e) => {
          return throwError(e)
        })
      ).subscribe((data) => {
        console.log(data);
        this.courses = data
        this.subject.next(this.courses);
      });

  }


  availableSubject: Subject<ICourse[]> = new Subject<ICourse[]>();

  //Get Available Courses from backend
  getAvailableCourses(): void {
    // Recall that to make our http request we'll call upon the http client and then specify our method and what we expect to recieve from the db
    this.http.get<ICourse[]>(`${this.url}/courses/available`)
      .pipe(
        catchError((e) => {
          return throwError(e)
        })
      ).subscribe((data) => {
        console.log(data);
        this.availableSubject.next(data);
      });

  }


  // We're going to create an add course method that works like before but send data to the DB
  addCourse(course:ICourse) {
    // Let's create a couse object to hold this info

    // let course = {
    //   courseId: 0,
    //   courseNum,
    //   name,
    //   description,
    //   availableSeats
    // }

    let headers = {
      headers: new HttpHeaders({
        'Content-Type' : 'application/json'
      })
    };

    // We'll send a post request to hopefully get this to create a new course

    this.http.post<ICourse>(`${this.url}/courses`, JSON.stringify(course), headers)
      .pipe(
        catchError((e) => {
          return throwError(e)
        }))
      .subscribe((data) => {
        this.courses.push(data)
        this.subject.next(this.courses)
      })
  }
}
