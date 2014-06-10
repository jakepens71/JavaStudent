import java.util.ArrayList;


public class School {

	//creates a new array list
	private ArrayList<Course> courses;
	private ArrayList<Student> students;

	/**
	 *Creates a new School for the Array Lists
	 */
    public School()
    {
		students = new ArrayList<Student>();
		courses = new ArrayList<Course>();

    }

	/**
	 *The addCourse method takes the name, courseNumber, and instructor that the user
	 *enters in and then adds them to the courses array.
	 *@param name-is the name of the course that the user enters
	 *@param courseNumber is the number of the course that the user enters
	 *@param instructor is the name of the instructor that the user enters
	 *
	 */
    public void addCourse(String name, int courseNumber, String instructor)
    {
    	  courses.add(new Course(name,courseNumber,instructor));

    }

    /**
     *The addStudents method takes the name, studentID, and student major that
     *the user enters and adds them to the array list of students.
     *@param name-is the name of the student that the user enters
     *@param studentID-is the number of the student ID that the user enters
     *@param major-is the name of the major of the student that the user enters
     *
     */
    public void addStudents(String name, int studentID, String major, double QPA)
    {
    	students.add(new Student(name,studentID,major, QPA));

    }

    /**
     *The listCourses accessor uses a for loop to go through the courses array
     *it then returns a string called courseList which contains the information of the course
     *that the user entered.
     *@param
     *
     */
    public String listCourses()
    {
    	String courseList = "";
    	for (int i=0;i<courses.size();i++)
    	{
    	courseList += (courses.get(i).ReturnCourseInfo() + "\n");
    	}

    	return courseList;
    }

	/**
	 *The listStudents accessor takes a empty string called studentList and then goes through
	 *the array of students. It then returns all the information of thoughs students to the user
	 *@param
	 *
	 */
    public String listStudents()
    {
    	String studentList = "";
    	for (int i=0;i<students.size();i++)
    	{
    	studentList += (students.get(i).ReturnStudentInfo() + "\n");
    	}

    	return studentList;
    }
    
    
    public String getExactStudent(String name)
    {
    	String studentInfo = " ";
    	for (int i = 0;i<students.size();i++)
    	{
    		if(students.get(i).getStudentName().equals(name))
    		{
    			studentInfo = students.get(i).ReturnStudentInfo();
    		}
    	}
    	return studentInfo;
    }
    


	/**
	 *The studentCount method  creates a local variable called newStudentCount and sets it to zero
	 *It then uses a for loop with another local variable i (also set to zero.) i is used to go through
	 *the array of students. As i goes through the array the variable newStudentCount is being incremented
	 *by one. It then returns the newStudentCount to show how many students are enrolled in the school.
	 *@param
	 *
	 */
	public int studentCount()
	{
		int newStudentCount = 0;
		for (int i = 0; i<students.size(); i++)
		{
			newStudentCount++;
		}
		return newStudentCount;
	}



	/**
	 *removeCourse removes a specific course that the user types in
	 *@param courseName is the course name the user types in
	 */
	public void removeCourse(int courseNumber)
	{

		for (int i=0;i<courses.size();i++)
  		{
    		if (courses.get(i).getCourseNumber() == courseNumber)
			{
				courses.remove(i);
			}
		}
	}

	/**
	 *The removestudent method uses a for loop to go through the array list of
	 *students. It uses the studentNumber to find a specific student in the array
	 *and when it finds it it removes that student from the Array List
	 *@param studentNumber-Takes the studentNumber that the user enters to find that specific number in the array
	 *
	 */
	public void removestudent(int studentNumber)
	{

		for (int i=0;i<students.size();i++)
  		{
    		if (students.get(i).getStudentNumber() == studentNumber)
			{
				students.remove(i);
			}
			
		}
	}

	/**
	 *The addStudentToClass method takes the StudentNumber and CourseNumber that the user
	 *enters, and then uses a for loop to search through the array of students till it finds a match
	 *for the exact studentNumber the user entered. Once it finds that exact student, it sets that studentindex
	 *to that position in the array, and then it uses another for loop to search through the courses array for the
	 *exact CourseNumber the user entered. Once it finds the CourseNumber it adds that specific student to the class.
	 *@param StudentNumber-The number the user enters to represent a student
	 *@param CourseNumber-The number the user enters to represent a course
	 *
	 */
    public void addStudentToClass(int StudentNumber, int CourseNumber)
    {
    	int studentindex = -1;

		for (int i=0;i<students.size();i++)
  		{
    		if (students.get(i).getStudentNumber() == StudentNumber)
			{
			  studentindex = i;
			}
		}

		for (int i=0;i<courses.size();i++)
  		{
    		if (courses.get(i).getCourseNumber() == CourseNumber)
			{
				courses.get(i).addStudent(students.get(studentindex));
			}
		}
    }

	/**
	 *The removeStudentFromClass method creates a local variable called studentindex and sets it to negative 1.
	 *It then uses a for loop with the local veriable i which is set to zero to go through the array list of students.
	 *There is an if statement inside the for loop which checks the position of i in the array of students, and checks to
	 *see if that student number is equal to the student number the user typed in.
	 *There is another for loop which goes through the list of courses to check and see if that course number the user
	 *entered matches a course in the arry list of courses. If it does match it then removes the correct student from the
	 *correct course.
	 *@param StudentNumber-The student number the user types in to specify which student the user wanted
	 *@param CourseNumber-The course number the user types in to specificy which course the user wanted
	 *
	 */
    public void removeStudentFromClass(int StudentNumber, int CourseNumber)
    {
    	int studentindex = -1;

    	for (int i =0; i<students.size(); i++)
    	{
    		if (students.get(i).getStudentNumber() == StudentNumber)
    		{
    			studentindex = i;
    		}
    	}

    	for (int i = 0; i<courses.size(); i++)
    	{
    		if (courses.get(i).getCourseNumber() == CourseNumber)
    		{
    			courses.get(i).removeStudent(students.get(i));
    		}
    	}
    }

	/**
	 *The Displayroster accessor uses a for loop to go through the array of courses to find the
	 *CourseNumber that the user entered. Once it finds that CourseNumber it displays the students
	 *in that specific course. It then returns that information back to the user
	 *@param CourseNumber-The number the user enters to search through the array for a specific course
	 *
	 *
	 */
	public String Displayroster(int CourseNumber)
	{
		String studentRoster = "";
		for (int i=0;i<courses.size();i++)
  		{
    		if (courses.get(i).getCourseNumber() == CourseNumber)
			{
			 	studentRoster = (courses.get(i).ReturnEnrolledStudents());
			 //	studentRoster = (students.get(i).ReturnStudentInfo());
			}
			return studentRoster;
		}
		return null;
	}

	/**
	 *The TotalStudentCountRoster method creates a local variable total of integer type and sets it to zero.
	 *It then uses a for loop with the variable i (set to zero) to progress through the array of corses. Total
	 *is then used with the position of i in the array and the EnrolledStudentCount method to get the total
	 *number of students in that class. It then returns the total to the user.
	 *@param
	 *
	 *
	 */
	public int TotalStudentCountRoster()
	{
		int total = 0;
		for (int i = 0; i<courses.size(); i++)
		{
			total += (courses.get(i).EnrolledStudentCount());
		}
		return total;
	}



}