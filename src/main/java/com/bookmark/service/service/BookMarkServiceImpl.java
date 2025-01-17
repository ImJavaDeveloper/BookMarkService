package com.bookmark.service.service;

import com.bookmark.service.entity.BookMark;
import com.bookmark.service.repository.BookMarkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        return bookMarkRepository.save(bookMark);
    }

    @Override
    public BookMark findBookMarkById(String bookMarkId) {
        return bookMarkRepository.findById(bookMarkId);
    }

    @Override
    public BookMark updateBookMark(String bookMarkId,BookMark bookMark) {
        return bookMarkRepository.save(bookMark);
    }

    @Override
    public void deleteBookMark(String bookMarkId) {
         bookMarkRepository.deleteById(bookMarkId);
    }

    @Override
    public List<BookMark> getAllBookmark() {
        List<BookMark> list=new ArrayList<>();
        try{
            list= bookMarkRepository.findAll();
        }catch (Exception e)
        {
            log.info("Getting Exception While Getting Bookmark:{}",e);
        }
      return  list;
    }
}
