package com.example.springboot_306;

import org.springframework.data.repository.CrudRepository;

public interface MovieRepo extends CrudRepository<Movie,Long> {
}
