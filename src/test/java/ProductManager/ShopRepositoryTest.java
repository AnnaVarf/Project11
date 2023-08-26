package ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    @Test
    public void removeWhenProductExistTest() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(15, "планшет", 20_000);
        Product product2 = new Product(25, "тетрадь", 200);
        Product product3 = new Product(500, "мопед", 2_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(25);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeWhenProductNotExistTest() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(15, "планшет", 20_000);
        Product product2 = new Product(25, "тетрадь", 200);
        Product product3 = new Product(500, "мопед", 2_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(555)
                );

    }

}