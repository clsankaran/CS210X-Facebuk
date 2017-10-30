import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;

import java.util.ArrayList;

/**
 * This is a SUBSET of the unit tests with which we will grade your code.
 *
 * Make absolute sure that your code can compile together with this tester!
 * If it does not, you may get a very low grade for your assignment.
 */
public class FacebukPartialTester {
	private Person _barack, _michelle, _kevin, _ina, _joe, _malia;
	private Pet _bo, _sunny;
	private Moment _meAndBarack, _meJoeAndCo;
	private ArrayList _michelleAndBarack, _michelleJoeBoAndMalia;

	@Before
	public void setUp () {
		initPeople();
		initPets();
		initGroups();
		initPossessions();
		initMoments();
	}

	private void initPeople () {
		_michelle = new Person("Michelle", new Image("Michelle.png"));
		_barack = new Person("Barack", new Image("Barack.png"));
		_kevin = new Person("Kevin", new Image("Kevin.png"));
		_ina = new Person("Ina", new Image("Ina.png"));
		_joe = new Person("Joe", new Image("Joe.png"));
		_malia = new Person("Malia", new Image("Malia.png"));
	}

	private void initPets () {
		_bo = new Pet("Bo", new Image("Bo.png"));
		_sunny = new Pet("Sunny", new Image("Sunny.png"));

		_bo.setOwner(_barack);
		_sunny.setOwner(_michelle);
	}

	private void initGroups () {
		// Kevin, Barack, and Ina
		final ArrayList michelleFriends = new ArrayList();
		michelleFriends.add(_kevin);
		michelleFriends.add(_barack);
		michelleFriends.add(_ina);

		// Michelle and Barack
		_michelleAndBarack = new ArrayList();
		_michelleAndBarack.add(_michelle);
		_michelleAndBarack.add(_barack);

		// Michelle, Joe, Bo, and Malia
		_michelleJoeBoAndMalia = new ArrayList();
		_michelleJoeBoAndMalia.add(_michelle);
		_michelleJoeBoAndMalia.add(_joe);
		_michelleJoeBoAndMalia.add(_bo);
		_michelleJoeBoAndMalia.add(_malia);

		// Malia and Sunny
		final ArrayList maliaAndSunny = new ArrayList();
		maliaAndSunny.add(_malia);
		maliaAndSunny.add(_sunny);

		// Malia and Bo
		final ArrayList maliaAndBo = new ArrayList();
		maliaAndBo.add(_malia);
		maliaAndBo.add(_bo);

		// Michelle
		final ArrayList michelleList = new ArrayList();
		michelleList.add(_michelle);

		// Bo
		final ArrayList boList = new ArrayList();
		boList.add(_bo);

		// Set people's friend lists
		_michelle.setFriends(michelleFriends);
		_malia.setFriends(boList);
		_sunny.setFriends(boList);
		_barack.setFriends(michelleList);
		_kevin.setFriends(michelleList);
		_ina.setFriends(michelleList);

		// Finish configuring pets
		_bo.setFriends(maliaAndSunny);
		_sunny.setFriends(maliaAndBo);
		final ArrayList boAndSunny = new ArrayList();
		boAndSunny.add(_bo);
		boAndSunny.add(_sunny);
		_michelle.setPets(boAndSunny);
	}

	private void initPossessions () {
		final Possession boxingBag = new Possession("BoxingBag", new Image("BoxingBag.png"), 20.0f);
		boxingBag.setOwner(_michelle);
		final ArrayList michellePossessions = new ArrayList();
		michellePossessions.add(boxingBag);
		_michelle.setPossessions(michellePossessions);
	}

	private void initMoments () {
		// Smiles
		final ArrayList michelleAndBarackSmiles = new ArrayList();
		michelleAndBarackSmiles.add(0.25f);
		michelleAndBarackSmiles.add(0.75f);

		final ArrayList michelleJoeBoAndMaliaSmiles = new ArrayList();
		michelleJoeBoAndMaliaSmiles.add(0.2f);
		michelleJoeBoAndMaliaSmiles.add(0.3f);
		michelleJoeBoAndMaliaSmiles.add(0.4f);
		michelleJoeBoAndMaliaSmiles.add(0.5f);

		// Moments
		_meAndBarack = new Moment("Me & Barack", new Image("MeAndBarack.png"), _michelleAndBarack, michelleAndBarackSmiles);
		_meJoeAndCo = new Moment("Me, Joe & co.", new Image("MeJoeAndCo.png"), _michelleJoeBoAndMalia, michelleJoeBoAndMaliaSmiles);

		final ArrayList michelleMoments = new ArrayList();
		michelleMoments.add(_meAndBarack);
		michelleMoments.add(_meJoeAndCo);
		_michelle.setMoments(michelleMoments);

		final ArrayList barackMoments = new ArrayList();
		barackMoments.add(_meAndBarack);
		_barack.setMoments(barackMoments);

		final ArrayList joeMoments = new ArrayList();
		joeMoments.add(_meJoeAndCo);
		_joe.setMoments(joeMoments);

		final ArrayList maliaMoments = new ArrayList();
		maliaMoments.add(_meJoeAndCo);
		_malia.setMoments(maliaMoments);

		final ArrayList boMoments = new ArrayList();
		boMoments.add(_meJoeAndCo);
		_bo.setMoments(boMoments);
	}

	@org.junit.Test
	public void testEquals () {
		assertEquals(_michelle, new Person("Michelle", new Image("Michelle.png")));
		assertEquals(_michelle, new Person("Michelle", new Image("Michelle2.png")));
		assertNotEquals(_michelle, _barack);
	}

	@org.junit.Test
	public void testFindBestMoment () {
		assertEquals(_michelle.getOverallHappiestMoment(), _meAndBarack);

		assertEquals(_joe.getOverallHappiestMoment(), _meJoeAndCo);

		//Making new people and moments for test cases
		final Pet boTest = new Pet("Bo", new Image("Bo.png"));
		final Pet sunnyTest = new Pet("Sunny", new Image("Sunny.png"));
		final Person maliaTest = new Person("Malia", new Image("Malia.png"));

		final ArrayList maliaSunnyAndBoList = new ArrayList();
		maliaSunnyAndBoList.add(maliaTest);
		maliaSunnyAndBoList.add(sunnyTest);
		maliaSunnyAndBoList.add(boTest);

		final ArrayList smiles = new ArrayList();
		smiles.add(0.2f);
		smiles.add(0.3f);
		smiles.add(0.4f);
		smiles.add(0.5f);

		final Moment maliaSunnyAndBo =
				new Moment("Malia Sunny and Bo", new Image("MaliaSunnyAndBo.png"), maliaSunnyAndBoList, smiles);

		final ArrayList moments = new ArrayList();
		moments.add(maliaSunnyAndBo);
		maliaTest.setMoments(moments);
		sunnyTest.setMoments(moments);
		boTest.setMoments(moments);

		assertEquals(boTest.getOverallHappiestMoment(), maliaSunnyAndBo); // typical case


		assertEquals(_kevin.getOverallHappiestMoment(), null); // no moments

	}

	@org.junit.Test
	public void testGetFriendWithWhomIAmHappiest () {
		assertEquals(_michelle.getFriendWithWhomIAmHappiest(), _barack);
		assertEquals(_barack.getFriendWithWhomIAmHappiest(), _michelle);
		assertEquals(_bo.getFriendWithWhomIAmHappiest(), _malia);

		assertEquals(_joe.getFriendWithWhomIAmHappiest(), null);
		assertEquals(_malia.getFriendWithWhomIAmHappiest(), _bo);
		assertEquals(_kevin.getFriendWithWhomIAmHappiest(), null); // no moments
		assertEquals(_ina.getFriendWithWhomIAmHappiest(), null); // no moments
	}


    @org.junit.Test
    public void testIsClique () {
	    ArrayList<LivingEntity> set = new ArrayList();

	    // stub object
	    final LivingEntity obj = new LivingEntity("", new Image(""));

	    // Two mutual friends
	    set = new ArrayList<>();
	    set.add(_barack);
	    set.add(_michelle);
        assertEquals(obj.isClique(set), true);

        // Not a clique
        set = new ArrayList<>();
        set.add(_michelle);
        set.add(_kevin);
        set.add(_barack);
        assertEquals(obj.isClique(set), false);

        // Two mutual friends
        set = new ArrayList<>();
        set.add(_michelle);
        set.add(_kevin);
        assertEquals(obj.isClique(set), true);

        // Person and Pet
        set = new ArrayList<>();
        set.add(_bo);
        set.add(_malia);
        assertEquals(obj.isClique(set), true);

		// Not a clique
		set = new ArrayList<>();
		set.add(_malia);
		set.add(_bo);
		set.add(_sunny);
		assertEquals(obj.isClique(set), false);


    }

    @org.junit.Test
    public void testFindMaximumCliqueOfFriends () {

	    // Max clique is of size 1
		ArrayList<LivingEntity> result = new ArrayList<>();
		result.add(_michelle.getFriends().get(_michelle.getFriends().size() - 1));
		// add the last of the list of friends,
		// michelle has 3 cliques of the same size (1), so the last one is returned
		assertEquals(_michelle.findMaximumCliqueOfFriends(), result);


		// Max clique is of size 1
	    result = new ArrayList<>();
	    result.add(_malia.getFriends().get(_malia.getFriends().size() - 1));

		assertEquals(_malia.findMaximumCliqueOfFriends(), result);

		// Joe has no friends :(
		result = new ArrayList<>();
		assertEquals(_joe.findMaximumCliqueOfFriends(), result);


		// Setting up a three person clique
		final Pet boTest = new Pet("Bo", new Image("Bo.png"));
		final Pet sunnyTest = new Pet("Sunny", new Image("Sunny.png"));
		final Person maliaTest = new Person("Malia", new Image("Malia.png"));

		final ArrayList<LivingEntity> boTestFriends = new ArrayList<>();
		boTestFriends.add(sunnyTest);
		boTestFriends.add(maliaTest);

		boTest.setFriends(boTestFriends);

		final ArrayList<LivingEntity> sunnyTestFriends = new ArrayList<>();
		sunnyTestFriends.add(boTest);
		sunnyTestFriends.add(maliaTest);

		sunnyTest.setFriends(sunnyTestFriends);

		final ArrayList<LivingEntity> maliaTestFriends = new ArrayList<>();
		maliaTestFriends.add(sunnyTest);
		maliaTestFriends.add(boTest);

		maliaTest.setFriends(maliaTestFriends);

		result = new ArrayList<>();
		result.add(boTest);
		result.add(sunnyTest);

		assertEquals(maliaTest.findMaximumCliqueOfFriends(), result);
    }

}
