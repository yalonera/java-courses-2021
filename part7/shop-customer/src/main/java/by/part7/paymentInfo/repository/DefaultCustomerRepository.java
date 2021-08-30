package by.part7.paymentInfo.repository;

import by.part7.paymentInfo.model.AddressInfo;
import by.part7.paymentInfo.model.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultCustomerRepository implements CustomerRepository {

  private static final long SEED = 1731349857;
  private static final int MAX_HOUSE_NUMBER = 160;

  private static final Random rand = new Random(SEED);

  private static final List<String> customerNames = new ArrayList<>();
  private static final List<String> customerEmails = new ArrayList<>();
  private static final List<String> cities = new ArrayList<>();
  private static final List<String> countries = new ArrayList<>();
  private static final List<String> streets = new ArrayList<>();

  static {

    customerNames.add("John Smith");
    customerNames.add("Rose Tyler");
    customerNames.add("Donna Noble");
    customerNames.add("Martha Jones");
    customerNames.add("Rory Williams");

    //size should be equal to customerNames
    customerEmails.add("john.smith@rambler.uk");
    customerEmails.add("r0se-tyler@gmail.com");
    customerEmails.add("DonnaDonna@gmail.com");
    customerEmails.add("martha@mail.ru");
    customerEmails.add("super-rory@tut.by");

    cities.add("New York");
    cities.add("London");
    cities.add("Moscow");

    //size should be equal to cities
    countries.add("USA");
    countries.add("Great Britain");
    countries.add("Russian Federation");

    streets.add("Marble st.");
    streets.add("Bubble avn.");
    streets.add("Evergreen terrace");
    streets.add("Lomonosova st.");
    streets.add("Basic st.");
    streets.add("Test st.");
  }

  @Override
  public List<Customer> findAll() {
    return generate(customerNames.size(), this::createCustomer);
  }

  @Override
  public Customer findById(int id) {
    return null;
  }

  private Customer createCustomer(final int i) {
    final int idx = i % customerEmails.size();
    final Customer customer = new Customer();
    customer.setEmail(customerEmails.get(idx));
    customer.setName(customerNames.get(idx));
    customer.setAddress(createAddressInfo());
    return customer;
  }

  private AddressInfo createAddressInfo() {
    final int cityIdx = rand.nextInt(cities.size());
    final int stIdx = rand.nextInt(streets.size());
    final AddressInfo addressInfo = new AddressInfo();
    addressInfo.setCity(cities.get(cityIdx));
    addressInfo.setCountry(countries.get(cityIdx));
    addressInfo.setStreet(streets.get(stIdx));
    addressInfo.setHouseNumber(rand.nextInt(MAX_HOUSE_NUMBER));
    return addressInfo;
  }

  private <T> List<T> generate(final int count, final IntFunction<T> supplier) {
    return IntStream.range(0, count)
        .mapToObj(supplier)
        .collect(Collectors.toList());
  }
}
