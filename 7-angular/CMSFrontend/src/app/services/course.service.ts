import { Injectable } from '@angular/core';
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

  getCourses():ICourse[]{
    // This is fine if we expect to have a hardcoded list inside our web application that we plan to use
    //return this.courses;

    // However, if we want to create a dynamic list that maybe updates with some sort of database we'd make some api calls here 
    // instead to pull the information directly from the database

    // For now though, we'll export this to an external file and pull from there to emulate coming from an external resource.
    return COURSES;
  }

  addCourse(course:ICourse):ICourse[]{
    let courses :ICourse[] = COURSES;
    courses.push(course)
    return courses;
  }

  // The use of the external file COURSES should show where we plan to make external calls to some sort of database
  // For us this will be us calling upon our backend to do our work for us.

  constructor() { }
}
