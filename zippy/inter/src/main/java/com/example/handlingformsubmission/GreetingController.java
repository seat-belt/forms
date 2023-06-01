package com.example.handlingformsubmission;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List; // Add this import statement
import java.util.Map;

@Controller
public class GreetingController {

  @Value("classpath:questions.csv")
  private Resource questionsCsv;
  private List<String> questions;
//   @GetMapping("/greeting")
// public String greetingForm(Model model) {
//   Greeting greeting = new Greeting();
//   List<String> questions = greeting.loadQuestionsFromCSV();
//   model.addAttribute("greeting", greeting);
//   model.addAttribute("questions", questions);
//   return "greeting";
// }
@GetMapping("/greeting")
public String greetingForm(Model model) {
    Greeting greeting = new Greeting();
    questions = greeting.loadQuestionsFromCSV();
    model.addAttribute("greeting", greeting);
    model.addAttribute("questions", questions);
    return "greeting";
}
  // @PostMapping("/greeting")
  // public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
  //   model.addAttribute("greeting", greeting);
  //    // Save answers to CSV
  //    greeting.saveAnswersToCSV("C:\\Users\\AFRIN\\codeprojects\\cee\\gs-handling-form-submission\\complete\\src\\main\\java\\com\\example\\handlingformsubmission\\answers.csv");
  //   return "result";
  // }
  @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);

        // Save the answers to CSV
        String filePath = "C:\\Users\\AFRIN\\codeprojects\\cee\\gs-handling-form-submission\\inter\\src\\main\\java\\com\\example\\handlingformsubmission\\answers.csv";
        greeting.saveAnswersToCSV(filePath, greeting.getAnswers(), questions);

        return "result";
    }

}