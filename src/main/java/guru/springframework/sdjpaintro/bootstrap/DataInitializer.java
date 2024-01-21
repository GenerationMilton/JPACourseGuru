package guru.springframework.sdjpaintro.bootstrap;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
//my sql connect mysql database
@Profile({"local", "default"})
@Component
public class DataInitializer implements CommandLineRunner {

    //inyectar el book repository y crear el constructor
    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //implementar los metodos del CommandLineRunner
    @Override
    public void run(String... args) throws Exception {


        //mysql
        bookRepository.deleteAll();

        //new object and method from repository -> save

        Book bookDDD = new Book("Domain Drive Design","123","RandomHouse");
        Book savedDDD =bookRepository.save(bookDDD);


        Book bookSIA = new Book("Spring In Action", "234234","oriely");
        Book savedSIA = bookRepository.save(bookSIA);

        //for each to iterate with lambda function
        bookRepository.findAll().forEach(book -> {
            System.out.println("Book Id: "+ book.getId());
            System.out.println("Book Title: "+book.getTitle());

        });

    }
}
