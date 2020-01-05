/*Name: Eden Schwartz
ID: 315685461
HW2*/

package HW2_EdenSchwartz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static <E> void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Please enter how many courses: ");
		int numOfCources = scanner.nextInt();

		System.out.println("Please press 1 to insert the courses by names, 2 by id: ");
		int input = scanner.nextInt();
		scanner.nextLine(); // clean buffer

		ArrayList<Course<?>> courcesArrayList = insert(numOfCources, input, scanner);

		System.out.println("All courses in ArrayList: ");
		print(courcesArrayList);

		System.out.println("All courses in 'regular' array: ");
		Course<?>[] courcesArray = fromArrayListToArray(courcesArrayList);
		print(courcesArray);

		System.out.println("The 'regular' array of courses, after sorting with Arrays.sort: ");
		Arrays.sort(courcesArray);
		print(courcesArray);

		System.out.println("The 'regular' array of courses, after my sorting method: ");
		bubbleSort(courcesArray);
		print(courcesArray);

		scanner.close();
	}

    private static <T extends Comparable<T>> void bubbleSort(T[] values) {
        int length = values.length;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (values[j + 1].compareTo(values[j]) < 0) {
                	//swap
                    T temp = values[i];
                    values[i] = values[i+1];
                    values[i+1] = temp;
                }
            }
        }
    }

	private static <T> void print(T[] array) {
		for (T t : array) {
			System.out.println(t);
		}
		System.out.println();
	}

	private static <T> void print(ArrayList<T> courcesArray) {
		for (T course : courcesArray) {
			System.out.println(course);
		}
		System.out.println();
	}
	
	private static <E> Course<?>[] fromArrayListToArray(ArrayList<Course<?>> courcesArray) {
		Course<?>[] array = new Course[courcesArray.size()];
		for (int index = 0; index < courcesArray.size(); index++) {
			array[index] = courcesArray.get(index);
		}
		return array;
	}

	private static ArrayList<Course<?>> insert(int numOfCources, int input, Scanner scanner) {

		ArrayList<Course<?>> courcesArray = new ArrayList<>();

		if (input == 1) {
			for (int i = 0; i < numOfCources; i++) {

				System.out.println("Please enter name: ");
				String name = scanner.nextLine();
				System.out.println("Please enter avg: ");
				float avg = scanner.nextFloat();

				Course<String> newCourse = new Course<>(name, avg);
				courcesArray.add(newCourse);
				scanner.nextLine();
			}
		} else {
			for (int i = 0; i < numOfCources; i++) {

				System.out.println("Please enter id: ");
				int id = scanner.nextInt();
				System.out.println("Please enter avg: ");
				float avg = scanner.nextFloat();

				Course<Integer> newCourse = new Course<>(id, avg);
				courcesArray.add(newCourse);
				scanner.nextLine();
			}
		}
		return courcesArray;
	}
}
