package path.Shoppinglist;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;



import path.Shoppinglist.domain.Section;
import path.Shoppinglist.domain.SectionRepository;



@RunWith(SpringRunner.class)
@DataJpaTest
public class SectionRepositoryTest {

	
	@Autowired
	private SectionRepository repository;
	
	@Test
	public void findBySectionShouldReturnName() {
		List <Section> sections = repository.findByname("Meat");
		assertThat(sections).hasSize(1);
}
	@Test
	public void createNewSection() {
		Section section = new Section ("Sweets");
		repository.save(section);
		assertThat(section.getSectionid()).isNotNull();
}
}
