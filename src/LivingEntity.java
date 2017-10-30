import java.util.ArrayList;
public class LivingEntity extends Item{

    private ArrayList<LivingEntity> _friends;
    private ArrayList<Moment> _moments;

    public LivingEntity(String name, Image image){
        super(name, image);
        this._friends = new ArrayList<LivingEntity>();
        this._moments = new ArrayList<Moment>();
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
        for(int i = 0; i < this._friends.size(); i++){
            float currTotal = 0;
            float currAmm = 0;
            for(int j = 0; j < this._moments.size(); j++) {
                if(this._moments.get(j).getParticipants().contains(this._friends.get(i))){
                    currAmm++;
                    currTotal += this._moments.get(j).getSmileValues().get(this._moments.get(j).getParticipants().indexOf(this));
                }
            }
            currAvg = currTotal / currAmm;
            if(currAvg > highestAvg){
                highestAvg = currAvg;
                happiest = this._friends.get(i);
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

    public double getAverage(ArrayList<Float> list) {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

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


    private ArrayList<ArrayList<LivingEntity>> getListOfCliques(ArrayList<ArrayList<LivingEntity>> list) {

        for (int i = 0; i < list.size(); i++) {
            if (!isClique(list.get(i))) {
                list.remove(i);
                i--;
            }
        }

        return list;
    }


    private ArrayList<ArrayList<LivingEntity>> makePowerSet(ArrayList<LivingEntity> set) {
        ArrayList<ArrayList<LivingEntity>> powerSet = new ArrayList<>();
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