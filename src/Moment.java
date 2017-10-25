import java.util.ArrayList;
public class Moment extends Item {

    private ArrayList<Person> participants;
    private ArrayList<Float> smileValues;

    Moment(String name, Image image, ArrayList<Person> participants, ArrayList<Float> smileValues){
        super(name, image);
        this.participants = participants;
        this.smileValues = smileValues;
    }

}