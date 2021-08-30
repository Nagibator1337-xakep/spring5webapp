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
    public void run(String... args) throws  Exception {

        Author pelevin = new Author("Viktor", "Pelevin");
        Book homoZapiens = new Book("Homo Zapiens", "978-0142001813");
        Publisher penguin = new Publisher("Penguin Books","375 Hudson Street", "New York", "NY", "375 Hudson Street New York");

        pelevin.getBooks().add(homoZapiens);
        homoZapiens.getAuthors().add(pelevin);


        authorRepository.save(pelevin);
        bookRepository.save(homoZapiens);
        publisherRepository.save(penguin);

        Author srkn = new Author("Vladimir", "Sorokin");
        Book blizzard = new Book("The Blizzard: A Novel", "978-0374114374");
        Publisher fsg = new Publisher("Farrar, Straus and Giroux", "120 Broadway", "New York", "NY","10271");

        srkn.getBooks().add(blizzard);
        blizzard.getAuthors().add(srkn);

        authorRepository.save(srkn);
        bookRepository.save(blizzard);
        publisherRepository.save(fsg);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of authors: "+ authorRepository.count());
        System.out.println("Number of publishers: "+ publisherRepository.count());

    }
}
