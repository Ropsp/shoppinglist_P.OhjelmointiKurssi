package path.Shoppinglist;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Data;
import path.Shoppinglist.domain.Item;
import path.Shoppinglist.domain.ItemRepository;
import path.Shoppinglist.domain.Section;


@Data
@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {
	@Autowired
	private ItemRepository repository;

	
	@Test
	public void findBynameShouldReturnItem() {
		List<path.Shoppinglist.domain.Item> items = repository.findByname("name");
		assertThat(items).hasSize(0);
		
	}
	
	@Test
	public void createNewItem() {
		Item item = new Item("test",10, new Section("Dairy"));
		repository.save(item);
		assertThat(item.getId()).isNotNull();
	}
}


