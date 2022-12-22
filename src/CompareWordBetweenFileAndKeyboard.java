
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;

import static java.lang.Math.min;


public class CompareWordBetweenFileAndKeyboard {
    List<String> words;
    public CompareWordBetweenFileAndKeyboard(){
        this.words=new ArrayList<>();
    }
    public char[] getRandomWordFromList(List<String> words) {
        //int i =Integer.parseInt( Math.floor(Math.random() * words.size());//double

        int randomIndex = new Random().nextInt(words.size());
        System.out.println("the random word from list is: ");

        return words.get(randomIndex).toCharArray();

    }

    public char[] wordFromKeyboard() {
        Scanner sc = new Scanner(System.in);
        //System.out.println("write a word: \n");
        while (sc.hasNextLine()) {
            return sc.next().toCharArray();
        }
        sc.close();
        return sc.next().toCharArray();
    }
    public boolean vergleich() {

        List<String> words = new ArrayList<>();
        System.out.println(" both words are the same " + Arrays.equals(wordFromKeyboard(), getRandomWordFromList(words)));
        // return wordFromKeyboard().toString().compareTo(getRandomWordFromList(words).toString());
        return Arrays.equals(wordFromKeyboard(), getRandomWordFromList(words));
    }

    public String setTheNewWord(char[] wKeyboard, char[] wList) {
        StringBuilder newWord = new StringBuilder();
        if (!vergleich()) {
            int wordLength = min(wList.length, wKeyboard.length);//wList.length && i < wKeyboard.length
            for (int i = 0; i < wordLength; i++) {
                //if (wList.length < wKeyboard.length) {
                    if (wList[i] == wKeyboard[i]) {
                        newWord.append(Character.toString(wList[i]));

                    } else {
                        newWord = new StringBuilder(Character.toString(wList[i]).replace(wList[i], ' '));
                    }
                //}
            }

            getRandomWordFromList( words);//if words are the same then get a word from the list and go on
            wordFromKeyboard();
            vergleich();
            setTheNewWord(wKeyboard,wList);

        }
        wordFromKeyboard();
        return newWord.toString();

    }

    public static void main(String[] args) throws IOException {

        //URL url = new URL("https://gist.github.com/dracos/dd0668f281e685bad51479e5acaadb93");
        //URL url = new URL("https://elearning.uni-bremen.de/sendfile.php?type=0&file_id=b7044d4e1a911fcc1e06ee3bde34545b&file_name=valid-wordle-words.txt");
        // URL url = new URL("https://gist.github.com/dracos/dd0668f281e685bad51479e5acaadb93#file-valid-wordle-words-txt");
        String word;
        List<String> words = new ArrayList<>();
        //File file=new File( "https://gist.github.com/dracos/dd0668f281e685bad51479e5acaadb93");//??
        File file = new File("C:\\Users\\Akademie\\IdeaProjects\\untitled\\word.txt");
       // InputStream in = null;
        try {
            //  in = url.openStream();
            // FileReader(file);
            Scanner sc = new Scanner(file);//new Scanner(in)
            while (sc.hasNextLine()) {
                word = sc.nextLine();
                words.add(word);
            }
            sc.close();

            System.out.println(words);
        } catch (IOException e) {
            e.printStackTrace();

        }
        /*finally {
            if (in != null) {
                in.close();
            }
        }*/
        CompareWordBetweenFileAndKeyboard c = new CompareWordBetweenFileAndKeyboard();
        System.out.println(c.getRandomWordFromList(words));

        System.out.println(c.wordFromKeyboard());
        System.out.println(c.vergleich());
        System.out.println(c.setTheNewWord(c.wordFromKeyboard(), c.getRandomWordFromList(words)));
    }
}