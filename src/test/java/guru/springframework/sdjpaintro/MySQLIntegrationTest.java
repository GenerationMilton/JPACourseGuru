package guru.springframework.sdjpaintro;

import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//To use a local database with mySQL
@ActiveProfiles("local")
@DataJpaTest
//To initialize data in class DataInitializer for test
@ComponentScan("guru.springframework.sdjpaintro.bootstrap")
//to springboot dont autoconfigure test database
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class MySQLIntegrationTest {

    @Autowired
    BookRepository bookRepository;
    @Test
    void testMySQL() {
        long countBefore = bookRepository.count();

        assertThat(countBefore).isEqualTo(2);
    }
}
