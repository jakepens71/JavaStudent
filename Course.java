import java.util.ArrayList;


public class Course {


	private String newCourseName;
	private String newInstructor;
	private int newCourseNumber;
	private ArrayList<Student> EnrolledinCourse;


	/**
	 *Constructor for Course. It sets the name, courseNumber, and instructor to variables.
	 *As well as also sets a new array list for the students enrolled in a specific course.
	 *@param name-sets the name to the newCourseName for the course
	 *@param coruseNumber-sets the courseNumber to the newCourseNumber for the course
	 *@param instructor-sets the instructor to the newInstructor for the course
	 */
    public Course(String name, int courseNumber, String instructor)
    {
		newCourseName = name;
		newCourseNumber = courseNumber;
		newInstructor = instructor;
        EnrolledinCourse = new ArrayList<Student>();
    }

	/**
	 *The addStudent method adds a student to the EnrolledinCourse array list
	 *@param Student aStudent-basically adds a student to the array list of students
	 *
	 */
	public void addStudent(Student aStudent)
	{
		EnrolledinCourse.add(aStudent);

	}

	/**
	 *The removeStudent method removes a student from the EnrolledinCourse array List
	 *@param Student aStudent-basically removes a student from the array list
	 *
	 */
	public void removeStudent(Student aStudent)
	{
		 EnrolledinCourse.remove(aStudent);
	}

	/**
	 *The getName Accessor takes the newCourseName (name of the course) and returns it
	 *@param-
	 *
	 */
	public String getName()
	{
		  return newCourseName;
	}


	/**
	 *The getCourseInstructor accessor gets the newInstructor
	 *(name of the instructor associated with that corse) and returns it
	 *@param
	 *
	 */
	public String getCourseInstructor()
	{
		return newInstructor;
	}

	/**
	 *The getCourseNumber accessor gets the newCourseNumber
	 *(number of the course) and returns it
	 *@param
	 */
	public int getCourseNumber()
	{
		return newCourseNumber;
	}


	/**
	 *The ReturnEnrolledStudents accessor gets all the enrolled students and returns them to the user
	 *@param
	 *
	 */
	public String ReturnEnrolledStudents()
	{
		   
			String s = " ";	
		   	for (int i = 0;i<EnrolledinCourse.size();i++)
		   	{
			   //s += EnrolledinCourse.get(i).getStudentName() + " major: " + EnrolledinCourse.get(i).getStudentMajor() + " number: " + EnrolledinCourse.get(i).getStudentNumber();
				s += EnrolledinCourse.get(i).ReturnStudentInfo() + "\n";
		   	}
		   	return s;
	}

	/**
	 *The EnrolledStudentCount method creates a local variable called newEnrolledStudentCount
	 *It sets that local variable to 0 and goes thro the EnrolledInCourse Array for the number of
	 *students enrolled in that course. Each time it goes thro the array it adds 1 to the variable i
	 *and increments newEnrolledStudentCount by one to tell how many students are in that class. It then
	 *returns newEnrolledStudentCount.
	 *@param
	 *
	 */
	public int EnrolledStudentCount()
	{
		int newEnrolledStudentCount = 0;
		for (int i = 0; i<EnrolledinCourse.size(); i++)
		{
			newEnrolledStudentCount++;
		}
		return newEnrolledStudentCount;
	}


	/**
	 *The ReturnCourseInfo accessor returns the name, courseNumber, and instructor of the specified course back
	 *to the user.
	 *@param
	 *
	 */
	public String ReturnCourseInfo()
	{

		String s = "Name: " + newCourseName + "  Number: " + newCourseNumber + " Instructor: " + newInstructor;

		return s;
	}






}