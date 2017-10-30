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

    public boolean equals(Object o){
        if(_name.equals(((Item) o).getName())){
            return true;
        } else {
            return false;
        }
    }

}