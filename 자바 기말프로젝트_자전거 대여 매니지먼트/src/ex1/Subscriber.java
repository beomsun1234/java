package ex1;

public class Subscriber implements Comparable<Subscriber>{
	String id;
	String name;
	String pass;
	String rate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public Subscriber(String id, String name, String pass, String rate) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.rate = rate;
	}
	@Override
	public int compareTo(Subscriber o) {
		// TODO Auto-generated method stub
		return o.getName().compareTo(name);
	}
	
	

}
