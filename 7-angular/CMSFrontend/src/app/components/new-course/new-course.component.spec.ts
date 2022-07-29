import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';

import { NewCourseComponent } from './new-course.component';

describe('NewCourseComponent', () => {
  let component: NewCourseComponent;
  let fixture: ComponentFixture<NewCourseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewCourseComponent ],
      imports: [FormsModule]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewCourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  // If we wanted to test that the new course EMITS a new course event containing the right info we'd need to import the correct modules

  it('should emit a new course when the form is submitted', ()=>{
    
    // Set the fields inside the forms
    component.courseNum = 'BIO101';
    component.name = 'Intro to Biology';
    component.description = 'Learn about life and stuff'
    component.availableSeats = 12;


    // We're going to spy on the event emitter that we set up in the new course component
    spyOn(component.sendCourse, 'emit')


    // Let's get our submit button from the HTML and press it
    // Getting our button
    const button = fixture.nativeElement.querySelector('button');
    // Clicking the button
    button.dispatchEvent( new Event('click'));

    fixture.detectChanges();

    expect(component.sendCourse.emit).toHaveBeenCalledWith({
      id:0,
      courseNum: 'BIO101',
      name:'Intro to Biology',
      description: 'Learn about life and stuff',
      availableSeats: 12
    })
  })
});
