import java.util.ArrayList;
public class Person extends LivingEntity{

    private ArrayList<Possession> possessions;

    public Person (String name, Image image) {
        super(name, image);
    }

    public void setPossessions(ArrayList<Possession> possessions) {
        this.possessions = possessions;
    }

}