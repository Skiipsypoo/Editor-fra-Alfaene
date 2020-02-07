package editor.SaveRead;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class writeToFile {
    File file = new File("temp.txt");
    public void addToFile(char c){

    try {

        FileWriter writer = new FileWriter(file, true);

        try(BufferedWriter bufferedWriter = new BufferedWriter(writer)){

            bufferedWriter.write(c);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }


    }

}
