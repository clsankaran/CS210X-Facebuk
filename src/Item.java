public class Item {

    private String name;
    private Image image;

    Item(String name, Image image){
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }

    public boolean equals(Item item){
        if(this.name.equals(item.name)){
            return true;
        } else {
            return false;
        }
    }

}