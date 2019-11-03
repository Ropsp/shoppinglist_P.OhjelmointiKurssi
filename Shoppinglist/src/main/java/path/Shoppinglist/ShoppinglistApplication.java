package path.Shoppinglist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



import path.Shoppinglist.domain.Item;
import path.Shoppinglist.domain.ItemRepository;
import path.Shoppinglist.domain.Section;
import path.Shoppinglist.domain.SectionRepository;
import path.Shoppinglist.domain.User;
import path.Shoppinglist.domain.UserRepository;



@SpringBootApplication
public class ShoppinglistApplication {
	private static final Logger log = LoggerFactory.getLogger(ShoppinglistApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ShoppinglistApplication.class, args);
	}
	@Bean
	public CommandLineRunner itemDemo(ItemRepository irepository, SectionRepository srepository,
			UserRepository urepository) {
		return (args) -> {
			log.info("save a item");
			srepository.save(new Section("Meat"));
			srepository.save(new Section("Fruits and Vegetables"));
			srepository.save(new Section("Dairy"));
			

			irepository.save(new Item("chicken", 2.00, srepository.findByname("Meat").get(0)));
			// String name, double price

			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

			log.info("fetch all items");
			for (Item item : irepository.findAll()) {
				log.info(item.toString());
			}

		};

	}
}
