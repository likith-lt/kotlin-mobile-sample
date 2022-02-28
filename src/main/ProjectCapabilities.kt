import org.openqa.selenium.remote.DesiredCapabilities

class ProjectCapabilities {
    companion object {
        fun AndroidBaseCapabilities(): DesiredCapabilities {
            val caps = DesiredCapabilities()
            caps.setCapability("platformName", "ios")
            caps.setCapability("deviceName", "iPhone X")
            caps.setCapability("isRealMobile", true)
            caps.setCapability("platformVersion", "14")
            caps.setCapability("build", "Proverbial Android Kotlin V1")
            caps.setCapability("app", "lt://APP10020521645780627166619")
            caps.setCapability("deviceOrientation", "PORTRAIT")
            caps.setCapability("console", true)
            caps.setCapability("network", true)
            caps.setCapability("visual", true)
            return caps
        }
    }
}