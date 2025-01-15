package com.bookmark.service.service;

import com.bookmark.service.entity.BookMark;

import java.util.List;

public interface BookMarkService {

    BookMark createBookMark(BookMark bookMark);
    BookMark findBookMarkById(String bookMarkId);
    BookMark updateBookMark(String bookmarkId,BookMark bookMark);
    void deleteBookMark(String  bookMarkId);
    List<BookMark> getAllBookmark();
}
