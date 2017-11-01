public class Possession extends Item {

	private Person _owner;
	private float _price;

	/**
	 * Constructor that specifies the name, image, and price.
	 * 
	 * @param name
	 *            the name that the instance variable _name, of the super class
	 *            Item, will be set to.
	 * @param image
	 *            the image that the instance variable _image, of the super class
	 *            Item, will be set to.
	 * @param price
	 *            the price that the instance variable _price will be set to.
	 */
	Possession(String name, Image image, Float price) {
		super(name, image);
		_price = price;
	}

	/**
	 * Sets the value of the instance variable _owner to the inputted value owner.
	 * 
	 * @param owner
	 *            a Person who is the owner of the Possession.
	 */
	public void setOwner(Person owner) {
		_owner = owner;
	}

}
