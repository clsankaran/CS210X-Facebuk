import java.util.ArrayList;
import java.util.List;

public class PowerSetTester {

    public static void main(String[] args) {

        ArrayList<String> list = makePowerSet(initPeople());
        System.out.println(list);
        System.out.println(list.size());


    }

    private static ArrayList initPeople() {
        ArrayList list = new ArrayList();
        list.add(new Person("Michelle", new Image("Michelle.png")));
        list.add(new Person("Barack", new Image("Barack.png")));
        list.add(new Person("Kevin", new Image("Kevin.png")));
        list.add(new Person("Ina", new Image("Ina.png")));
        list.add(new Person("Joe", new Image("Joe.png")));
        list.add(new Person("Malia", new Image("Malia.png")));
        return list;
    }

    public static ArrayList<ArrayList<Person>> makePowerSet(ArrayList<Person> set) {
        ArrayList<ArrayList<Person>> powerSet = new ArrayList<>();
        int length = (int) Math.pow(2, set.size());
        for (int i = 0; i < length; i++) {
            powerSet.add(makePowerSetHelper(i, set));
        }
        return powerSet;
    }

    private static ArrayList<Person> makePowerSetHelper(int p, ArrayList<Person> set) {
        ArrayList<Person> subset = new ArrayList<>();
        int pos = 0;
        // i = i / 2 is the same as Math.floor(i / 2), because i is defined as an int
        for (int i = p; i > 0; i = i / 2) {
            if (i == 1) {
                subset.add(set.get(pos));
            }
            pos++;
        }
        return subset;
    }


}

