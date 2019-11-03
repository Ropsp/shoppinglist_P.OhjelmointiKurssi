package path.Shoppinglist.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;





public interface SectionRepository extends CrudRepository<Section, Long>{
	List<Section> findByname(String name);
}
