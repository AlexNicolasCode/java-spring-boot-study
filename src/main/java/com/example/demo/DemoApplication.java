package com.example.demo;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {
    public static void main(String[] args) {
      SpringApplication.run(DemoApplication.class, args);
    }
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
	  if (name.equals("test")) {
		  return String.format("test is running!");
	  }
      return String.format("Hello %s!", name);
    }

    @GetMapping("/list")
    public ResponseEntity<int[]> list() {
	  int array[] = { 10, 20, 30, 40, 50 };
      return ResponseEntity.ok(array);
    }

    @GetMapping("/list/{intNumber}")
    public ResponseEntity<Integer> listGetItem(@PathVariable(value="intNumber") int intNumber) {
	  int[] array = { 10, 20, 30, 40, 50 };
	  for (int i = 0; i < array.length; i++) {
		if (array[i] == intNumber) {
			return ResponseEntity.ok(array[i]);
		}
	  }
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping("/list")
    public ResponseEntity<List<Integer>> listAddItem(@RequestBody int newInt) {
	  List<Integer> list = new ArrayList<Integer>();
	  list.add(newInt);
      return ResponseEntity.ok(list);
    }
}