package com.telenor.greeting.account;

import com.telenor.greeting.account.model.AccountType;
import com.telenor.greeting.account.model.Type;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

import static com.telenor.greeting.account.model.AccountType.BUSINESS;
import static com.telenor.greeting.account.model.AccountType.PERSONAL;
import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/account/")
public class AccountGreetingApi {

    @GetMapping("{accountType}/id/{id}")
    public ResponseEntity<String> greatUser(@NotNull @PathVariable("accountType") String accountType,
                                            @PathVariable("id") Integer id) {
        if (isPositive(id)) {
            return badRequest().build();
        }

        if(isNotValidAccountType(accountType)) {
            return badRequest().build();
        }

        if (PERSONAL.value().equals(accountType)) {
            return ok("Hi, userId " + id);
        }
        return notFound().build();
    }

    @GetMapping("{accountType}/type/{type}")
    public ResponseEntity<String> greatUserWithType(@PathVariable("accountType") String accountType,
                                                    @PathVariable("type") String type) {
        if (isNotValidAccountType(accountType)) {
            return badRequest().build();
        }
        if (isNotValidType(type)) {
            return badRequest().build();
        }
        if (BUSINESS.value().equals(accountType) &&
                "big".equals(type)) {
            return ok("Welcome, business user!");
        }
        return notFound().build();
    }

    private boolean isPositive(@PathVariable("id") Integer id) {
        return id <= 0;
    }

    private boolean isNotValidAccountType(String accountType) {
        return AccountType.stream()
                .noneMatch(type -> type.value().equals(accountType));
    }

    private boolean isNotValidType(String type) {
        return Type.stream()
                .noneMatch(t -> t.value().equals(type));
    }
}
