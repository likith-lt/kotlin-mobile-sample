import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.junit.Test
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.MalformedURLException
import java.net.URL

//var caps: DesiredCapabilities? = ProjectCapabilities.AndroidBaseCapabilities()

var userName = "likithk"
var accessKey = "JDsfvzXYiWz4nMH9fqryRcSt5Wo5lZu7TzRwZEi0ypitlXcf9M"

@Throws(MalformedURLException::class, InterruptedException::class)
fun main(args: Array<String>) {
    val capabilities = DesiredCapabilities()
    capabilities.setCapability("platformName", "android")
    capabilities.setCapability("deviceName", "Galaxy S20")
    capabilities.setCapability("isRealMobile", true)
    capabilities.setCapability("platformVersion", "11")
    capabilities.setCapability("build", "Proverbial Android V1")
    capabilities.setCapability("app", "lt://APP10020521646037418628567")
    capabilities.setCapability("deviceOrientation", "PORTRAIT")
    capabilities.setCapability("console", true)
    capabilities.setCapability("network", true)
    capabilities.setCapability("visual", true)
    val driver = AppiumDriver<MobileElement>(
        URL("https://$userName:$accessKey@beta-hub.lambdatest.com/wd/hub"),
        capabilities
    )
    try {
        val color = driver.findElementById("com.lambdatest.proverbial:id/color") as MobileElement
        //Changes color
        color.click()
        //Back to black color
        color.click()
        val text = driver.findElementById("com.lambdatest.proverbial:id/Text") as MobileElement
        //Changes the text to proverbial
        text.click()

        //toast is visible
        val toast = driver.findElementById("com.lambdatest.proverbial:id/toast").click()
        //toast.click()

        //notification is visible
        val notification = driver.findElementById("com.lambdatest.proverbial:id/notification") as MobileElement
        notification.click()

        //Open the geolocation page
        val geo = driver.findElementById("com.lambdatest.proverbial:id/geoLocation") as MobileElement
        geo.click()
        Thread.sleep(5000)

        //
        //Takes back
        //driver.navigate().back();

        //takes back to home page
        val home = driver.findElementByAccessibilityId("Home") as MobileElement
        home.click()

        //Takes to speed test page
        val speedtest = driver.findElementById("com.lambdatest.proverbial:id/speedTest") as MobileElement
        speedtest.click()
        Thread.sleep(10000)
        val el10 =
            driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[3]/android.view.View[1]/android.view.View/android.widget.Button") as MobileElement
        el10.click()
        Thread.sleep(25000)
        val el11 =

            driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Home\"]/android.widget.FrameLayout/android.widget.ImageView") as MobileElement
        el11.click()
        Thread.sleep(7000)

        //Opens the browser
        val browser = driver.findElementByAccessibilityId("Browser") as MobileElement
        browser.click()
        val el13 = driver.findElementById("com.lambdatest.proverbial:id/url") as MobileElement
        el13.sendKeys("https://www.lambdatest.com")
        val el14 = driver.findElementById("com.lambdatest.proverbial:id/find") as MobileElement
        el14.click()
    } catch (e: Exception) {
        (driver as JavascriptExecutor).executeScript("lambda-status=failed")
        e.printStackTrace()
    }
    // The driver.quit statement is required, otherwise the test continues to execute, leading to timeout
    driver.quit()
}
