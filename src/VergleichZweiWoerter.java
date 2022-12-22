import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * This is the documentation of a code for comparing two words
 * @author Yolla Hanna
 * @version 1.1
 */
public class VergleichZweiWoerter {
    /**
     * code for comparing two word
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        /**
         * we read the file and save it
         */
        File file = new File("C:\\Users\\Akademie\\IdeaProjects\\untitled\\word.txt");
        String wordFromFile = null;
        List<String> words = new ArrayList<>();

        try {
            Scanner scFile = new Scanner(file);
            while (scFile.hasNextLine()) {
                wordFromFile = scFile.nextLine();
                words.add(wordFromFile);
            }
            scFile.close();
            System.out.println(words);

        } catch (IOException e) {
            e.printStackTrace();

        }
        // choose a word from the list:
        int randomInd = new Random().nextInt(words.size());
        String randomWord = words.get(randomInd);
        char[] randomWordLetters = randomWord.toCharArray();
        assert wordFromFile != null;
        System.out.println("The random word from the file is:  " + Arrays.toString(randomWordLetters));
        System.out.println(randomWord);

        // write a word from keyboard:
        String buchstabenTastatur = null;
        List<String> wortTastaturBuchstabeStringList = new ArrayList<>();
        char[] wortAusTastaturBuchstabe = {};
        // boolean wordsAreTheSame = false;
        //while (wordsAreTheSame = false) {
        //  wordsAreTheSame = true;
        System.out.println("insert a word from keyboard or type ## for exit ");
        System.out.println();
        Scanner scTastatur = new Scanner(System.in);

        try {

            while (scTastatur.hasNext()) { // && !(name = scanner.next()).equals("exit"))
                buchstabenTastatur = scTastatur.next();
                wortTastaturBuchstabeStringList.add(buchstabenTastatur);

                for (int i = 0; i < randomWordLetters.length; i++) {
                    wortAusTastaturBuchstabe = buchstabenTastatur.toCharArray();
                }
                if (buchstabenTastatur.equals("##")) {
                    System.exit(0);
                }
                int length = Math.min(wortAusTastaturBuchstabe.length, randomWordLetters.length);

                for (int i = 0; i < length; i++) {

                    if (wortAusTastaturBuchstabe[i] != randomWordLetters[i]) {
                        //?? Character.toString(wortAusTastaturBuchstabe[i]).replace(wortAusTastaturBuchstabe[i], ' ');
                        wortAusTastaturBuchstabe[i] = ' ';
                        System.out.print(Character.toString(wortAusTastaturBuchstabe[i]));
                        //  wordsAreTheSame = false;
                    } else {
                        System.out.print(wortAusTastaturBuchstabe[i]);
                    }
                }
                System.out.println();
             //   System.out.println(wortTastaturBuchstabeStringList);
            }

            scTastatur.close();

            // System.out.println(wortAusTastaturBuchstabe);

        } catch (IllegalStateException e) {
            e.printStackTrace();
        } finally {
            scTastatur.close();
        }

    }
}


