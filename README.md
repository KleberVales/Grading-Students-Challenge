# 📌 Grading Students Challenge

## 📝 Challenge Description

In the Grading Students challenge, students' grades must be rounded according to specific rules:

1. Any grade below 38 is a failing grade and will not be rounded.
2. If the difference between a grade and the next multiple of 5 is less than 3, the grade is rounded up to that multiple.
3. If the difference is 3 or more, the grade remains unchanged.

## 📥 Input Format

- The first line contains an integer n, representing the number of students.
- Each of the next n lines contains an integer representing a student's grade.

## 📤 Output Format

- n lines, each containing the student's rounded grade.

## ✅ Example

### Input:
```java

4
73
67
38
33

```
### Output:
```java

75
67
40
33

```
## 🔍 Explanation

- 73 → 75 (next multiple of 5 is 75, difference is 2 → round up)
- 67 → 67 (next multiple of 5 is 70, difference is 3 → no rounding)
- 38 → 40 (next multiple of 5 is 40, difference is 2 → round up)
- 33 → 33 (below 38 → no rounding)

## 🚀 Function Signature
```java

List<Integer> gradingStudents(List<Integer> grades)

```
