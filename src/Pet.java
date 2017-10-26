public class Pet extends LivingEntity {

    private Person owner;

    Pet(String name, Image image){
        super(name, image);
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
