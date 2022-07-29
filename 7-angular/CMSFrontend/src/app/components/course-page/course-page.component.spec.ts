import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { Subject } from 'rxjs';
import { ICourse } from 'src/app/Interfaces/ICourse';
import { CourseService } from 'src/app/services/course.service';
import { NewCourseComponent } from '../new-course/new-course.component';

import { CoursePageComponent } from './course-page.component';

// We need to find a way to mock the Course Service so when we test it we can receive sample data that we can test against

// The way we do this is by creating a mock course service class

class MockCourseService{
    subject:Subject<ICourse[]> = new Subject<ICourse[]>();

    // Before in the actual course service we made calls to the api to populate our courses

    // Here we're going to emulate some methods to make sure they work
    getCourses(){
      return [
        {
          id:0,
          courseNum:"BIO101",
          name:"Intro to Biology",
          decsription:"Learn about life and stuff",
          availableSeats: 12
        }
      ]
    }

    addCourse(course:ICourse){
      return course;
    }
}

describe('CoursePageComponent', () => {
  let component: CoursePageComponent;
  let fixture: ComponentFixture<CoursePageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CoursePageComponent ],
      providers:[{provide:CourseService, useClass: MockCourseService}]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CoursePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });


  // The first thing our component should do is make a call to the CourseService on ngInit
  it('should call the CourseService getCourses on init', ()=>{

    // We're goin to get the serve and spy on it
    let service = fixture.debugElement.injector.get(CourseService);

    // We'll create a spy to watch this service
    let serviceSpy = spyOn(service, 'getCourses').and.callThrough();

    // Since we want to test that this gets call on init
    // We'll use the lifecycle method ngOnInit to verify
    component.ngOnInit();

    // Since we called ngOnInit it should have called the course service and we can check the spy to see if it was
    expect(serviceSpy).toHaveBeenCalled();
  })


  // We'll write one final test to make sure that the addCourse() function gets called when it receives a new course
  it('should call the addCourse() function in CourseService when it receives a course from the new-course component'), () =>{
    // We're goin to get the serve and spy on it
    let service = fixture.debugElement.injector.get(CourseService);

    // We'll create a spy to watch this service
    let serviceSpy = spyOn(service, 'addCourse').and.callThrough();

    // Now we need to emulate actually sending a course from our new coruse component
    const newCourse = fixture.debugElement.query(By.directive(NewCourseComponent));

    // Emit a new course
    newCourse.triggerEventHandler('sendCourse', {
      id:0,
      courseNum:"BIO101",
      name:"Intro to Biology",
      decsription:"Learn about life and stuff",
      availableSeats: 12
    })

    fixture.detectChanges();

    expect(serviceSpy).toHaveBeenCalled();
  }
});
