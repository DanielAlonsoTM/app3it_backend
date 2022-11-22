package com.example.app3it.service;

import com.example.app3it.model.Poll;
import com.example.app3it.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PollService {

    @Autowired
    private PollRepository pollRepository;

    public List<Poll> listAllPoll() {
        return pollRepository.findAll();
    }

    public Poll savePoll(Poll poll) {
       return pollRepository.save(poll);
    }

    public Poll getPoll(String email) {
        return pollRepository.findByEmail(email);
    }

    // public void deletePoll(String email) {
    //     pollRepository.deleteById(email);
    // }
}
