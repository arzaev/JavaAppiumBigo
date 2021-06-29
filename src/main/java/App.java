
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        for (int j = 0; j < 50; j++) {
            BigoAuto bigo = new BigoAuto();
            bigo.signup();
            ApiSmsActivate apiSmsActivate = new ApiSmsActivate("bl", GetConfig.apiSmsActivate);
            String answer = apiSmsActivate.GetNumber();
            String[] elements = answer.split(":");
            String id = elements[1];
            String phoneNumber = new String(elements[2]).substring(1);
            bigo.typeNumber(phoneNumber);
            apiSmsActivate.Ready(id);
            String code = null;
            for (int i = 0; i < 30; i++) {
                TimeUnit.SECONDS.sleep(10);
                code = apiSmsActivate.GetCode(id);
                if (code.equals("STATUS_WAIT_CODE")) {
                    System.out.println(code);
                } else {
                    break;
                }
            }
            if (!code.equals("STATUS_WAIT_CODE")) {
                String[] doneCode = code.split(":");
                bigo.typeCode(doneCode[1]);
                try(PrintWriter output = new PrintWriter(new FileWriter("accounts.txt",true)))
                {
                    String line = phoneNumber + ":" + code;
                    output.printf("%s\r\n", line);
                }
                catch (Exception ignored) {}
                bigo.setProfile();
                // here we have to add follow methods




                int count = 0;
                for (int i = 0; i < 120; i++) {
                    int countFollow = bigo.FollowUsers();
                    count += countFollow;
                    System.out.println(count);
                }


                System.out.println("done");
            } else {
                System.out.println("didn't get phone number");
            }

        }
    }
}
