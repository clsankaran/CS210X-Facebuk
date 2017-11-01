import java.util.ArrayList;
import java.util.List;

public class PowerSetTester {

	public static void main(String[] args) {

		ArrayList<ArrayList<LivingEntity>> list = makePowerSet(initPeople());
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

	private static ArrayList<ArrayList<LivingEntity>> makePowerSet(ArrayList<LivingEntity> set) {
		ArrayList<ArrayList<LivingEntity>> powerSet = new ArrayList<>();
		int numSubsets = (int) Math.pow(2, set.size());
		for (int i = 0; i < numSubsets; i++) {
			int powerSetIndex = i;
			ArrayList<LivingEntity> subset = new ArrayList<>();
			for (int j = set.size() - 1; j >= 0; j--) {
				if (powerSetIndex >= Math.pow(2, j)) {
					subset.add(set.get(j));
					powerSetIndex -= Math.pow(2, j);
				}
			}
			powerSet.add(subset);
		}
		return powerSet;
	}

}
