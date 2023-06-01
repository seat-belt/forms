package com.example.handlingformsubmission;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.opencsv.*;
import java.util.Iterator;


public class Greeting {
  private List<String> questions;
  private String q1;
  private int q2;
  private int q3;
  private int q4;
  private int q0; 

  private Map<String, Integer> answers;

  public Map<String, Integer> getAnswers() {
    return answers;
  }

  public void setAnswers(Map<String, Integer> answers) {
    this.answers = answers;
  }

  public List<String> getQuestions() {
    return questions;
  }

  public void setQuestions(List<String> questions) {
    this.questions = questions;
  }

  public String getQ1() {
    return q1;
  }

  public void setQ1(String q1) {
    this.q1 = q1;
  }

  public int getQ2() {
    return q2;
  }

  public void setQ2(int q2) {
    this.q2 = q2;
  }

  public int getQ3() {
    return q3;
  }

  public void setQ3(int q3) {
    this.q3 = q3;
  }

  public int getQ4() {
    return q4;
  }

  public void setQ4(int q4) {
    this.q4 = q4;
  }

  public int getQ0() {
    return q0;
  }

  public void setQ0(int q0) {
    this.q0 = q0;
  }

  // public List<String> loadQuestionsFromCSV() {
	// List<String> questions = new ArrayList<>();
	// try (InputStream inputStream = getClass().getResourceAsStream("/questions.csv");
	// 	 BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
	//   String line;
	//   while ((line = br.readLine()) != null) {
	// 	questions.add(line);
	//   }
	// } catch (IOException e) {
	//   e.printStackTrace();
	// }
	// return questions;
  // }
  public List<String> loadQuestionsFromCSV() {
    List<String> questions = new ArrayList<>();
    try (InputStream inputStream = getClass().getResourceAsStream("/questions.csv");
         BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
        String line;
        while ((line = br.readLine()) != null) {
            questions.add(line);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return questions;
}


// public void saveAnswersToCSV(String filePath) {
//   File file = new File(filePath);
//   boolean fileExists = file.exists();

//   try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
//       if (!fileExists) {
//           // Write the header for the CSV file
//           writer.println("form:");
//       }
//       writer.println("BRID: "+getQ1());
//       for (Map.Entry<String, Integer> entry : answers.entrySet()) {
//           String question = entry.getKey();
//           int answer = entry.getValue();
//           writer.println("questCode:" + question + " ansCode:" + answer);
//       } writer.println("");
//   } catch (IOException e) {
//       e.printStackTrace();
//   }
// }
// public void saveAnswersToCSV(String filePath, Map<String, Integer> answers, List<String> questions) {
//   try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
//       // Append the answers to the CSV file
//       if (!questions.isEmpty()) {
//           writer.print("question,");
//           for (int i = 1; i <= questions.size(); i++) {
//               writer.print("q" + i + ",");
//           }
//           writer.println();
//       }
//       writer.print("text,");
//       for (String question : questions) {
//           writer.print(question + ",");
//       }
//       writer.println();
//       writer.print("answer,");
//       for (String question : questions) {
//           Integer answer = answers.getOrDefault(question, 0);
//           writer.print(answer + ",");
//       }
//       writer.println();
//   } catch (IOException e) {
//       e.printStackTrace();
//   }
// }

public void saveAnswersToCSV(String filePath, Map<String, Integer> answers, List<String> questions) {
  try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
      // Append the answers to the CSV file
      // if (!questions.isEmpty()) {
          
      //     for (int i = 1; i <= questions.size(); i++) {
      //         writer.print("question: ");
      //         writer.print("q" + i);
      //     }
      //     writer.println();
      // }
      writer.println("BRID: "+q1);
      int i=1;
      Iterator<String> questionIterator = questions.iterator();
      // for (String question : questions) {
        for (Map.Entry<String, Integer> entry : answers.entrySet()) {
          // String question = entry.getKey();
          //String question;
          int answer = entry.getValue();
          String question="";
          if (questionIterator.hasNext()) {
            question = questionIterator.next();
          
            writer.print("question: ");
            writer.println("q" + i);
            writer.print("text: ");
            writer.println(question);
            writer.print("answer: ");
            // Integer answer = answers.getOrDefault(question, 0);
            writer.println(answer);
            writer.println();
            i++;
          }
          
      }
      

  } catch (IOException e) {
      e.printStackTrace();
  }
}


}