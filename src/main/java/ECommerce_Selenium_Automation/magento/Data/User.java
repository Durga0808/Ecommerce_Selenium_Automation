package ECommerce_Selenium_Automation.magento.Data;

import net.datafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor // ✅ No-argument constructor remains
public class User {
    
    private static final Faker faker = new Faker();

    public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	private String firstName;
    private String lastName;
    private String email;
    private String password;

    // ✅ Generates a new User instead of modifying the existing object
    public User createFakeUser() {
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.email = faker.internet().emailAddress();
        this.password = faker.internet().password(8, 16, true, true);
        return this;
    }
}
