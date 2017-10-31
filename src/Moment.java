import java.util.ArrayList;
public class Moment extends Item {

    // instance variables
    private ArrayList<LivingEntity> _participants;
    private ArrayList<Float> _smileValues;

    /**
     * Constructor that specifies the name, image, participants, and smileValues.
     * @param name the name that the instance variable _name, of the super class Item, will be set to.
     * @param image the image that the instance variable _image, of the super class Item, will be set to.
     * @param participants the ArrayList of LivingEntities that the instance varaible _participants will be set to.
     * @param smileValues the ArrayList of floats that the instance varaible _smileValues will be set to.
     */
    Moment(String name, Image image, ArrayList<LivingEntity> participants, ArrayList<Float> smileValues){
        super(name, image);
        _participants = participants;
        _smileValues = smileValues;
    }

    /**
     * Returns the value of the instance variable _participants.
     * @return _participants instance variable.
     */
    public ArrayList<LivingEntity> getParticipants() {
        return _participants;
    }

    /**
     * Returns the value of the instance variable _smileValues.
     * @return _smileValues instance variable.
     */
    public ArrayList<Float> getSmileValues() {
        return _smileValues;
    }

}