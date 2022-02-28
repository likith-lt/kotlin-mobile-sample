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

### Setting up Your Authentication
Make sure you have your LambdaTest credentials with you to run test automation scripts on LambdaTest Selenium Grid. You can obtain these credentials from the [LambdaTest App Automation Dashboard](https://appautomation.lambdatest.com/build).
**Step 1:** Set LambdaTest `Username` and `Access Key` in environment variables.
  * For **Linux/macOS**:
  ```bash
  export LT_USERNAME="YOUR_USERNAME" export LT_ACCESS_KEY="YOUR_ACCESS_KEY"
  ```
  * For **Windows**:
  ```bash
  set LT_USERNAME="YOUR_USERNAME" set LT_ACCESS_KEY="YOUR_ACCESS_KEY"
  ```
### Generating the app link
* Before you can generate the app link, you need to clone [LambdaTest's Kotlin](https://github.com/likith-lt/kotlin-mobile-sample) repository.
```bash
git clone https://github.com/likith-lt/kotlin-mobile-sample
```
* Now, the LambdaTest's credentials have to be encoded using a [base64 encoder](https://www.base64encode.org/). You need to generate an encoded string of the string `<YOUR_USERNAME>:<YOUR_ACCESS_KEY>`. An example for the same is shown below:
```bash
USERNAME : "user"
ACCESSKEY : "123456abcdef"
String to be encoded : "user:123456abcdef"
Encoded string : "dXNlcjoxMjM0NTZhYmNkZWY="
```
* We will be running our test script on LambdaTest Demo App. The apk of the app `proverbialrk.apk` can be found in the cloned project directory. To generate the app link, you need to run a command of the below format in the terminal and pass the value of `Encoded_string` and the `path of the apk` in the above command:
```bash
curl --location --request POST 'https://manual-api.lambdatest.com/app/upload/realDevice' --header 'Authorization: Basic <Encoded_string>' --form 'name="ProVerbial"' --form 'appFile=@"/path/to/apk"'
```
* On running the command, an `app_url` will be generated as shown below. This URL will be used later in the test capabilities for the tests we will be running on.

