package path.Shoppinglist.Web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



import path.Shoppinglist.domain.Item;
import path.Shoppinglist.domain.ItemRepository;
import path.Shoppinglist.domain.SectionRepository;

@Controller
public class ItemController {
@Autowired
private ItemRepository repository;

@Autowired
private SectionRepository srepository;

//Login page
@RequestMapping(value="/login")
public String login() {	
    return "login";
}

//Show all items
@RequestMapping(value="/shoppinglist")
public String shoppingList(Model model) {	
    model.addAttribute("items", repository.findAll());
    return "shoppinglist";
}
//add item
@RequestMapping(value = "/add")
public String addItem(Model model) {
	model.addAttribute("item", new Item());
	model.addAttribute("sections", srepository.findAll());
	return "additem";
}

// RESTful service to get all items
@RequestMapping(value="/items", method = RequestMethod.GET)
public @ResponseBody List<Item> itemListRest() {	
    return (List<Item>) repository.findAll();
}    

// RESTful service to get items by id
@RequestMapping(value="/item/{id}", method = RequestMethod.GET)
public @ResponseBody Optional<Item> findItemRest(@PathVariable("id") Long itemId) {	
	return repository.findById(itemId);
}
// Save an item
@RequestMapping(value = "/save", method = RequestMethod.POST)
public String save(Item item) {
	repository.save(item);
	return "redirect:shoppinglist";
}
//delete an item
 
@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
public String deleteItem(@PathVariable("id") Long itemId, Model model) {
	repository.deleteById(itemId);
	return "redirect:../shoppinglist";
}
 
@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
public String editItem(@PathVariable("id") Long itemId, Model model) {
	model.addAttribute("item", repository.findById(itemId));
	model.addAttribute("sections", srepository.findAll());
	return "editlist";
}



}
