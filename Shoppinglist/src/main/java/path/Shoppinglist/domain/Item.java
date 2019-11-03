package path.Shoppinglist.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private double price;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "sectionid")
	private Section section;
	
	public Item( String name, double price, Section section) {
		super();
	
		this.name = name;
		this.price = price;
		this.section = section;
	}

	
	public Item() {
		super();
		
	}

	@Override
	public String toString() {
		if (this.section != null)
		return "Item [id=" + id + ", name=" + name + ", price=" + price + "section= " + this.getSection() + "]";
		else
			return "Item [id=" + id + ", name=" + name + ", price=" + price +  "]";
	}
	
	}

