import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'new-course',
  templateUrl: './new-course.component.html',
  styleUrls: ['./new-course.component.css']
})
export class NewCourseComponent implements OnInit {

  // To send the course data from the new course component to the course page
  // We need to use @Output to create a new event emitter
  @Output() sendCourse = new EventEmitter();

  // We need to declare the variables we want to store the user data into
  courseNum:String ="";
  name:string = "";
  description:string = "";
  availableSeats:number = 0;

  onSubmit():void{
    console.log("Called: ", this.courseNum, this.name, this.description, this.availableSeats)

    const course = {
      id:0,
      courseNum: this.courseNum,
      name:this.name,
      description: this.description,
      availableSeats: this.availableSeats
    }

    this.sendCourse.emit(course);

    this.courseNum = "";
    this.name = "";
    this.description = "";
    this.availableSeats = 0;
  }

  constructor() { }

  ngOnInit(): void {
  }

}
