package sample;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.BreakIterator;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.apache.commons.io.FileUtils;

/**
 * Created by betty.schirrmeister on 13/09/2017.
 */
public class NLP {

   public static void main(String[] args) {

       String myText = readFile("data/ada.txt");
       System.out.println(myText);


       /**String input = "Tophy and Betty are very much in super-love! Tophy's and Betty's favourite drink is beer.";
        String sentence = "My name is Betty Schirrmeister. You may use Dr. before my name, as I have a PhD. I am, however a bit shy to use it.";
        NLP worddetec = new NLP();
        worddetec.useTokenizer(input);
        worddetec.useBreakIterator(input);
        worddetec.useRegex(input);

        NLP sentencedetec = new NLP();
        sentencedetec.useSentenceIterator(sentence);*/
   }

   public static String readFile(String name){
       File file = new File(name);
       String myText;
       myText = null;
       try {
           myText = FileUtils.readFileToString(file, "UTF-8");
       } catch (IOException e) {
           System.out.println("Error reading" + file.getAbsolutePath());
       }
       return myText;
   }



    public String getWords(String input){
       return useTokenizer(input,1) ;
    }

    public String countWords(String input){
        return useTokenizer(input,2) ;
    }

    public String useTokenizer(String input, int mode){
        System.out.println("Tokenizer");
        int i=0;
        StringTokenizer tokenizer =  new StringTokenizer(input);
        String word = "";
        while(tokenizer.hasMoreTokens()){
            i++;
            word += tokenizer.nextToken() + " - ";
           // System.out.print(word+"...");
        }
        if(mode==1){
            return word;}
        else{
            return i+" words ";
        }
    }

    public void useBreakIterator(String input){
        System.out.println("BreakIterator");
        BreakIterator tokenizer = BreakIterator.getWordInstance();
        tokenizer.setText(input);
        int start = tokenizer.first();
        for(int end = tokenizer.next();
            end!=BreakIterator.DONE;
            start = end, end=tokenizer.next()){
            System.out.print(input.substring(start,end)+"...");
        }
        System.out.println();
    }

    public void useRegex(String input){
        System.out.println("Regex");
        Pattern pattern = Pattern.compile("\\w[\\w]+('\\w*)?");
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()){
            System.out.print(input.substring(matcher.start(),matcher.end())+"...");
        }
        System.out.println();
    }

    public void useSentenceIterator(String sentence){
        System.out.println("Sentence detection:");
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.UK);
        iterator.setText(sentence);
        int start = iterator.first();
        for(int end = iterator.next();end!=BreakIterator.DONE;start=end, end = iterator.next()){
            System.out.println(sentence.substring(start,end));
        }
    }
}
