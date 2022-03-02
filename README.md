# Kotlin with Appium: Tutorial to run your first test on Lambdatest
***

In this topic, you will learn how to configure and run your Kotlin automation test scripts on [LambdaTest Real Device Cloud platform](https://www.lambdatest.com/real-device-cloud).

## Objective
***
By the end of this topic, you will be able to:

1. Set up an environment for testing your apps using **Kotlin** with **Appium**.
2. Understand and configure the core capabilities required for your Appium test suite.
3. Test your locally hosted pages on LambdaTest platform.
4. Explore advanced features of LambdaTest. 

>**Note:** All the code samples in this documentation can be found in the [LambdaTest's Repository on GitHub](https://github.com/likith-lt/kotlin-mobile-sample). You can either download or clone the repository to quickly run your tests.

## Prerequisites
***
Before you can start performing automation testing on LambdaTest platform, you would need to:
* Install an **IDE** for running the **Kotlin** project. It's recommended to use **IntelliJ Idea** which can be downloaded from [here](https://www.jetbrains.com/idea/download).
* Install the required **Gradle** dependencies required to run the project in the IDE.
* Clone the [LambdaTest's Kotlin](https://github.com/likith-lt/kotlin-mobile-sample) repository.
    ```bash
    git clone https://github.com/likith-lt/kotlin-mobile-sample
    ```

### Setting up Your Authentication
Make sure you have your LambdaTest credentials with you to run test automation scripts on LambdaTest Selenium Grid. You can obtain these credentials from the [LambdaTest App Automation Dashboard](https://appautomation.lambdatest.com/build). 

* Set LambdaTest `Username` and `Access Key` in `src/test/kotlin/Proverbial.kt` of the cloned project directory.
```bash
var userName = "YOUR_USERNAME"
var accessKey = "YOUR_ACCESS_KEY"
```
### Generating the app link
* Before we can generate the app link, the LambdaTest's credentials have to be encoded using a [base64 encoder](https://www.base64encode.org/). You need to generate an encoded string of the string `<YOUR_USERNAME>:<YOUR_ACCESS_KEY>`. An example for the same is shown below:
```bash
USERNAME : "user"
ACCESSKEY : "123456abcdef"
String to be encoded : "user:123456abcdef"
Encoded string : "dXNlcjoxMjM0NTZhYmNkZWY="
```
* We will be running our test script on LambdaTest Demo App. The apk of the app `proverbialrk.apk` can be downloaded from [here](https://prod-mobile-artefacts.lambdatest.com/assets/docs/proverbial_android.apk). To generate the app link, you need to run a command of the below format in the terminal and pass the value of `Encoded_string` and also the `path of the apk` which is downloaded to your system :
```bash
curl --location \
--request POST 'https://manual-api.lambdatest.com/app/upload/realDevice' \
--header 'Authorization: Basic <Encoded_string>' \
--form 'name="ProVerbial"' \
--form 'appFile=@"/path/to/apk"'
```
* On running the command, an `app_url` will be generated as shown below. This URL will be used later in the test capabilities for the tests we will be running on.

![alt text](https://github.com/likith-lt/kotlin-mobile-sample/blob/main/images/app_url.png?raw=true)

## Run Your First Test
***
### Sample Test with Kotlin
Navigate to `src/test/kotlin/Proverbial.kt` to check the Kotlin test script.
```kotlin
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.junit.Test
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.MalformedURLException
import java.net.URL

//var caps: DesiredCapabilities? = ProjectCapabilities.AndroidBaseCapabilities()

var userName = System.getenv("LT_USERNAME");
var accessKey = System.getenv("LT_ACCESS_KEY");

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
```
### Configuration of Your Test Capabilities
In `src/main/ProjectCapabilities.kt`, you need to update your test capabilities. Here you also need to set your "app_url" that was generated earlier in the `app` capabaility. The capabilities used for the test are defined as:
```kotlin
    val capabilities = DesiredCapabilities()
        capabilities.setCapability("platformName", "android")
        capabilities.setCapability("deviceName", "Galaxy S20")
        capabilities.setCapability("isRealMobile", true)
        capabilities.setCapability("platformVersion", "11")
        capabilities.setCapability("build", "Proverbial Android V1")
        capabilities.setCapability("app", "app_url") // set the "app_url" here
        capabilities.setCapability("deviceOrientation", "PORTRAIT")
        capabilities.setCapability("console", true)
        capabilities.setCapability("network", true)
        capabilities.setCapability("visual", true)
```
> **Note:** You can generate capabilities for your test requirements with the help of our inbuilt **[Capabilities Generator tool](https://www.lambdatest.com/capabilities-generator/)**.


### Executing the Test
In the IntelliJ Idea, you need to navigate to `src/test/kotlin/Proverbial.kt` and run that file to execute the tests on the LambdaTest platform.
![alt text](https://github.com/likith-lt/kotlin-mobile-sample/blob/main/images/run.png?raw=true)

Your test results would be displayed on the test console (or command-line interface if you are using terminal/cmd) and on [LambdaTest automation dashboard](https://accounts.lambdatest.com/login). LambdaTest Automation Dashboard will help you view all your text logs, screenshots and video recording for your entire automation tests.
