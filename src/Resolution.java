import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Result {

	public static List<Integer> gradingStudents(List<Integer> grades) {
		List<Integer> roundedGrades = new ArrayList<>();

		for (int grade : grades) {
			if (grade < 38) {
				// No rounding for failing grades
				roundedGrades.add(grade);
			} else {
				// Find the next multiple of 5
				int nextMultipleOf5 = ((grade / 5) + 1) * 5;
				// Round only if the difference is less than 3
				if (nextMultipleOf5 - grade < 3) {
					roundedGrades.add(nextMultipleOf5);
				} else {
					roundedGrades.add(grade);
				}
			}
		}

		return roundedGrades;

	}

}

public class Resolution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		List<Integer> result = Result.gradingStudents(grades);

		bufferedWriter.write(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}
}
