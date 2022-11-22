package com.example.app3it.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.app3it.model.Poll;
import com.example.app3it.model.Response;
import com.example.app3it.service.PollService;

public class PollControllerTest {
    @InjectMocks
    PollController pollController;

    @Mock
    PollService pollService;

    @Test
    void testAdd() {

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(pollService.savePoll(any(Poll.class))).thenReturn(new Poll("return@gmail.com", "rock"));

        Poll poll = new Poll("test@gmail.com", "rock");
        Response responseEntity = pollController.add(poll);

        assertThat(responseEntity.getStatusMessage()).isEqualTo("Saved");
    }

    @Test
    void testList() {
        Poll poll1 = new Poll("test1@gmail.com", "rock");
        Poll poll2 = new Poll("test2@gmail.com", "pop");

        List<Poll> polls = new ArrayList<>();
        polls.add(poll1);
        polls.add(poll2);

        when(pollService.listAllPoll()).thenReturn(polls);

        // when
        List<Poll> result = pollController.list();

        // then
        assertThat(result.size()).isEqualTo(2);

        assertThat(result.get(0).getEmail())
                .isEqualTo(poll1.getEmail());

        assertThat(result.get(1).getEmail())
                .isEqualTo(poll2.getEmail());
    }
}
