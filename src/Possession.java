public class Possession extends Item{

    private Person _owner;
    private float _price;

    Possession(String name, Image image, Float price){
        super(name, image);
        _price = price;
    }

    public void setOwner(Person owner) {
        _owner = owner;
    }

}
