
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Message {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;

        List<String> lines = Files.readAllLines(Paths.get("accounts.txt"));
        for (String line: lines) {
            String phone = null;
            try {
                fh = new FileHandler("MyLogFile.log");
                logger.addHandler(fh);
                SimpleFormatter formatter = new SimpleFormatter();
                fh.setFormatter(formatter);

                String[] els = line.split(":");
                phone = els[0];
                String password = els[2];

                BigoAuto bigo = new BigoAuto();
                bigo.setCountry();
                bigo.typeNumber(phone);
                bigo.typePassword(password);
                bigo.goHome();
                bigo.goFans();

                ArrayList<String> arrListUsernames = new ArrayList<String>();
                for (int i = 0; i < 15; i++) {
                    String msg = GetConfig.message;
                    ArrayList<String> arr = bigo.sendMessages(msg, arrListUsernames);
                    arrListUsernames.addAll(arr);
                }
            } catch (Exception e) {
                logger.warning("Problem with: " + phone);
                e.printStackTrace();
            }

        }
    }
}
