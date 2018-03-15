# Wallpaper Board Enhanced <img src="https://raw.githubusercontent.com/danimahardhika/wallpaperboard/master/arts/icon.png" width="35">
[![](https://jitpack.io/v/sadiqrazasyed/wallpaperboard-enhanced.svg)](https://jitpack.io/#sadiqrazasyed/wallpaperboard-enhanced) [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)


This is just an enhanced version of WallpaperBoard with additional features.

Actual Library : https://github.com/danimahardhika/wallpaperboard

Thanks to 	- [Dani Mahardhika](https://github.com/danimahardhika)

# Enahnced Features
* Interstitial Ads</li>
* Ad-Block Prevention</li>
* OneSignal Notifications</li>
* Auto Play-Store App Update Notification</li>
* Email Feedback Enhancements</li>

# Gradle Dependency
**Requirements**
* Latest version of Android Studio</li>
* Android-SDK Build tools v27</li>
* API 26 SDK Platform</li>
* Latest version of Android Support Library</li>
* Java SE Development Kit 8</li>

Take a look on this [screenshot](https://raw.githubusercontent.com/danimahardhika/candybar-library/698d102f504f5a843af4f5bc67a340a09b3c5889/screenshots/requirements.jpg) for requirements

The minimum API level supported by this library is API 15

Add JitPack repository to root `build.gradle`
```Gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```
Add the dependency
```Gradle
dependencies {
    implementation 'com.github.sadiqrazasyed:wallpaperboard-enhanced:v1.7.0-b5-2'
}
```

Or use a snapshot
```Gradle
dependecies {
    implementation('com.github.sadiqrazasyed:wallpaperboard-enhanced:-SNAPSHOT') {
        changing = true
    }
}
````

# How to Use

* Either Download/Clone this library (also contians sample app) or use my uploaded Sample App from here : <a href="https://github.com/sadiqrazasyed/wallpaperboard-enhanced-sample" target="_blank">WallpaperBoard Enhanced Sample</a>
* To configure, follow this <a href="https://github.com/danimahardhika/wallpaperboard/wiki" target="_blank">Wiki Site</a> (BUT USE MY SAMPLE APP)
* After setting up your app, follow enhanced setting options from below

# Enhancing WallPaperBoard

* Sign up on <a href="https://onesignal.com/" target="_blank">OneSignal</a>
* After signing up on OneSignal, follow this <a href="https://documentation.onesignal.com/docs/generate-a-google-server-api-key" target="_blank">documentation</a>

* Sign up on <a href="https://www.google.com/admob/" target="_blank">Google Admobs</a>
* Now open <b>build.gradle (Module:app)</b>
	- Head over to line number 22. 
```
 manifestPlaceholders = [manifestApplicationId: "${applicationId}",
                                onesignal_app_id: "068baede-1a04-432c-b8c4-6fc59bc84500",
                                onesignal_google_project_number: "745634907655"]
```

Change <b>"onesignal_app_id"</b> & <b>"onesignal_google_project_number"</b> with your own.

---

* Head over to <b>/app/res/values/"dashboard_configurations.xml"</b>

	- Scroll down to line number 117, which says "<b>ENHANCEMENTS</b>"

* Put your current app version name. This is required for OneSignal TAG
```
    <string name="app_version">v1.0</string>
```

* Create an Interstitial ad on Google Admob. After that copy App ID and paste it in this line
```
    <string name="admob_app_id">ca-app-pub-xxxxxxxxxxxxxxxx/xxxxxxxxxx</string>
```

* Paste your Ad Unit ID 
```
    <string name="admob_interstitial_id">ca-app-pub-xxxxxxxxxxxxxxxx/xxxxxxxxxx</string>
```

* Put your Device Test ID (This is to test your ads without getting banned)
```
    <string name="admob_testdevice_id">xxxxxxxxxxxxxxxxxxxxxxxxxx</string>
```

---

* Relase another version of your app, without ADS (using WallpaperBoard library)

* Copy your Ad-Free version app link from Play Store & paste it in this alert dialog along with your own changes to the content.
```
    <string name="dialog_title">Don\'t like ads?</string>
    <string name="dialog_content">Upgrade to "YOUR APP NAME" to continue using without any ads.</string>
    <string name="dialog_btn_yes">Buy Now</string>
    <string name="dialog_btn_no">Not Now</string>
    <!-- Pro App Link -->
    <string name="pro_app_url">https://google.com</string>
```
* Ad Blocker Prevention Dialog, change dialog content or leave it as it is.
```
    <string name="dialog_title_adblock">Ad Blocker Detected!</string>
    <string name="dialog_content_adblock">It seems like you\'re having an ad-blocker installed on your device. Please note, this app contains a small amount of ads in order to maintain active development. Support us by uninstalling your ad-blocker or consider buying Pro!</string>
    <string name="dialog_btn_yes_adblock">Okay</string>
    <string name="dialog_btn_no_adblock">Exit App</string>
    <string name="dialog_btn_neutral_adblock">BUY PRO</string>
```

* Email Report. This will be pre-written in email when a user tries to send you an email
```
    <string name="email_subject">"APP NAME" Bug Report/Feature Request</string>
    <string name="email_lastline">Sent using "APP NAME" email option.</string>
```

# Advance Editing 

If you wanna edit when ads are shown or/and when the "BUY PRO" dialog should be shown, then follow this.

** Example & Info : 

	- About Ads

Shows ads in between min and max value randomly when user clicks on <b>Apply Homescreen Wallpaper</b> button only.

Example : Min = 2, Max = 4 : User will see an ad randomly between 2 to 4 when he/she tires to apply <b>Homescreen Wallpaper</b>. In easy words, either the ad popup will be shown the second time or 3rd, or maybe 4th time after "<b>Apply</b>" button is clicked. 

This method is used so that the user/s doesn't get too annoyed with too many ads, &/or also have no static pattern which will prevent them from playing tricks.

Recommended value is 2 & 4 for ads.

	- About "BUY PRO" ALert Dialog
 
 This alert dialog is shown after an ad has been closed by the user, but just like the ads, even this dialog is written to randomly show between min/max value so that it doesn't mess the UX.

Example : Min = 2, Max = 4 : User will see a dialog after he/she has closed either the second ad, third, or maybe the fourth one.

Recommended value is 2 & 5 for this alert dialog.

---

To edit,

* Inside dashboard_configurations.xml

	- Scroll down to line number 140
 

```
        <!-- Min Number -->
    <string name="ad_min_count">2</string>
    <!-- Max Number -->
    <string name="ad_max_count">4</string>
```


```
    <!-- Min Number -->
    <string name="ad_closemin_count">2</string>
    <!-- Max Number -->
    <string name="ad_closemax_count">5</string>
```

Change "<b>Min Number</b>" & "<b>Max Number</b>" with your own numbers.


# Enhanced Feature-Previews
<img src="https://drive.google.com/uc?id=13SVLd3ciOjxQsOfJzSuu9onI3sbfT5fO" width="240"> <img src="https://drive.google.com/uc?id=1Pc7Y9LV9y8PKUneCw-cL5vqQSnXE92aS" width="240"> <img src="https://drive.google.com/uc?id=1IzCOhbOPGMkYfcneaRkVb5Q0WAU6uD8_" width="240"> <img src="https://drive.google.com/uc?id=1t9Z_qs2FylBhMssVJjqCRnuArDvL_w2a" width="240"> <img src="https://drive.google.com/uc?id=113WwzN6N93c8hnRUl6Ejs8R0ntqGZ9bI" width="240"> <img src="https://drive.google.com/uc?id=1ACT2TYfvDOn6e6o4NCZbl_tWtAPiYchx" width="240">


# Final Report

* About Ads
	- Ads are shown when user clicks on "Save" button, "Apply Homescreen & Lockscreen" button, and "Apply Homscreen"

* About Ad-Block Prevention
	- Application will throw an alert dialog when it detects either ad blocking app/s or term "admob" inside "/system/etc/hosts" file
	- User will not be able to use the app unless the ad blocker has been uninstalled.

* About Play Store Auto Update Notification
	- Each time your app is launch, it will compare user installed version & the Play Store version of the app, & if the user has an older version installed, then an alert dialog will be shown along with changelogs synced from Play Store.

---

* Feel free to fork and make your changes.

* Let me know if you find bugs or have a feature request.

# License
```
Copyright (c) 2017 Dani Mahardhika

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
