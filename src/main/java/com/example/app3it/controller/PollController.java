package com.example.app3it.controller;

import com.example.app3it.model.Poll;
import com.example.app3it.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// import java.util.NoSuchElementException;

@RestController
@RequestMapping("/polls")
public class PollController {
    @Autowired
    PollService pollService;

    @GetMapping("")
    public List<Poll> list() {
        return pollService.listAllPoll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Poll poll) {
        try {
            pollService.savePoll(poll);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @GetMapping("/{email}")
    // public ResponseEntity<Poll> get(@PathVariable String email) {
    // try {
    // Poll poll = pollService.getPoll(email);
    // return new ResponseEntity<Poll>(poll, HttpStatus.OK);
    // } catch (NoSuchElementException e) {
    // return new ResponseEntity<Poll>(HttpStatus.NOT_FOUND);
    // }
    // }

    // @PutMapping("/{email}")
    // public ResponseEntity<?> update(@RequestBody Poll poll, @PathVariable String
    // email) {
    // try {
    // Poll existPoll = pollService.getPoll(email);
    // poll.setEmail(email);
    // pollService.savePoll(poll);
    // return new ResponseEntity<>(HttpStatus.OK);
    // } catch (NoSuchElementException e) {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
    // }

    // @DeleteMapping("/{email}")
    // public void delete(@PathVariable String email) {
    // pollService.deletePoll(email);
    // }
}
