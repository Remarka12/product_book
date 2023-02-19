package ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    @Test

    public void addProduct() {

        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Book book1 = new Book(2, "Анна Каренина", 700, "Толстой");
        Book book2 = new Book(3, "Чемодан", 300, "Довлатов");
        Book book3 = new Book(5, "Числа", 450, "Пелевин");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book1, book2, book3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void checkName() {

        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Smartphone telephone1 = new Smartphone(2, "Galaxy", 700000, "Samsung");
        Smartphone telephone2 = new Smartphone(3, "Iphone", 89000, "Apple");
        Smartphone telephone3 = new Smartphone(5, "Readme", 45000, "Xiaomi");

        manager.add(telephone1);
        manager.add(telephone2);
        manager.add(telephone3);

        Product[] expected = {telephone1};
        Product[] actual = manager.searchBy("Galaxy");

        Assertions.assertArrayEquals(expected, actual);
    }
}

