package path.Shoppinglist.domain;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Section {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sectionid;
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "section")
	private List<Item> items;

	public Section() {
	}

	public Section(String name) {
		super();
		this.name = name;
	}



	@Override
	public String toString() {
		return "Section [sectionid=" + sectionid + ", name=" + name + "]";
	}

}
