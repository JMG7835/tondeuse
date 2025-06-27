package com.jmg.tondeuse.adapter.in.web.controller;

import com.jmg.tondeuse.adapter.in.rest.dto.FieldJson;
import com.jmg.tondeuse.adapter.in.rest.dto.MowerOrder;
import com.jmg.tondeuse.adapter.in.rest.dto.MowerResult;
import jakarta.validation.Valid;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/mowerorder")
@Slf4j
public class MowerOrderController {
    @PostMapping
    public ResponseEntity<MowerResult> order(@Valid @RequestBody MowerOrder request) {
        log.info("order {}",request.getField().toString());
        return ResponseEntity.ok(new MowerResult(new ArrayList<>()));
    }
}
