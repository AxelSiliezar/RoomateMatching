import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import static java.lang.Integer.parseInt;

public class Match {
    public static void main(String[] args)
    {
// MAIN PROGRAM
        Student[] students = new Student[100];
        System.out.print("File: ");
        Scanner keyboard = new Scanner(System.in);
        String fileName = keyboard.next();
        System.out.println();
        inputFile(students, keyboard, fileName);
    }

    private static void inputFile(Student[] students, Scanner keyboard, String fileName) {
        try {
            Scanner infile = new Scanner(new FileReader(fileName));
            int count = 0;
            count = getCount(students, infile, count);
            closeMe(keyboard, infile);
            matchingStudents(students, count);
        }
        catch (NoSuchElementException | FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static void closeMe(Scanner keyboard, Scanner infile) {
        infile.close();
        keyboard.close();
    }

    private static void matchingStudents(Student[] students, int count) {
        for(int i = 0; i < count; i++) {
            Student studentCont = students[i];

            if(!studentCont.getMatched()) {
                Student bestMatchedStudent = null;
                int bestMatchScore = 0;
                for(int j = i + 1; j < count; j++) {
                    Student studentComp = students[j];
                    if(!studentComp.getMatched()) {
                        int currentScore = studentCont.compareStudents(studentComp);
                        if(currentScore > bestMatchScore) {
                            bestMatchedStudent = studentComp;
                            bestMatchScore = currentScore;
                        }
                    }
                }

                switch (bestMatchScore) {
                    case 0 -> System.out.println(studentCont.getName() + " has no matches.");
                    default -> {
                        studentCont.setMatched(true);
                        bestMatchedStudent.setMatched(true);
                        System.out.println(studentCont.getName() + " matches with " + bestMatchedStudent.getName() + " with the score " + bestMatchScore);
                    }
                }
            }
        }
    }

    private static int getCount(Student[] students, Scanner infile, int count) {
        while (infile.hasNextLine() && count < 100)
        {

            String line = infile.nextLine();

            String[] lineTokens = line.split("\t");
            String name = lineTokens[0];
            char gender = lineTokens[1].charAt(0);
            String date = lineTokens[2];

            int quietTime = parseInt(lineTokens[3]);
            int music = parseInt(lineTokens[4]);
            int reading = parseInt(lineTokens[5]);
            int chatting = parseInt(lineTokens[6]);

            String[] dateTokens = date.split("-");
            int month = parseInt(dateTokens[0]);
            int day = parseInt(dateTokens[1]);
            int year = parseInt(dateTokens[2]);

            Date birthdate = new Date(year, month, day);
            Preference pref = new Preference(quietTime, music, reading, chatting);
            Student student = new Student(name, gender, birthdate, pref);

            students[count] = student;
            count++;
        }
        return count;
    }
}
