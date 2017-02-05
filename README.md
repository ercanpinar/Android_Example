# Street Hawk Example Project #

### Application Icon and Name  ###

![ic_launcher.png](https://bitbucket.org/repo/4xpday/images/681013801-ic_launcher.png) **SH Post**

### Application Version ###

* compileSdkVersion 25

* buildToolsVersion "24.0.2"
* applicationId "com.streethawk.example"

* minSdkVersion 16

* targetSdkVersion 25


### Description ###

Send a new post and was developed to display the post sent earlier.

### Screens ###

Implementation occurs on three screens

* **Splash**
* **New Post**
* **All Post**

* **Splash Screen**

This screen was created for the purpose of being checked during application opening and for promotional purposes.

![SplashScreen.png](https://bitbucket.org/repo/4xpday/images/2450788905-SplashScreen.png)


* **New Post Screen**

On this screen, users fill in the required fields and send new posts. If the user enters incomplete information on this screen, warning messages are displayed according to the missing area.
On this screen, the user can be directed to the "ALL POST" page.


![NewPostScreen.png](https://bitbucket.org/repo/4xpday/images/896725399-NewPostScreen.png)

* **All Post Screen**

On this screen, users see previously posted POSTs in a list.

![posts.png](https://bitbucket.org/repo/4xpday/images/3453888552-posts.png)
### Error Tracking ###

* When the user first visits the New Post Posting page, an internet status check is performed and an informing message is given if there is no connection.

* When the user first visits the page where the posted POSTs are displayed, the internet status is checked and an informing message is given if there is no connection.

* The user is generally warned that if there is an internet connection problem in the case of a web service query, the user is not connected to the internet without querying.

* If the user has an error after the web service question, he is warned that an error has occurred.

* If an error occurs while displaying the result from the user web service.
It is warned that an error has occurred.

### Permissions ###

* Internet Connection
* Internet Connection Status Check

### Open Source Libraries  ###

* **[Crouton](https://github.com/keyboardsurfer/Crouton)**

Used for Alert Messages

compile('de.keyboardsurfer.android.widget:crouton:1.8.5@aar') {
    exclude group: 'com.google.android', module: 'support-v4'
}

* **[Loading](https://github.com/81813780/AVLoadingIndicatorView)**

Used for Loading at Opening

compile 'com.wang.avi:library:2.1.3'

* **[Volley](https://github.com/mcxiaoke/android-volley)**

Used for WebService Query

compile 'com.mcxiaoke.volley:library:1.0.19'

* **[Gson](https://github.com/google/gson)**

Used for Web Service responses (JSON)

compile 'com.google.code.gson:gson:2.6.1'

* **[EditTextValidator](https://github.com/vekexasia/android-edittext-validator)**

Used for EditText Validation.

compile('com.andreabaccega:android-form-edittext:1.3.+')

* **[HockeyApp](https://hockeyapp.net)**

Crash test version of the application and follow-up were used for distribution.
 
compile 'net.hockeyapp.android:HockeySDK:3.7.1'

* **Test** 

androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
    exclude group: 'com.android.support', module: 'support-annotations'
})


testCompile 'junit:junit:4.12'

### Application Demo Link ###

You can download and test the application "debug" version in the following address.

[HockeyAppLink - Demo Version
](https://rink.hockeyapp.net/apps/e1b1aa793e7241488c2d586d8e4778f0/)


Note: All crashes that may occur are monitored by this SDK.

Note2: This SDK will download the application from the specified link, then upload the new version to the site and send it to the user for automatic update informing.


### Web Services ###

JSON service.

[**https://jsonplaceholder.typicode.com/**](https://jsonplaceholder.typicode.com/)

 * **Send New Post**  
  
   Request Type POST

  ** https://jsonplaceholder.typicode.com/posts**

Example Request:

```
#!json
{
    "title": "title Text",
    "body": "body Text"
  }
```

Example Response:

```
#!json
{
    "id": 101
  }
```




 * **All Post** 

   Request Type GET

  ** https://jsonplaceholder.typicode.com/posts**

Example Response:


```
#!json

[
  {
    "userId": 1,
    "id": 1,
    "title": "title Text 1",
    "body": "body Text1"
  },
  {
    "userId": 1,
    "id": 2,
    "title": "Title Text2",
    "body": "body Text2"
  }
]
```

### Test Case  ###
 
 * SendNewPostTest
 * ShowPostListTest

Note: Run tests on the actual android device (android version> = 5.0). 
    Device Android Version >= 5.0  (Since it has a DataBinding structure.)

### Version Control  ###

Application source codes are kept on BitBucket and are developed with git.
Commit history is available.
Only **master** branch is working.

###  Android Interview Question  ### 
Create a simple android app that will post some json data to https://jsonplaceholder.typicode.com/ fetch it and display list of all posted items.

Please make sure unittests are included.

Extra creds: make the networking logic a standalone library

Submissions will be evaluated according to code quality, documentation, design and completeness of unit tests. Code must build, run and give correct output.