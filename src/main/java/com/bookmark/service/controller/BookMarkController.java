package com.bookmark.service.controller;


import com.bookmark.service.entity.BookMark;
import com.bookmark.service.service.BookMarkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class BookMarkController {

    @Autowired
    BookMarkService bookMarkService;

    @GetMapping("/allBookMarks")
    public ResponseEntity<List<BookMark>> getAllBookMarks()
    {
        List<BookMark> bookMarks=bookMarkService.getAllBookmark();
        log.info(bookMarks.toString());
        //bookMarkService.getAllBookmark().forEach(x-> System.out.println(x.getProduct()));
        return ResponseEntity.ok(bookMarks);
    }

    @GetMapping("/{bookMarkId}")
    public ResponseEntity<BookMark> getBookMarkById(@PathVariable String bookMarkId)
    {
        BookMark bookMark=bookMarkService.findBookMarkById(bookMarkId);
        log.info(bookMark.toString());
        return ResponseEntity.ok(bookMark);
    }
    @PostMapping("/bookmark")
    public BookMark createBookmark(@RequestBody BookMark bookmark) {
        log.info("Creating Bookmark.");
        return bookMarkService.createBookMark(bookmark);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookMark> updateBookmark(@PathVariable String id, @RequestBody BookMark updatedBookmark) {
        try {
            return ResponseEntity.ok(bookMarkService.updateBookMark(id, updatedBookmark));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookmark(@PathVariable String id) {
        bookMarkService.deleteBookMark(id);
        return ResponseEntity.noContent().build();
    }
}
