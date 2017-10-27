public class Pet extends LivingEntity {

    private Person _owner;

    Pet(String name, Image image){
        super(name, image);
    }

    public void setOwner(Person owner) {
        this._owner = owner;
    }
}
