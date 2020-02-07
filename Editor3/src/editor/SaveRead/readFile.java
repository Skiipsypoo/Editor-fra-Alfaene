package editor.SaveRead;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class readFile {
    public readFile(String filename){


    }
    /**
    *  Ikke i bruk enda
    * @author krisRein
    **/
    public String read(){
        try {
            FileReader reader = new FileReader( "temp.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;

            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
                return line;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
