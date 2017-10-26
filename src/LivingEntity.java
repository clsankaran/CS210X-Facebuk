import java.util.ArrayList;
public class LivingEntity extends Item{

    private ArrayList<LivingEntity> friends;
    private ArrayList<Moment> moments;

    LivingEntity(String name, Image image){
        super(name, image);
        this.friends = new ArrayList<LivingEntity>();
        this.moments = new ArrayList<Moment>();
    }

    public void setFriends(ArrayList<LivingEntity> friends) {
        this.friends = friends;
    }
    
    public ArrayList<LivingEntity> getFriends() {
        return(this.friends);
    }

    public void setMoments(ArrayList<Moment> moments) {
        this.moments = moments;
    }


    public LivingEntity getFriendWithWhomIAmHappiest() {
        LivingEntity happiest = null;
        float highestAvg = 0;
        float currAvg = 0;
        for(int i = 0; i < this.friends.size(); i++){
            float currTotal = 0;
            float currAmm = 0;
            for(int j = 0; j < this.moments.size(); j++) {
                if(this.moments.get(j).getParticipants().contains(this.friends.get(i))){
                    currAmm++;
                    currTotal += this.moments.get(j).getSmileValues().get(this.moments.get(j).getParticipants().indexOf(this));
                }
            }
            currAvg = currTotal / currAmm;
            if(currAvg > highestAvg){
                highestAvg = currAvg;
                happiest = this.friends.get(i);
            }
        }
        return happiest;
    }
    
    public static boolean isClique(ArrayList set) {
    		for (int i=0; i<set.size(); i++) {
    			ArrayList<LivingEntity> currentFriends = set.get(i).getFriends();
    			for (int j=0; j<set.size(); j++) {
    				if (!(j==i || currentFriends.contains(set.get(j)))) {
    					return false;
    				}
    			} 
    			
    		}
    		return true;
    }

    public Moment getOverallHappiestMoment() {
        double maxHappiness = 0;
        Moment maxMoment = null;
        for (int i = 0; i < moments.size(); i++) {
            if (getAverage(moments.get(i).getSmileValues()) >= maxHappiness) {
                maxHappiness = getAverage(moments.get(i).getSmileValues());
                maxMoment = moments.get(i);
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

}