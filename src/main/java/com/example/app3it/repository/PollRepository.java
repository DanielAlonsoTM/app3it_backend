package com.example.app3it.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app3it.model.Poll;

public interface PollRepository extends JpaRepository<Poll, Integer> {
}
