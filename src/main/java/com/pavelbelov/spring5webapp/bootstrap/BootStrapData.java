package com.pavelbelov.spring5webapp.bootstrap;

import com.pavelbelov.spring5webapp.domain.Author;
import com.pavelbelov.spring5webapp.domain.Book;
import com.pavelbelov.spring5webapp.domain.Publisher;
import com.pavelbelov.spring5webapp.repositories.AuthorRepository;
import com.pavelbelov.spring5webapp.repositories.BookRepository;
import com.pavelbelov.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Pavel Belov on 27.08.2021
 */

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author pelevin = new Author("Viktor", "Pelevin");
        Book homoZapiens = new Book("Homo Zapiens", "978-0142001813");

        Publisher penguin = new Publisher();
        penguin.setName("Penguin Books");
        penguin.setAddressLine1("375 Hudson Street");
        penguin.setCity("New York");
        penguin.setState("NY");
        penguin.setZipCode("10014");

        publisherRepository.save(penguin);

        pelevin.getBooks().add(homoZapiens);
        homoZapiens.getAuthors().add(pelevin);

        penguin.getBooks().add(homoZapiens);
        homoZapiens.setPublisher(penguin);

        authorRepository.save(pelevin);
        bookRepository.save(homoZapiens);
        publisherRepository.save(penguin);

        Author srkn = new Author("Vladimir", "Sorokin");
        Book blizzard = new Book("The Blizzard: A Novel", "978-0374114374");

        Publisher fsg = new Publisher();
        fsg.setName("Farrar, Straus and Giroux");
        fsg.setAddressLine1("120 Broadway");
        fsg.setCity("New York");
        fsg.setState("NY");
        fsg.setZipCode("10271");

        publisherRepository.save(fsg);

        srkn.getBooks().add(blizzard);
        blizzard.getAuthors().add(srkn);

        fsg.getBooks().add(blizzard);
        blizzard.setPublisher(fsg);

        authorRepository.save(srkn);
        bookRepository.save(blizzard);
        publisherRepository.save(fsg);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of authors: " + authorRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());

        System.out.println("Publisher \"" + penguin.getName() + "\" have " + penguin.getBooks().size() + " Book(s)");
        System.out.println("Publisher \"" + fsg.getName() + "\" have " + fsg.getBooks().size() + " Book(s)");

    }
}
