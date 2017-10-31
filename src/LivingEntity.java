import java.util.ArrayList;
public class LivingEntity extends Item{

    // instance variables
    private ArrayList<LivingEntity> _friends;
    private ArrayList<Moment> _moments;

    /**
     * Constructor that specifies the name and image.
     * @param name the name that the instance variable _name, of the super class Item, will be set to.
     * @param image the image that the instance variable _image, of the super class Item, will be set to.
     */
    public LivingEntity(String name, Image image){
        super(name, image);
        _friends = new ArrayList<LivingEntity>();
        _moments = new ArrayList<Moment>();
    }

    /**
     * Sets the value of the instance variable _friends to the inputted value friends.
     * @param friends an ArrayList of LivingEntities who are friends with the LivingEntity.
     */
    public void setFriends(ArrayList<LivingEntity> friends) {
        _friends = friends;
    }

    /**
     * Returns the value of the instance variable _friends.
     * @return _friends instance variable.
     */
    public ArrayList<LivingEntity> getFriends() {
        return(_friends);
    }

    /**
     * Sets the value of the instance variable _moments to the inputted value moments.
     * @param moments an ArrayList of Moments which are the moments the LivingEntity participated in.
     */
    public void setMoments(ArrayList<Moment> moments) {
        _moments = moments;
    }

    /**
     * Produces the friend that the LivingEntity is happiest on average with.
     * @return the friend who makes them the happiest on average.
     */
    public LivingEntity getFriendWithWhomIAmHappiest() {
        LivingEntity happiest = null;
        float highestAvg = 0;
        float currAvg = 0;
        for(int i = 0; i < _friends.size(); i++) {
            float currTotal = 0;
            float currAmm = 0;
            for(int j = 0; j < _moments.size(); j++) {
                if(_moments.get(j).getParticipants().contains(_friends.get(i))){
                    currAmm++;
                    currTotal += _moments.get(j).getSmileValues().get(_moments.get(j).getParticipants().indexOf(this));
                }
            }
            if (currAmm==0) { // makes sure it doesn't crash if the friends don't appear in any moments together
                currAvg=0;
            }
            else {
                currAvg = currTotal / currAmm;
            }
            if (currAvg > highestAvg) {
                highestAvg = currAvg;
                happiest = _friends.get(i);
            }
        }
        return happiest;
    }

    /**
     * Produces the moment with the highest average happiness.
     * @return the moment with the highest average happiness.
     */
    public Moment getOverallHappiestMoment() {
        double maxHappiness = 0;
        Moment maxMoment = null;
        for (int i = 0; i < _moments.size(); i++) {
            if (getAverage(_moments.get(i).getSmileValues()) >= maxHappiness) {
                maxHappiness = getAverage(_moments.get(i).getSmileValues());
                maxMoment = _moments.get(i);
            } 
        }
        return maxMoment;
    }

    /**
     * Helper method to calculate the average of a ArrayList of floats.
     * @return the average of the floats in the ArrayList.
     */
    private double getAverage(ArrayList<Float> list) {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum/list.size();
    }

    /**
     * Produces the largest clique out of the set of friends.
     * @return largest clique out of the set of friends.
     */
    public ArrayList findMaximumCliqueOfFriends() {

        ArrayList<ArrayList<LivingEntity>> list = getListOfCliques(makePowerSet(_friends));
        int longest = 0;
        ArrayList longestClique = new ArrayList();

        for (ArrayList<LivingEntity> clique : list) {
            if (clique.size() >= longest) {
                longestClique = clique;
                longest = clique.size();
            }
        }

        return longestClique;

    }

    /**
     * Helper method that filters out all the non-clique sets from an ArrayList of ArrayLists of LivingEntities.
     * @return an ArrayList of ArrayLists of LivingEntities containing all ArrayLists that are Cliques.
     */
    private ArrayList<ArrayList<LivingEntity>> getListOfCliques(ArrayList<ArrayList<LivingEntity>> list) {

        for (int i = 0; i < list.size(); i++) {
            if (!isClique(list.get(i))) {
                list.remove(i);
                i--;
            }
        }

        return list;
    }

    /**
     * Helper method that takes in the friend set and produces the power set.
     * @return a power set based on the inputted set.
     */
    private ArrayList<ArrayList<LivingEntity>> makePowerSet(ArrayList<LivingEntity> set) {
        final ArrayList<ArrayList<LivingEntity>> powerSet = new ArrayList<>();
        int numSubsets = (int) Math.pow(2, set.size());
        for (int i = 0; i < numSubsets; i++) {
        		int powerSetIndex=i;
        		ArrayList<LivingEntity> subset=new ArrayList<>();
        		for (int j = set.size() - 1; j >= 0; j--) {
                    if (powerSetIndex >= Math.pow(2,j)) {
                        subset.add(set.get(j));
                        powerSetIndex-=Math.pow(2,j);
                    }
                }
            powerSet.add(subset);
        }
        return powerSet;
    }

    /**
     * Helper method that checks if the inputted set is a clique.
     * @return a boolean false if the set is not a clique and true otherwise.
     */
    public static boolean isClique(ArrayList set) {
        for (int i = 0; i < set.size(); i++) {
            ArrayList<LivingEntity> currentFriends = ((LivingEntity)set.get(i)).getFriends();
            for (int j = 0; j < set.size(); j++) {
                if (!(j == i || currentFriends.contains(set.get(j)))) {
                    return false;
                }
            }

        }
        return true;
    }

}