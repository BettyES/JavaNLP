package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static sample.NLP.readFile;

public class SampleController {
    public Label getWords;
    public Label countWords;
    public TextField test;
    public String input;
    public Label getText;

    public void getText(ActionEvent actionEvent){
        String name = test.getText();
        input = readFile(name);
        getText.setText("Text uploaded!");
    }

    public void getWords(ActionEvent actionEvent) {
       // String[] args = new String[] { };
       // NLP.main(args);
        NLP worddetec = new NLP();
        String words = worddetec.getWords(input);
        getWords.setText(words);
    }

    public void countWords(ActionEvent actionEvent) {
        NLP worddetec = new NLP();
        String words = worddetec.countWords(input);
        countWords.setText(words);
    }

}
