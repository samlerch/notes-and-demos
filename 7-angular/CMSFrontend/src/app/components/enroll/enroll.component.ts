import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ICourse } from 'src/app/Interfaces/ICourse';
import { CourseService } from 'src/app/services/course.service';

@Component({
  selector: 'app-enroll',
  templateUrl: './enroll.component.html',
  styleUrls: ['./enroll.component.css']
})
export class EnrollComponent implements OnInit {

  courses:Observable<ICourse[]> = new Observable<ICourse[]>();

  constructor(private cs:CourseService) { }

  ngOnInit(): void {

    this.cs.getAvailableCourses();
    this.courses = this.cs.availableSubject;
    
  }

}
