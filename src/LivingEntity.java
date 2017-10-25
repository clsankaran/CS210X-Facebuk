import java.util.ArrayList;
public class LivingEntity extends Item{

    private ArrayList<LivingEntity> friends;
    private ArrayList<Moment> moments;

    LivingEntity(String name, Image image){
        super(name, image);
        this.friends = new ArrayList<LivingEntity>();
        this.moments = new ArrayList<Moment>();
    }

    public void setFreinds(ArrayList<LivingEntity> friends) {
        this.friends = friends;
    }

    public void setMoments(ArrayList<Moment> moments) {
        this.moments = moments;
    }

    public ArrayList<LivingEntity> getFriends() {
        return(this.friends);
    }

}