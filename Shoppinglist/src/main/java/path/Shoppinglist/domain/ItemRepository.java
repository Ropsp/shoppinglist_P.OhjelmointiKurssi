package path.Shoppinglist.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;





public interface ItemRepository  extends CrudRepository<Item, Long>{
	List<Item> findByname(String name);
}
