//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

class PhoneBook {
    private final Map<String, Set<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void addContact(String name, String phone) {
        phoneBook.computeIfAbsent(name, k -> new HashSet<>()).add(phone);
    }

    public List<Map.Entry<String, Set<String>>> getSortedContacts() {
        List<Map.Entry<String, Set<String>>> sortedContacts = new ArrayList<>(phoneBook.entrySet());
        sortedContacts.sort(new Comparator<Map.Entry<String, Set<String>>>() {
            @Override
            public int compare(Map.Entry<String, Set<String>> entry1, Map.Entry<String, Set<String>> entry2) {
                return Integer.compare(entry2.getValue().size(), entry1.getValue().size());
            }
        });
        return sortedContacts;
    }

    public void printContacts() {
        for (Map.Entry<String, Set<String>> entry : getSortedContacts()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("Alice", "12345");
        phoneBook.addContact("Alice", "123456");
        phoneBook.addContact("Alice", "123457");
        phoneBook.addContact("Bob", "67890");
        phoneBook.addContact("Alice", "54321");
        phoneBook.addContact("Bob", "09876");
        phoneBook.addContact("Bob", "0987699");
        phoneBook.addContact("Bob", "09876999");
        phoneBook.addContact("Alice", "67890");
        phoneBook.addContact("Charlie", "11111");

        phoneBook.printContacts();
    }
}
