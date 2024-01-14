package com.gnusho.practice.api.controller;

import com.gnusho.practice.api.dto.ReqPostA;
import com.gnusho.practice.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("a")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @PostMapping()
    public ResponseEntity<?> createA(@RequestBody ReqPostA reqPostA) throws Exception {
        testService.createA(reqPostA);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{pkA}")
    public ResponseEntity<?> getA(@PathVariable Long pkA) {

        return ResponseEntity.ok(testService.getA(pkA));
    }

    @GetMapping()
    public ResponseEntity<?> getAList() {

        return ResponseEntity.ok(testService.getAList());
    }

    @PutMapping("/{pkA}")
    public ResponseEntity<?> putA(@PathVariable Long pkA, @RequestBody ReqPostA reqPutA) {
        testService.modifyA(pkA, reqPutA);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{pkA}")
    public ResponseEntity<?> deleteA(@PathVariable Long pkA) {
        testService.deleteA(pkA);
        return ResponseEntity.ok().build();
    }
}
