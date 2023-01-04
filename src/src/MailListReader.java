package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;

public class MailListReader {

    private static final String REGEX = "^[a-zA-Z0-9_!#$%&â€™*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    public static List<String> read(String fileName) {
        List<String> mails = new ArrayList<String>();
        File file = new File(fileName);
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                if (Pattern.compile(REGEX).matcher(data).matches()) {
                    mails.add(data);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return mails;
    }
}
