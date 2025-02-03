package ECommerce_Selenium_Automation.magento.Data;

import net.datafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    
    private static final Faker faker = new Faker(Locale.US);

    public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getCountry() {
		return country;
	}

	private String phoneNumber;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    public Address createFakeAddress() {
        this.phoneNumber = faker.phoneNumber().cellPhone();
        this.streetAddress = faker.address().streetAddress();
        this.city = faker.address().city();
        this.state = faker.address().state();
        this.zipCode = faker.address().zipCode();
        this.country = faker.address().country();
        System.out.println(this.city+" "+this.country+" "
        +this.phoneNumber+" "+this.state+" "+this.streetAddress+" "
        		+this.zipCode);
        return this;
    }
}
