package com.pavelbelov.spring5webapp.repositories;

import com.pavelbelov.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Pavel Belov on 30.08.2021
 */

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
