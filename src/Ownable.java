public class Ownable extends Item{

    private Person owner;

    Ownable(String name, Image image){
        super(name, image);
    }

    public void setOwner(Person owner){
        this.owner = owner;
    }
}
