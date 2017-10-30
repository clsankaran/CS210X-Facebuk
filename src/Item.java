public class Item {

    private String _name;
    private Image _image;

    Item(String name, Image image){
        this._name = name;
        this._image = image;
    }

    public String getName() {
        return _name;
    }

    public Image getImage() {
        return _image;
    }

    public boolean equals(Item item){
        if(_name.equals(item.getName())){
            return true;
        } else {
            return false;
        }
    }

}