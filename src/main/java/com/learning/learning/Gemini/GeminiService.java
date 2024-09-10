package com.learning.learning.Gemini;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeminiService {
    private final String apiKey = "AIzaSyDRPep1DVLkNsBTet8oJRWN1yI4qG0kKj4";
    private final String apiUrl = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent";

    public String generateContent(String prompt) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-goog-api-key", apiKey);

        String requestBody1 = "{\"contents\":[ " +
                "{ \"role\": \"user\", \"parts\": [ { \"text\": \"I have event called: \\\"Thi cấu trúc dữ liệu và giải thuật\\\". Create a list of tasks (include task names and duration; I can only have 8 hours to study in this day) for me to prepare for it. The list of tasks is demonstrated as an array of JSON objects and the duration is in this format 'HH:mm:ss'.\" } ] }, " +
                "{ \"role\": \"model\", \"parts\": [ { \"text\": \"```json\\n[{\\\"task\\\": \\\"Review basic data structures (arrays, linked lists, stacks, queues)\\\", \\\"duration\\\": \\\"02:00:00\\\"}, {\\\"task\\\": \\\"Study trees and binary search trees\\\", \\\"duration\\\": \\\"02:00:00\\\"}, {\\\"task\\\": \\\"Practice sorting algorithms (bubble sort, insertion sort, merge sort)\\\", \\\"duration\\\": \\\"02:00:00\\\"}, {\\\"task\\\": \\\"Learn about searching algorithms (linear search, binary search)\\\", \\\"duration\\\": \\\"02:00:00\\\"}]\\n\\n```\" } ] }, " +
                "{ \"role\": \"user\", \"parts\": [ { \"text\": \"I had done these tasks back in the day: {\\\"task\\\": \\\"Study trees and binary search trees\\\", \\\"duration\\\": \\\"02:00:00\\\"}, {\\\"task\\\": \\\"Practice sorting algorithms (bubble sort, insertion sort, merge sort)\\\", \\\"duration\\\": \\\"02:00:00\\\"}. So, delete these tasks, and find new tasks for me.  I can only have 8 hours to study in this day\" } ] }, " +
                "{ \"role\": \"model\", \"parts\": [ { \"text\": \"```json\\n[{\\\"task\\\": \\\"Review basic data structures (arrays, linked lists, stacks, queues)\\\", \\\"duration\\\": \\\"02:00:00\\\"}, {\\\"task\\\": \\\"Explore graphs and graph algorithms (DFS, BFS)\\\", \\\"duration\\\": \\\"02:00:00\\\"}, {\\\"task\\\": \\\"Learn about dynamic programming and common DP problems\\\", \\\"duration\\\": \\\"02:00:00\\\"}, {\\\"task\\\": \\\"Practice solving algorithmic problems on LeetCode/HackerRank\\\", \\\"duration\\\": \\\"02:00:00\\\"}]\\n\\n```\" } ] }, " +
                "{ \"role\": \"user\", \"parts\": [ { \"text\": \"" + prompt + "\" } ] } " +
                "], \"generationConfig\":{\"temperature\":1.65,\"topK\":64,\"topP\":0.95,\"maxOutputTokens\":8192,\"responseMimeType\":\"application/json\"}}";

        String requestBody2 = "{\"contents\":[ " +
                "{ \"role\": \"user\", \"parts\": [ { \"text\": \"I have event called: \\\"Thi cấu trúc dữ liệu và giải thuật\\\". Create a list of tasks (include task names and duration) I can only have 8 hours to study in this day) for me to prepare for it. The list of tasks is demonstrated as an array of JSON objects and the duration is in this format 'HH:mm:ss'.\\n\" } ] }, " +
                "{ \"role\": \"model\", \"parts\": [ { \"text\": \"```json\\n[{\\\"task\\\": \\\"Review fundamental data structures (arrays, linked lists, stacks, queues)\\\", \\\"duration\\\": \\\"02:00:00\\\"}, {\\\"task\\\": \\\"Study basic sorting algorithms (bubble sort, insertion sort, selection sort)\\\", \\\"duration\\\": \\\"01:30:00\\\"}, {\\\"task\\\": \\\"Learn about searching algorithms (linear search, binary search)\\\", \\\"duration\\\": \\\"01:00:00\\\"}, {\\\"task\\\": \\\"Explore tree data structures (binary trees, binary search trees)\\\", \\\"duration\\\": \\\"01:30:00\\\"}, {\\\"task\\\": \\\"Practice solving coding problems related to data structures and algorithms\\\", \\\"duration\\\": \\\"01:30:00\\\"}, {\\\"task\\\": \\\"Review concepts of time and space complexity\\\", \\\"duration\\\": \\\"00:30:00\\\"}]\\n\\n```\" } ] }, " +
                "{ \"role\": \"user\", \"parts\": [ { \"text\": \"I have event called: \\\"Lập trình hướng đối tượng\\\". Create a list of tasks (include task names and duration) I can only have 10 hours to study in this day) for me to prepare for it. The list of tasks is demonstrated as an array of JSON objects and the duration is in this format 'HH:mm:ss'.\" } ] }, " +
                "{ \"role\": \"model\", \"parts\": [ { \"text\": \"```json\\n[{\\\"task\\\": \\\"Review object-oriented programming concepts (classes, objects, inheritance, polymorphism, encapsulation)\\\", \\\"duration\\\": \\\"02:00:00\\\"}, {\\\"task\\\": \\\"Practice creating classes and objects in your chosen programming language\\\", \\\"duration\\\": \\\"02:00:00\\\"}, {\\\"task\\\": \\\"Explore inheritance and its types (single, multiple, hierarchical, multilevel)\\\", \\\"duration\\\": \\\"01:30:00\\\"}, {\\\"task\\\": \\\"Learn about polymorphism and its implementation (method overriding, method overloading)\\\", \\\"duration\\\": \\\"01:30:00\\\"}, {\\\"task\\\": \\\"Understand encapsulation and its benefits for data security and modularity\\\", \\\"duration\\\": \\\"01:00:00\\\"}, {\\\"task\\\": \\\"Practice implementing abstract classes and interfaces\\\", \\\"duration\\\": \\\"01:00:00\\\"}, {\\\"task\\\": \\\"Explore design patterns related to object-oriented programming (singleton, factory, observer)\\\", \\\"duration\\\": \\\"01:00:00\\\"}, {\\\"task\\\": \\\"Solve coding problems related to object-oriented concepts\\\", \\\"duration\\\": \\\"01:00:00\\\"}]\\n\\n```\" } ] }, " +
                "{ \"role\": \"user\", \"parts\": [ { \"text\": \"try another tasks for \\\"Lập trình hướng đối tượng\\\" (notice that I only have 10 hours to study)\" } ] }, " +
                "{ \"role\": \"model\", \"parts\": [ { \"text\": \"```json\\n[{\\\"task\\\": \\\"Review object-oriented programming fundamentals (classes, objects, encapsulation)\\\", \\\"duration\\\": \\\"02:00:00\\\"}, {\\\"task\\\": \\\"Understand and practice inheritance (single, multiple, hierarchical)\\\", \\\"duration\\\": \\\"02:00:00\\\"}, {\\\"task\\\": \\\"Explore polymorphism and its types (method overriding, method overloading)\\\", \\\"duration\\\": \\\"01:30:00\\\"}, {\\\"task\\\": \\\"Implement abstract classes and interfaces\\\", \\\"duration\\\": \\\"01:00:00\\\"}, {\\\"task\\\": \\\"Learn about common design patterns (Singleton, Factory, Observer)\\\", \\\"duration\\\": \\\"01:00:00\\\"}, {\\\"task\\\": \\\"Practice object-oriented programming with real-world examples\\\", \\\"duration\\\": \\\"01:30:00\\\"}, {\\\"task\\\": \\\"Solve coding exercises and challenges related to OOP concepts\\\", \\\"duration\\\": \\\"01:00:00\\\"}]\\n\\n```\" } ] }, " +
                "{ \"role\": \"user\", \"parts\": [ { \"text\": \"try another tasks for \\\"Thi cấu trúc dữ liệu và giải thuật\\\" (notice that I only have 8 hours to study)\" } ] }, " +
                "{ \"role\": \"model\", \"parts\": [ { \"text\": \"```json\\n[{\\\"task\\\": \\\"Review fundamental data structures (arrays, linked lists, stacks, queues)\\\", \\\"duration\\\": \\\"01:30:00\\\"}, {\\\"task\\\": \\\"Explore tree data structures (binary trees, binary search trees)\\\", \\\"duration\\\": \\\"01:30:00\\\"}, {\\\"task\\\": \\\"Study common sorting algorithms (bubble sort, insertion sort, merge sort, quick sort)\\\", \\\"duration\\\": \\\"02:00:00\\\"}, {\\\"task\\\": \\\"Practice implementing search algorithms (linear search, binary search)\\\", \\\"duration\\\": \\\"01:30:00\\\"}, {\\\"task\\\": \\\"Understand time and space complexity analysis\\\", \\\"duration\\\": \\\"01:00:00\\\"}, {\\\"task\\\": \\\"Solve coding problems related to data structures and algorithms\\\", \\\"duration\\\": \\\"01:00:00\\\"}]\\n\\n```\" } ] }, " +
                "{ \"role\": \"user\", \"parts\": [ { \"text\": \"" + prompt + "\" } ] } " +
                "], \"generationConfig\":{\"temperature\":1.65,\"topK\":64,\"topP\":0.95,\"maxOutputTokens\":8192,\"responseMimeType\":\"application/json\"}}";

        HttpEntity<String> request = new HttpEntity<>(requestBody2, headers);

        // Parse and process the response as needed
        return restTemplate.postForObject(apiUrl, request, String.class);
    }



}
