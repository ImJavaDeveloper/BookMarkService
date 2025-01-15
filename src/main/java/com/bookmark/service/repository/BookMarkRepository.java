package com.bookmark.service.repository;

import com.bookmark.service.entity.BookMark;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMarkRepository extends MongoRepository<BookMark,Integer> {

    BookMark findById(String id);
    void deleteById(String id);
}
