let courses = [
    {
        course: 'MATH101',
        name: 'Intro to Math',
        description: 'Learn the basics of math'
    },
    {
        course: 'READ110',
        name: 'Intro to Reading',
        description: 'Learn to read'
    },
    {
        course: 'SCI101',
        name: 'Intro to Science',
        description: 'Learn to science'
    },
    {
        course: 'HIST101',
        name: 'Intro to History',
        description: 'Learn the wars'
    },
    {
        course: 'MATH101',
        name: 'Intro to Math',
        description: 'Learn the basics of math'
    }
]

// We can grab the element of the div we want to store the courses in
let courseContainer = document.getElementById('courses-container');
console.log(courseContainer);

// We want to dynamically add in our courses to the webpage,
// So we'll loop through the list of courses

// For of loop for array
for(course of courses){
    // For each course in the course list, create a new div
    let cDiv = document.createElement('div');
    console.log(cDiv);

    // Populate information by setting the innerHTML
    cDiv.innerHTML = `
        <h2>${course.course}</h2>
        <h3>${course.name}</h3>
        <p>${course.description}</p>
    `;

    console.log(cDiv);

    cDiv.setAttribute('class', 'course')

    // Let's append the courses to the course container
    courseContainer.append(cDiv);
}