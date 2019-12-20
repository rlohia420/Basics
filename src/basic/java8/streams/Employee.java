package basic.java8.streams;

public class Employee {


	private String name;
	private int id;
	private String city;
	private String country;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employee(String name, int id, String city, String country) {
		super();
		this.name = name;
		this.id = id;
		this.city = city;
		this.country = country;
	}

}
