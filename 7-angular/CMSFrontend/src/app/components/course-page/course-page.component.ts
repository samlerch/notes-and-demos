import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ICourse } from 'src/app/Interfaces/ICourse';
import { CourseService } from 'src/app/services/course.service';

@Component({
  selector: 'course-page',
  templateUrl: './course-page.component.html',
  styleUrls: ['./course-page.component.css']
})
export class CoursePageComponent implements OnInit {

  // courses: ICourse[] = [];
  courses:Observable<ICourse[]> = new Observable<ICourse[]>();

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

  course: ICourse = {
    id: 0,
    courseNum: "",
    name: "",
    description: "",
    availableSeats: 0
  }


  hide: boolean = true;

  showOrHideObject(): void {
    this.hide = !this.hide;
  }

  getCourseFromNewCourse($event: any): void {
    console.log("The sendCourse event that was emitted was found")
    console.log($event);
    this.course = $event;
    // this.courses.push(this.course)
    this.addCourse(this.course)
    console.log(this.courses)
    this.hide = !this.hide
  }

  addCourse(course:ICourse):void{
    this.cs.addCourse(course);
  }

  // We need to tell angular that we want to use the service we made in our component
  // We'll do that with injection
  constructor(private cs: CourseService) { }

  ngOnInit(): void {
    // To initialize our array, we're going to utilize the ngOnInit lifecycle method to grab the courses from our service
    // And then display them
    // this.courses= this.cs.getCourses();

    // Now with the newest version, I'll call the method to get the courses
    // and then pull the value from the subject
    this.cs.getCourses();
    this.courses = this.cs.subject;
  }

}
