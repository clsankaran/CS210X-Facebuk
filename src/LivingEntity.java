import java.util.ArrayList;
public class LivingEntity extends Item{

    private ArrayList<LivingEntity> _friends;
    private ArrayList<Moment> _moments;

    public LivingEntity(String name, Image image){
        super(name, image);
        _friends = new ArrayList<LivingEntity>();
        _moments = new ArrayList<Moment>();
    }

    public void setFriends(ArrayList<LivingEntity> friends) {
        this._friends = friends;
    }
    
    public ArrayList<LivingEntity> getFriends() {
        return(this._friends);
    }

    public void setMoments(ArrayList<Moment> moments) {
        this._moments = moments;
    }


    public LivingEntity getFriendWithWhomIAmHappiest() {
        LivingEntity happiest = null;
        float highestAvg = 0;
        float currAvg = 0;
        for(int i = 0; i < _friends.size(); i++){
            float currTotal = 0;
            float currAmm = 0;
            for(int j = 0; j < _moments.size(); j++) {
                if(_moments.get(j).getParticipants().contains(_friends.get(i))){
                    currAmm++;
                    currTotal += _moments.get(j).getSmileValues().get(_moments.get(j).getParticipants().indexOf(this));
                }
            }
            currAvg = currTotal / currAmm;
            if(currAvg > highestAvg){
                highestAvg = currAvg;
                happiest = _friends.get(i);
            }
        }
        return happiest;
    }


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

    private double getAverage(ArrayList<Float> list) {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum/list.size();
    }

    public ArrayList findMaximumCliqueOfFriends() {

        final ArrayList<ArrayList<LivingEntity>> powerSet = makePowerSet(_friends);
        ArrayList<LivingEntity> largestClique = new ArrayList<LivingEntity>();

        for (ArrayList<LivingEntity> subset : powerSet) {
            if (isClique(subset) && subset.size() > largestClique.size()) {
                largestClique = subset;
            }
        }

        return largestClique;

    }

    private ArrayList<ArrayList<LivingEntity>> makePowerSet(ArrayList<LivingEntity> set) {
        ArrayList<ArrayList<LivingEntity>> powerSet = new ArrayList<>();
        int numSubsets = (int) Math.pow(2, set.size());
        for (int i = 0; i < numSubsets; i++) {
            powerSet.add(makePowerSetHelper(i, set));
        }
        return powerSet;
    }

    private ArrayList<LivingEntity> makePowerSetHelper(int powerSetIndex, ArrayList<LivingEntity> set) {
    		ArrayList<LivingEntity> subset = new ArrayList<>();
        for (int i = set.size() - 1; i >= 0; i--) {
            if (powerSetIndex >= Math.pow(2,i)) {
                subset.add(set.get(i));
                powerSetIndex-=Math.pow(2,i);
            }
        }
        return subset;
    }

    public static boolean isClique(ArrayList set) {
        for (int i = 0; i < set.size(); i++) {
            final ArrayList<LivingEntity> currentFriends = ((LivingEntity)set.get(i)).getFriends();
            for (int j = 0; j < set.size(); j++) {
                if (!(j == i || currentFriends.contains(set.get(j)))) {
                    return false;
                }
            }
        }
        return true;
    }

}