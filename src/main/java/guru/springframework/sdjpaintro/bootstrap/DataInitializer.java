package guru.springframework.sdjpaintro.bootstrap;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        //new object and method from repository -> save

        Book bookDDD = new Book("Domain Drive Design","123","RandomHouse");

        System.out.println("Id: "+ bookDDD.getId() );
        Book savedDDD =bookRepository.save(bookDDD);

        System.out.println("Id: "+ savedDDD.getId());

        Book bookSIA = new Book("Spring In Action", "234234","oriely");
        Book savedSIA = bookRepository.save(bookSIA);

        //for each to iterate with lambda function
        bookRepository.findAll().forEach(book -> {
            System.out.println("Book Id: "+ book.getId());
            System.out.println("Book Title: "+book.getTitle());


        });

    }
}
