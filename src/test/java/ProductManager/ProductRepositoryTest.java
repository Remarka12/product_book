package ProductManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    @Test
    public void addUnit() {

        ProductRepository repo = new ProductRepository();

        Book book1 = new Book(7, "Мастер и Маргарита", 500, "Булгаков");
        Book book2 = new Book(6, "Тихий Дон", 300, "Шолохов");
        Book book3 = new Book(3, "Что делать?", 380, "Чернышевский");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);

        Product[] expected = {book1, book2, book3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() {

        ProductRepository repo = new ProductRepository();

        Book book1 = new Book(7, "Мастер и Маргарита", 500, "Булгаков");
        Book book2 = new Book(6, "Тихий Дон", 300, "Шолохов" );
        Book book3 = new Book(3, "Что делать?", 380,"Чернышевский" );

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.removeProductById(book2.getId());
        Product[] expected = {book1, book3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
