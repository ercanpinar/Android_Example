# Street Hawk Example Project #

### Application Name  ###

SH Post

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

* Splash
* New Post
* All Post

* Splash Screen
This screen was created for the purpose of being checked during application opening and for promotional purposes.

* New Post Screen
On this screen, users fill in the required fields and send new posts. If the user enters incomplete information on this screen, warning messages are displayed according to the missing area.
On this screen, the user can be directed to the "ALL POST" page.

* All Post Screen
On this screen, users see previously posted POSTs in a list.

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

* **Crouton**

Used for Alert Messages

compile('de.keyboardsurfer.android.widget:crouton:1.8.5@aar') {
    exclude group: 'com.google.android', module: 'support-v4'
}

* **Loading**

Used for Loading at Opening

compile 'com.wang.avi:library:2.1.3'

* **Volley**

Used for WebService Query

compile 'com.mcxiaoke.volley:library:1.0.19'

* **Gson**

Used for Web Service responses (JSON)

compile 'com.google.code.gson:gson:2.6.1'

* **EditTextValidator**

Used for EditText Validation.

compile('com.andreabaccega:android-form-edittext:1.3.+')

* **HockeyApp**

Crash test version of the application and follow-up were used for distribution.
 
compile 'net.hockeyapp.android:HockeySDK:3.7.1'

* **Test** 

androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
    exclude group: 'com.android.support', module: 'support-annotations'
})


testCompile 'junit:junit:4.12'




###  Android Interview Question  ### 
Create a simple android app that will post some json data to https://jsonplaceholder.typicode.com/ fetch it and display list of all posted items.

Please make sure unittests are included.

Extra creds: make the networking logic a standalone library

Submissions will be evaluated according to code quality, documentation, design and completeness of unit tests. Code must build, run and give correct output.