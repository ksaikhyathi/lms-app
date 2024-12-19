package com.jm.lms.studentms.controller;

import com.jm.lms.studentms.model.TopicList;
import com.jm.lms.studentms.service.ViewTopicListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(("api/v1/lms/Topics"))
public class ViewTopicListController {

    @Autowired
    private ViewTopicListService topicListService;

    @GetMapping("/TopicList/{topicTitle}")
    public ResponseEntity<Optional<TopicList>> getTopicList(@PathVariable("topicTitle") String topicTitle) {
        Optional<TopicList> topicList = topicListService.getTopicListByTitle(topicTitle);
        return ResponseEntity.ok(topicList);
    }

    @GetMapping("/allTopics")
    public ResponseEntity<List<TopicList>> getAllTopics() {
        List<TopicList> allTopics = topicListService.getAllTopics();
        System.out.println("all topics" + allTopics);
        return ResponseEntity.ok(allTopics);

    }

    @PostMapping
    public ResponseEntity<TopicList> saveTopic(@RequestBody TopicList topicList) {
        TopicList saveTopic = topicListService.saveTopic(topicList);
        return ResponseEntity.ok(saveTopic);
    }

    @PutMapping("/{topicTitle}")
    public ResponseEntity<TopicList> updateTopicByTitle(@RequestBody TopicList topicList, @PathVariable("topicTitle") String topicTitle) {
        TopicList updated = topicListService.updateTopicByTitle(topicList, topicTitle);
        return ResponseEntity.accepted().body(updated);
    }

}
