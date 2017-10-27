import java.util.ArrayList;

public class PowerSetTester {

    private Person _barack, _michelle, _kevin, _ina, _joe, _malia;

    public static void main(String[] args) {

        System.out.println("h");
        System.out.println(makePowerSet(initPeople()).toString());
        System.out.println("i");
    }

    public static ArrayList makePowerSet(ArrayList<Person> list) {
        final ArrayList<ArrayList<Person>> powerSet = new ArrayList();

        ArrayList<Person> placeholder = new ArrayList<>();
        for (Person p : list) {
            for (ArrayList<Person> set : powerSet) {
                placeholder.addAll(set);
                placeholder.add(p);
                powerSet.add(placeholder);
            }
            ArrayList<Person> singlePersonList = new ArrayList<>();
            singlePersonList.add(p);
            powerSet.add(singlePersonList);
        }

        return powerSet;
    }

    private static ArrayList initPeople () {
        ArrayList list = new ArrayList();
        list.add(new Person("Michelle", new Image("Michelle.png")));
        list.add(new Person("Barack", new Image("Barack.png")));
        list.add(new Person("Kevin", new Image("Kevin.png")));
        list.add(new Person("Ina", new Image("Ina.png")));
        list.add(new Person("Joe", new Image("Joe.png")));
        list.add(new Person("Malia", new Image("Malia.png")));
        return list;
    }

}

