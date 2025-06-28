package com.jmg.tondeuse.adapter.in.web.controller;

import com.jmg.tondeuse.adapter.in.rest.dto.MowerResult;
import com.jmg.tondeuse.adapter.in.rest.dto.Order;
import com.jmg.tondeuse.adapter.in.rest.mapper.GardenMapper;
import com.jmg.tondeuse.adapter.in.rest.mapper.MowerMapper;
import com.jmg.tondeuse.application.services.action.Mow;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mowerorder")
public class MowerOrderController {
    private final Mow mow;
    private final GardenMapper gardenMapper;
    private final MowerMapper mowerMapper;

    public MowerOrderController(Mow mow, GardenMapper gardenMapper, MowerMapper mowerMapper) {
        this.mow = mow;
        this.gardenMapper = gardenMapper;
        this.mowerMapper = mowerMapper;
    }

    @PostMapping
    public ResponseEntity<MowerResult> order(@Valid @RequestBody Order request) {
        return ResponseEntity.ok(mowerMapper.toResult(mow.start(gardenMapper.toGarden(request))));
    }
}
