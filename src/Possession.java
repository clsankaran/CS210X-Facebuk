public class Possession extends Ownable{

    private float price;

    Possession(String name, Image image, Float price){
        super(name, image);
        this.price = price;
    }

}
