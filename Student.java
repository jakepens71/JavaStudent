

public class Student {

    // Define Student Information To Capture
	private String newStudent;
	private int newStudentNumber;
	private String newStudentMajor;
	private double newStudentQPA;

	/**
	 *The constructor for Student that initalizes the newStudent, newStudentNumber, newStudentMajor
	 *@param studentName is the name that the user enters for the student name and assigns it to newStudent
	 *@param studentNumber is the number that the user enters for the student and assigns it to newStudentNumber
	 *@param studentMajor is the name of the major that the user enters for the student and assigns it to newStudentMajor
	 *
	 */
    public Student(String studentName, int studentNumber, String studentMajor, double QPA)
    {
		newStudent = studentName;
		newStudentNumber = studentNumber;
		newStudentMajor = studentMajor;
		newStudentQPA = QPA;
    }

     /**
     *The getStudentName is an accessor which returns the newStudent (name assigned to student)
     *@param
     *
     */
    public String getStudentName()
    {
    	return newStudent;
    }

 	 /**
     *The getStudentMajor is an accessor which returns the major of the student
     *@param
     *
     */
    public String getStudentMajor()
    {
    	return newStudentMajor;
    }

	/**
	 *The getStudentNumber accessor returns the student number to the user
	 *@param
	 *
	 */
    public int getStudentNumber()
    {
    	return newStudentNumber;
    }

	/**
	 *The ReturnStudentInfo accessor sets the String s to the name number and major of the student
	 *and then returns it to the user
	 *@param
	 *
	 */
	public String ReturnStudentInfo()
	{

		String s = "Name: " + newStudent + "  Number: " + newStudentNumber + " Major: " + newStudentMajor;

		return s;
	}



}