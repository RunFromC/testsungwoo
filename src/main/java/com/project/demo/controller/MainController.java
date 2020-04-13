package com.project.demo.controller;

import com.project.demo.repository.jpa.dohwan.UserRepo;
import com.project.demo.service.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @GetMapping("/user")
    public ResponseEntity getUserList() {
        return ResponseEntity.ok(new JSONObject()
                .appendField("result", true)
                .appendField("data", mainService.getUserList()));
    }
}
