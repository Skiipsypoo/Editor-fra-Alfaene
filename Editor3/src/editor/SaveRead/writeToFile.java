package editor.SaveRead;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class writeToFile {
    public void addToFile(char c){
        System.out.println(c);
    try {
        FileWriter writer = new FileWriter("test.txt", true);
        try(BufferedWriter bufferedWriter = new BufferedWriter(writer)){

            bufferedWriter.write(c);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }


    }

}
