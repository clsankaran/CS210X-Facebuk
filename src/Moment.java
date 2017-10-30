import java.util.ArrayList;
public class Moment extends Item {

    private ArrayList<Person> _participants;
    private ArrayList<Float> _smileValues;
    
    Moment(String name, Image image, ArrayList<Person> participants, ArrayList<Float> smileValues){
        super(name, image);
        _participants = participants;
        _smileValues = smileValues;
    }

    public ArrayList<Person> getParticipants() {
        return _participants;
    }

    public ArrayList<Float> getSmileValues() {
        return _smileValues;
    }

}