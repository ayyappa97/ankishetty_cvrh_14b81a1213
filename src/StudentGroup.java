
import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
        int ln = 0;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
            if(ln == 0)
            	return null;
            return students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
            int i;
            if(students == null)
                throw new IllegalArgumentException();
            for( i = 0;i < this.students.length;++i)
                this.students[i] = null;
            for( i = 0;i < students.length;++i)
                this.students[i] = students[i];
            ln = i;
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
            if(index < 0 || index >= students.length)
		throw new IllegalArgumentException();
                
            return students[index]; 
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
            if(student == null || index < 0 || index >= students.length)
		throw new IllegalArgumentException();
            this.students[index] = student;
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
             if(student == null)
                throw new IllegalArgumentException();
             for(int i = ln;i > 0;--i)
                 students[i] = students[i-1];
             
             students[0] = student;
            ++ln;
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
            if(student == null)
                throw new IllegalArgumentException();
            students[ln] = student;
            ++ln;
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
             if(student == null || index < 0 || index >= students.length)
            	 throw new IllegalArgumentException();
             if(index == 0) addFirst(student);
             if(index == ln) addLast(student);
             for(int i = ln;i > index;++i) {
                 students[i] = students[i-1];
             }
             students[index] = student;
             ++ln;
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
            if( index < 0 || index >= ln)
		throw new IllegalArgumentException();
            if(index == 0){
                for(int i = 1;i < ln;++i) 
                    students[i-1] = students[i];
                --ln;
            }
            if(index == ln-1){
                students[ln-1] = null;
                --ln;
            }
            for(int i = index;i < ln-1;++i) {
                students[i] = students[i+1];
                --ln;
            }
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		 if(student == null)
             throw new IllegalArgumentException();
		 int i = 0,flag = 0;
		 for(i = 0;i < ln;++i) {
			 if((students[i].getId()== student.getId()) && ((students[i].getFullName()).equals(student.getFullName())) && (students[i].getAvgMark()== student.getAvgMark()) && (((students[i].getBirthDate()).compareTo(student.getBirthDate())== 0))) {
				 flag = 1;
				 break;
			 }
		 }
		 if(flag == 1)
			 remove(i);
		 if(flag == 0)
             throw new IllegalArgumentException("Student not exist");
			 
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
            if( index < 0 || index >= ln)
		throw new IllegalArgumentException();
            ln = index+1;
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		if(student == null)
            throw new IllegalArgumentException();
		 int i = 0,flag = 0;
		 for(i = 0;i < ln;++i) {
			 if((students[i].getId()== student.getId()) && ((students[i].getFullName()).equals(student.getFullName())) && (students[i].getAvgMark()== student.getAvgMark()) && (((students[i].getBirthDate()).compareTo(student.getBirthDate())== 0))) {
				 flag = 1;
				 break;
			 }
		 }
		 if(flag == 1)
			 removeFromIndex(i);
		 

	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
             if( index < 0 || index >= ln)
		throw new IllegalArgumentException();
              if(index == 0){
                return;
            }
            if(index == ln-1){
                int i = 0;
                for( i = 0;i < ln-1;++i) students[i] = null;
                students[0] = students[i];
                ln = 1;
                return;
            }
            int k = 0;
            for(int i = index;i < ln;++i) {
                students[k++] = students[i];
               
            }
            ln = k;
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		if(student == null)
            throw new IllegalArgumentException();
		 int i = 0,flag = 0;
		 for(i = 0;i < ln;++i) {
			 if((students[i].getId()== student.getId()) && ((students[i].getFullName()).equals(student.getFullName())) && (students[i].getAvgMark()== student.getAvgMark()) && (((students[i].getBirthDate()).compareTo(student.getBirthDate())== 0))) {
				 flag = 1;
				 break;
			 }
		 }
		 if(flag == 1)
			 removeToIndex(i);
		 

	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		for(int i = 0;i < ln-1;++i) {
			for(int j = 0;j < ln-i-1;++j) {
				if(students[j].getId()> students[j+1].getId()) {
					Student t = students[j];
					students[j] = students[j+1];
					students[j+1] = t;
				}
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		if(date == null)
            throw new IllegalArgumentException();
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation
		if(firstDate == null || lastDate == null)
            throw new IllegalArgumentException();
			
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		if(date == null)
            throw new IllegalArgumentException();
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		if(indexOfStudent == 0)
            throw new IllegalArgumentException();
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		if(student == null)
            throw new IllegalArgumentException();
		int i = 0,flag = 0;
		 for(i = 0;i < ln;++i) {
			 if((students[i].getId()== student.getId()) && ((students[i].getFullName()).equals(student.getFullName())) && (students[i].getAvgMark()== student.getAvgMark()) && (((students[i].getBirthDate()).compareTo(student.getBirthDate())== 0))) {
				 flag = 1;
				 break;
			 }
		 }
		 if(flag == 1)
			return getStudent(i+1);
		 
		 return null;
	}
}
  