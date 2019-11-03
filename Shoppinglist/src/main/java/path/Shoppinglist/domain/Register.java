package path.Shoppinglist.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class Register {
	@NotEmpty
    @Size(min=5, max=30)
    private String username = "";

    @NotEmpty
    @Size(min=7, max=30)
    private String password = "";

    @NotEmpty
    @Size(min=7, max=30)
    private String passwordCheck = "";

    @NotEmpty
    private String role = "USER";

	
	}
    
    



