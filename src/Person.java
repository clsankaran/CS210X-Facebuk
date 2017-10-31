import java.util.ArrayList;
public class Person extends LivingEntity{

    // instance variables
    private ArrayList<Possession> _possessions;
    private ArrayList<Pet> _pets;

    /**
     * Constructor that specifies the name and image.
     * @param name the name that the instance variable _name, of the super class Item, will be set to.
     * @param image the image that the instance variable _image, of the super class Item, will be set to.
     */
    public Person (String name, Image image) {
        super(name, image);
    }

    /**
     * Sets the value of the instance variable _possession to the inputted value possessions.
     * @param possessions an ArrayList of Possession objects.
     */
    public void setPossessions(ArrayList<Possession> possessions) {
        _possessions = possessions;
    }

    /**
     * Sets the value of the instance variable _pets to the inputted value pets.
     * @param pets an ArrayList of Pet objects.
     */
    public void setPets(ArrayList<Pet> pets) {
        _pets = pets;
    }

}