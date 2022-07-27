import { Component, OnInit } from '@angular/core';
import { ICourse } from 'src/app/Interfaces/ICourse';

@Component({
  selector: 'course-page',
  templateUrl: './course-page.component.html',
  styleUrls: ['./course-page.component.css']
})
export class CoursePageComponent implements OnInit {

  courses:ICourse[] = [
    {
      courseNum:"MATH101",
      name:"Intro to Math",
      description: "Learn the basics of math",
      availableSeats:21
    },
    {
      courseNum:"READ101",
      name:"Intro to Reading",
      description: "Learn how to read",
      availableSeats:21
    },
    {
      courseNum:"HIST101",
      name:"Intro to History",
      description: "Learn the wars",
      availableSeats:21
    },
    {
      courseNum:"SCI101",
      name:"Intro to Science",
      description: "Learn to science",
      availableSeats:21
    }
  ];

  course:ICourse = {
    id:0,
    courseNum:"",
    name:"",
    description:"",
    availableSeats:0
  }


  hide:boolean = true;

  showOrHideObject():void{
    this.hide =!this.hide;
  }

  getCourseFromNewCourse($event: any):void{
    console.log("The sendCourse event that was emitted was found")
    console.log($event);
    this.course = $event;
    this.courses.push(this.course)
    console.log(this.courses)
    this.hide = !this.hide
  }

  constructor() { }

  ngOnInit(): void {
  }

}
