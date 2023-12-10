package in.timtim.model;


public class Product {
	
	private int id;
	private String name;
	private double price;
	private String category;
	private String image;
	public Product() {
		
	}
	
	public Product(int id, String name, Double price, String category, String image) {
		
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.image = image;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + ", image="
				+ image + "]";
	}
	
	
	
	
	
	

}
