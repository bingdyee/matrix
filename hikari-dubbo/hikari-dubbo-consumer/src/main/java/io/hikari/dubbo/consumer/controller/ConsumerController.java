package io.hikari.dubbo.consumer.controller;

import io.hikari.dubbo.api.DemoService;
import io.hikari.dubbo.api.pojo.dto.DemoDTO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Noa Swartz
 * @date 2020-04-07
 */
@RestController
@RequestMapping("/api/v1/hikari")
public class ConsumerController {

    @Reference(version = "${dubbo.application.version}")
    private DemoService defaultService;

    @GetMapping
    public ResponseEntity<DemoDTO> doDefault(@RequestParam("message") String message) {
        return ResponseEntity.ok(defaultService.doDefault(message));
    }

}
