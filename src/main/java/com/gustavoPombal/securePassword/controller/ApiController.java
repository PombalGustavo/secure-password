package com.gustavoPombal.securePassword.controller;

import com.gustavoPombal.securePassword.controller.dto.BodyRequest;
import com.gustavoPombal.securePassword.service.ValidateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    public final ValidateService validateService;

    public ApiController(ValidateService validateService) {
        this.validateService = validateService;
    }

    @PostMapping("/validate-password")
    public ResponseEntity<String> isSafe(@RequestBody BodyRequest bodyRequest) {

        String failures = validateService.validate(bodyRequest.password());

        if (!failures.isEmpty()) {
            return ResponseEntity.badRequest().body(failures);
        }

        return ResponseEntity.noContent().build();
    }

}
