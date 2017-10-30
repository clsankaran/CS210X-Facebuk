import java.util.ArrayList;
public class Moment extends Item {

    private ArrayList<LivingEntity> _participants;
    private ArrayList<Float> _smileValues;
    
    Moment(String name, Image image, ArrayList<LivingEntity> participants, ArrayList<Float> smileValues){
        super(name, image);
        this._participants = participants;
        this._smileValues = smileValues;
    }

    public ArrayList<LivingEntity> getParticipants() {
        return _participants;
    }

    public ArrayList<Float> getSmileValues() {
        return _smileValues;
    }

}