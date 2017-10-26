public class Possession extends Item{

    private Person owner;
    private float price;

    Possession(String name, Image image, Float price){
        super(name, image);
        this.price = price;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

}
