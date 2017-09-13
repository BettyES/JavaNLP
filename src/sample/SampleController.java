package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SampleController {
    public Label getWords;
    public Label countWords;
    public TextField test;


    public void getWords(ActionEvent actionEvent) {
       // String[] args = new String[] { };
       // NLP.main(args);
        String input = test.getText();
        //String input = "Tophy and Betty are very much in super-love! Tophy's and Betty's favourite drink is beer.";
       // getWords.setText(input);
        NLP worddetec = new NLP();
        String words = worddetec.getWords(input);
        getWords.setText(words);
    }

    public void countWords(ActionEvent actionEvent) {
        String input = test.getText();
        NLP worddetec = new NLP();
        String words = worddetec.countWords(input);
        countWords.setText(words);
    }

   /** public static void main(String[] args){
        String input = "Tophy and Betty are very much in super-love! Tophy's and Betty's favourite drink is beer.";
        String sentence = "My name is Betty Schirrmeister. You may use Dr. before my name, as I have a PhD. I am, however a bit shy to use it.";
        NLP worddetec = new NLP();
        worddetec.useTokenizer(input);
        worddetec.useBreakIterator(input);
        worddetec.useRegex(input);

        NLP sentencedetec = new NLP();
        sentencedetec.useSentenceIterator(sentence);
    }*/

}
