import java.util.ArrayList;
public class Person extends LivingEntity{

    private ArrayList<Possession> _possessions;
    private ArrayList<Pet> _pets;

    public Person (String name, Image image) {
        super(name, image);
    }

    public void setPossessions(ArrayList<Possession> possessions) {
        _possessions = possessions;
    }

    public void setPets(ArrayList<Pet> pets) {
        _pets = pets;
    }

}