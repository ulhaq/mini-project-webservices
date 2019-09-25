package com.webservice.soap.endpoint;

import localhost._8081.stats.GetStatsRequest;
import localhost._8081.stats.GetStatsResponse;
import com.webservice.soap.repository.UserRepository;
import com.webservice.soap.repository.MessageRepository;
import com.webservice.soap.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class StatsEndpoint {

    private static final String NAMESPACE_URI = "http://localhost:8081/stats";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private CommentRepository commentRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStatsRequest")
    @ResponsePayload
    public GetStatsResponse getStats(@RequestPayload GetStatsRequest request) {
        GetStatsResponse response = new GetStatsResponse();

        response.setUsers(userRepository.getCount());
        response.setMessages(messageRepository.getCount());
        response.setComments(commentRepository.getCount());

        return response;
    }
}