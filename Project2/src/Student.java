public class Student {

    private final String name;
    private final char gender;
    private final Date birthDay;
    private final Preference pref;
    private boolean matched;


    public Student(String studName, char studGender, Date studBirthDay, Preference studPref)
    {
        name = studName.trim();
        gender = studGender;
        birthDay = studBirthDay;
        pref = studPref;
        matched = false;
    }


    public String getName() {
        return name;
    }


    public boolean getMatched()
    {
        return matched;
    }


    public void setMatched(Student other)
    {
        setMatched(true);
        other.setMatched(true);
    }

    public void setMatched(boolean sMatched)
    {
        matched = sMatched;
    }

    public int compareStudents(Student student)
    {
        if (gender != student.gender) return 0;

        int Preferences = Math.abs(pref.preferenceCalc(student.pref));
        int AgeDifference = Math.abs(birthDay.prefComparison(student.birthDay));

        int compScore = (40 - Preferences) + (60 - AgeDifference);

        if (compScore < 0) return 0;
        else if (compScore > 100) return 100;
        else return compScore;
    }
}
