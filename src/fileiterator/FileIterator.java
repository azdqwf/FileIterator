package fileiterator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class FileIterator implements Iterator<String> {
    private BufferedReader in;
    private String string;

    FileIterator(String file) {
        try  {
            in = new BufferedReader(new FileReader(new File(file)));
            string = in.readLine();
        } catch (IOException ex) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public boolean hasNext() {
        return string != null;
    }

    @Override
    public String next() {
        String returnString = string;
        try {
            if (!hasNext()) {
              string = "";
            } else {
                string = in.readLine();
                if (string == null && in != null) {
                    in.close();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return returnString;
    }
}
