public class Main {
    public static void main(String[] args) {
        Integer[] intArr = {5, 1, 3, 2};
        ArrayUtils.sort(intArr);
        for (int i = 0; i < intArr.length; i++) {
            System.out.print(intArr[i]);
            if (i < intArr.length - 1) System.out.print(" ");
        }
        System.out.println();

        String[] strArr = {"Java", "C++", "Python"};
        ArrayUtils.sort(strArr);
        for (int i = 0; i < strArr.length; i++) {
            System.out.print(strArr[i]);
            if (i < strArr.length - 1) System.out.print(" ");
        }
        System.out.println();

        Student[] students = {
            new Student("An", 3.5),
            new Student("Binh", 2.8),
            new Student("Chi", 3.9)
        };
        ArrayUtils.sort(students);
        for (int i = 0; i < students.length; i++) {
            System.out.print(students[i]);
            if (i < students.length - 1) System.out.print(" ");
        }
        System.out.println();
    }
}
