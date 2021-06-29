import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BigoAuto {
    public WebDriverWait wait;
    public AndroidDriver<AndroidElement> driver;


    public BigoAuto() throws MalformedURLException, URISyntaxException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel XL API 30");
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("noReset", "false");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 30);

//        driver.removeApp("sg.bigo.live");
//
//        URL res = getClass().getClassLoader().getResource(GetConfig.bigoApkVersion);
//        assert res != null;
//        File file = Paths.get(res.toURI()).toFile();
//        String absolutePathApk = file.getAbsolutePath();
//
//        driver.installApp(absolutePathApk);
//        driver.startActivity(new Activity("sg.bigo.live", "sg.bigo.live.home.MainActivity"));


    }

    public void signup() {
        By AllowLocationBtn = By.id("sg.bigo.live:id/location_permission_guide_btn");
        By WhileUsingTheApp = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
        By CountriesBtn = By.id("sg.bigo.live:id/ll_area_code");
        By InputCountries = By.id("sg.bigo.live:id/contact_search_et");
        By ClickCountry = By.id("sg.bigo.live:id/tv_country_name");

        wait.until(ExpectedConditions.visibilityOfElementLocated((AllowLocationBtn))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((WhileUsingTheApp))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((CountriesBtn))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((InputCountries))).sendKeys("russia");
        wait.until(ExpectedConditions.visibilityOfElementLocated((ClickCountry))).click();
    }

    public void typeNumber(String phoneNumber) {
        System.out.println(phoneNumber);
        By inputPhoneNumber = By.id("sg.bigo.live:id/et_phone");
        By next = By.id("sg.bigo.live:id/tv_sign_or_login");

        wait.until(ExpectedConditions.visibilityOfElementLocated((inputPhoneNumber))).sendKeys(phoneNumber);
        wait.until(ExpectedConditions.visibilityOfElementLocated((next))).click();
    }

    public void typeCode(String code) {
        By inputCode = By.id("sg.bigo.live:id/et_pin");
        By btnNext = By.id("sg.bigo.live:id/tv_next");
        By inputPassword = By.id("sg.bigo.live:id/et_password");
        By btnSignUp = By.id("sg.bigo.live:id/tv_next");
        wait.until(ExpectedConditions.visibilityOfElementLocated((inputCode))).sendKeys(code);
        wait.until(ExpectedConditions.visibilityOfElementLocated((btnNext))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((inputPassword))).sendKeys(code);
        wait.until(ExpectedConditions.visibilityOfElementLocated((btnSignUp))).click();
    }

    public void setProfile() {
        By avatar = By.id("sg.bigo.live:id/image_avatar");
        By allowPicture = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
        By accessPhoto = By.id("com.android.permissioncontroller:id/permission_allow_button");
        By albom = By.id("sg.bigo.live:id/tv_select_from_album");
        By downloadFolder = By.id("com.google.android.apps.photos:id/image");

        String[] photosXpath = GetConfig.photosXpath;
        int rnd = new Random().nextInt(photosXpath.length);
        By selectPhoto = By.xpath(photosXpath[rnd]);
        By savePhoto = By.id("sg.bigo.live:id/clip_image_save");
        By inputUsername = By.id("sg.bigo.live:id/et_nickname"); // sens Chloe
        By choiceFemale = By.id("sg.bigo.live:id/female");
        By hometown = By.id("sg.bigo.live:id/hv_hometown");
        By inputCountry = By.id("sg.bigo.live:id/contact_search_et"); // send united states
        By clickCountry = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[1]");
        By confirmCountry = By.id("android:id/button1");
        By birthday = By.id("sg.bigo.live:id/birthday");
        By year = By.id("android:id/date_picker_header_year");
        By clickYear = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.ScrollView/android.widget.ViewAnimator/android.widget.ListView/android.widget.TextView[7]");
        By confirmBirth = By.id("android:id/button1");
        By next = By.id("sg.bigo.live:id/sign_next");
        By tvClose = By.id("sg.bigo.live:id/tv_close");

        wait.until(ExpectedConditions.visibilityOfElementLocated((avatar))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((allowPicture))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((accessPhoto))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((albom))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((downloadFolder))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((selectPhoto))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((savePhoto))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated((inputUsername))).sendKeys("Chloe");
        wait.until(ExpectedConditions.visibilityOfElementLocated((choiceFemale))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((hometown))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((inputCountry))).sendKeys("united states");
        wait.until(ExpectedConditions.visibilityOfElementLocated((clickCountry))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((confirmCountry))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((birthday))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((year))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((clickYear))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((confirmBirth))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((next))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((tvClose))).click();
    }

    public void SearchUser(String user) {
        By home = By.id("sg.bigo.live:id/home_theme_live_h");
        By search = By.id("sg.bigo.live:id/iv_search");
        By inp = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
                "android.widget.FrameLayout/android.widget.LinearLayout/" +
                "android.widget.FrameLayout/android.widget.RelativeLayout/" +
                "android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText");
        By searchUsername = By.id("sg.bigo.live:id/tv_search");
        By clickUser = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView");
        By fans = By.id("sg.bigo.live:id/fans_fans_title");

        wait.until(ExpectedConditions.visibilityOfElementLocated((home))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((search))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((inp))).sendKeys(user);
        wait.until(ExpectedConditions.visibilityOfElementLocated((searchUsername))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((clickUser))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((fans))).click();

    }

//    public void followUsers(int idUser) {
//        By home = By.id("sg.bigo.live:id/home_theme_live_h");
//        By search = By.id("sg.bigo.live:id/iv_search");
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated((home))).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated((search))).click();
//
//        By inp = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText");
//        By searchUsername = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView");
//        By follow = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.ImageView");
//        String s;
//        for (int j = 0; j < 1000; j++) {
//            System.out.println(j);
//            try {
//                s = Integer.toString(idUser);
//                wait.until(ExpectedConditions.visibilityOfElementLocated((inp))).sendKeys(s);
//                wait.until(ExpectedConditions.visibilityOfElementLocated((searchUsername))).click();
//                wait.until(ExpectedConditions.visibilityOfElementLocated((follow))).click();
//                idUser++;
//            } catch (Exception ignored) {
//                try {
//                    By back = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
//                    wait.until(ExpectedConditions.visibilityOfElementLocated((back))).click();
//                    idUser++;
//                } catch (Exception e) {
//                    idUser++;
//                }
//
//            }
//        }
//    }

    public int FollowUsers() {
        int countFollow = 0;
        ArrayList<String> arSkip = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) {
            String numberUser = Integer.toString(i);
            try {
                By userFollow = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
                        "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
                        "android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/" +
                        "android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
                        "android.widget.LinearLayout[" + numberUser + "]/android.widget.LinearLayout/android.widget.ImageView");
                driver.findElement(userFollow).click();
                countFollow++;
                arSkip.clear();
            } catch (Exception e) {
                try {
                    driver.findElement(By.id("sg.bigo.live:id/cancel_action")).click();
                } catch (Exception s) {
                    System.out.println("skip");
                    arSkip.add("1");
                    if (arSkip.size() == 10) {
                        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
                        arSkip.clear();
                    }
                }
            }
        }
        ScrollDown();
        return countFollow;
    }

    private void ScrollDown() {
        for (int i = 0; i < 2; i++) {
            Dimension size = driver.manage().window().getSize();
            int width = (int)(size.width/2);
            int startPoint = (int) (size.getHeight() * 0.80);
            int endPoint = (int) (size.getHeight() * 0.20);
            new TouchAction((PerformsTouchActions) driver)
                    .press(PointOption.point(width, startPoint))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(width, endPoint))
                    .release().perform();
        }

    }
}
