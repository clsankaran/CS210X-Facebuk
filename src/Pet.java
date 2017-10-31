public class Pet extends LivingEntity {

    // instance variables
    private Person _owner;

    /**
     * Constructor that specifies the name and image.
     * @param name the name that the instance variable _name, of the super class Item, will be set to.
     * @param image the image that the instance variable _image, of the super class Item, will be set to.
     */
    Pet(String name, Image image){
        super(name, image);
    }

    /**
     * Sets the value of the instance variable _owner to the inputted value owner.
     * @param owner a Person who is the owner of the Pet.
     */
    public void setOwner(Person owner) {
        _owner = owner;
    }

}