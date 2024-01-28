package guru.springframework.sdjpaintro.domain;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
public class BookUuid {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name= "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "VARBINARY(16)", updatable = false, nullable = false)
    private UUID Id;
    private String title;
    private String isbn;
    private String publisher;

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
