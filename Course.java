/*Name: Eden Schwartz
ID: 315685461
HW2*/
package HW2_EdenSchwartz;

public class Course<T extends Comparable<T>> implements Comparable<Course<T>> {

	private T idOrName;
	private float avg;
	
	public Course(T idOrName, float avg) {
		this.idOrName = idOrName;
		this.avg = avg;
	}
	
	public T getIdOrName() {
		return idOrName;
	}

	@Override
	public String toString() { 
		return String.format("(" + "%10s" + ", " + "%10s" + ")", idOrName, String.format("%.2f", avg));
	} 

	@Override
	public int compareTo(Course<T> course) {
		int result = this.getIdOrName().compareTo(course.getIdOrName());
		return result;
	}
}
