public class Person {
    private String strName;
    private int intAge;
    private String strOccupation;

    public Person(String name, int age, String occupation){
        strName = name;
        strOccupation = occupation;
        intAge = age;
    }

    @Override
    public String toString() {
        return "Name:" + strName + " Occupation:" +strOccupation + " Age:" + intAge;
    }
}
