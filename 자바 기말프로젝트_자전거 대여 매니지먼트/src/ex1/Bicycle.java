package ex1;

public class Bicycle {
	String Id;
	String type;
	String name;
	int price;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Bicycle(String id, String type, String name, int price) {
		super();
		Id = id;
		this.type = type;
		this.name = name;
		this.price = price;
	}
	

}
