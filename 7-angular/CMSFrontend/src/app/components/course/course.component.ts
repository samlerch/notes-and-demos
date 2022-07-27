import { Component, Input, OnInit } from '@angular/core';
import { ICourse } from 'src/app/Interfaces/ICourse';

@Component({
  selector: 'course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {

  @Input() courseInputted:ICourse = {
    id:0,
    courseNum:"",
    name:"",
    description:"",
    availableSeats:0
  }

  // We will use the selected varaible to play with ngIf
  selected:boolean = false

  // We'll create a function for us to select a course
  selectCourse():void{
    this.selected = !this.selected;
  }

  constructor() { }

  ngOnInit(): void {
  }

}
