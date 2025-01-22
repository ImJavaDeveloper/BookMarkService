package com.bookmark.service.service;

import com.bookmark.service.entity.BookMark;
import com.bookmark.service.repository.BookMarkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookMarkServiceImpl implements  BookMarkService {

    private static final Logger log = LoggerFactory.getLogger(BookMarkServiceImpl.class);
    public final BookMarkRepository bookMarkRepository;

    public BookMarkServiceImpl(BookMarkRepository bookMarkRepository)
    {
        this.bookMarkRepository=bookMarkRepository;
    }
    @Override
    public BookMark createBookMark(BookMark bookMark) {
        log.info("Adding Bookmark in DB");
        return bookMarkRepository.save(bookMark);
    }

    @Cacheable(value = "bookmark", key = "#bookMarkId")
    @Override
    public BookMark findBookMarkById(String bookMarkId) {
        log.info("Finding Bookmark from DB:{}",bookMarkId);
        return bookMarkRepository.findById(bookMarkId);
    }

    @CachePut(value = "bookmark", key = "#bookMark.id")
    @Override
    public BookMark updateBookMark(String bookMarkId,BookMark bookMark) {
        log.info("Updating Bookmark:{}",bookMarkId);
        return bookMarkRepository.save(bookMark);
    }

    @CacheEvict(value = "bookmark", key = "#bookMarkId")
    @Override
    public void deleteBookMark(String bookMarkId) {
        log.info("Deleting Bookmark:{}",bookMarkId);
         bookMarkRepository.deleteById(bookMarkId);
    }

    @Override
    public List<BookMark> getAllBookmark() {
        log.info("Getting All Bookmark from DB");
        List<BookMark> list=new ArrayList<>();
        try{
            list= bookMarkRepository.findAll();
        }catch (Exception e)
        {
            log.info("Getting Exception While Getting Bookmark:{}",e);
        }
      return  list;
    }

    @Override
    @CacheEvict(value = "bookmark", allEntries = true)
    public void clearProductCache() {
        log.info("bookmarks cache was cleared successfully");
    }

}
