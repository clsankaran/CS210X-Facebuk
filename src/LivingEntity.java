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
        ArrayList list = new ArrayList();



        return list;
    }

    public ArrayList makePowerSet(ArrayList<Person> list) {
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