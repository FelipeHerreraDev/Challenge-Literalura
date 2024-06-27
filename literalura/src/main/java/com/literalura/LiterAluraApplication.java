package com.literalura;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import com.literalura.controller.ConsoleController;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

  @Autowired
  private ConsoleController consoleController;

  public static void main(String[] args) {
    SpringApplication.run(LiterAluraApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    consoleController.run();
  }
}
