package com.pavelbelov.spring5webapp.repositories;

import com.pavelbelov.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Pavel Belov on 27.08.2021
 */

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
