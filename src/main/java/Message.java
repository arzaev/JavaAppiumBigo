
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Message {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

        List<String> lines = Files.readAllLines(Paths.get("accounts.txt"));
        for (String line: lines) {
            String[] els = line.split(":");
            String phone = els[0];
            String password = els[2];

            BigoAuto bigo = new BigoAuto();
            bigo.setCountry();
            bigo.typeNumber(phone);
            bigo.typePassword(password);
        }
    }
}
