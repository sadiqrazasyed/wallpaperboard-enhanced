# Wallpaper Board Enhanced <img src="https://raw.githubusercontent.com/danimahardhika/wallpaperboard/master/arts/icon.png" width="35">
[![](https://jitpack.io/v/danimahardhika/wallpaperboard.svg)](https://jitpack.io/#danimahardhika/wallpaperboard) [![Build Status](https://travis-ci.org/danimahardhika/wallpaperboard.svg?branch=master)](https://travis-ci.org/danimahardhika/wallpaperboard) [![CircleCI](https://circleci.com/gh/danimahardhika/wallpaperboard.svg?style=svg)](https://circleci.com/gh/danimahardhika/wallpaperboard) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/3b44524988a940fa9a48917bd6ed5367)](https://www.codacy.com/app/danimahardhika/wallpaperboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=danimahardhika/wallpaperboard&amp;utm_campaign=Badge_Grade) [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

This is just an enhanced version of WallpaperBoard with additional features.

Actual Library : https://github.com/danimahardhika/wallpaperboard
# Enahnced Features
* Interstitial Ads</li>
* Ad-Block Prevention</li>
* OneSignal Notifications</li>
* Auto Play-Store App Update Notification</li>
* Email Feedback Enhancements</li>

# How to Use

* Download/Clone this library (also contians sample app)
* To configure, follow this <a href="https://github.com/danimahardhika/wallpaperboard/wiki" target="_blank">Wiki Site</a>
* After setting up your app, follow enhanced setting options from below

# Enhancing WallPaperBoard

* Sign up on <a href="https://onesignal.com/" target="_blank">OneSignal</a>
* After signing up on OneSignal, follow this <a href="https://documentation.onesignal.com/docs/generate-a-google-server-api-key" target="_blank">documentation</a>
* Sign up on <a href="https://www.google.com/admob/" target="_blank">Google Admobs</a>

* Now open <b>build.gradle (Module:app)</b>

Head over to line number 22. 
```
 manifestPlaceholders = [manifestApplicationId: "${applicationId}",
                                onesignal_app_id: "068baede-1a04-432c-b8c4-6fc59bc84500",
                                onesignal_google_project_number: "745634907655"]
```

Change <b>"onesignal_app_id"</b> & <b>"onesignal_google_project_number"</b> with your own.

============================================================================

* Head over to <b>/app/res/values/"dashboard_configurations.xml"</b>

Scroll down to line number 117, which says "ENHANCEMENTS"

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

============================================================================

* Relase another version of your app, without ADS (use WallpaperBoard)

* Put that version link and either change the alert dialog content or leave it
```
    <string name="dialog_title">Don\'t like ads?</string>
    <string name="dialog_content">Upgrade to "YOUR APP NAME" to continue using without any ads.</string>
    <string name="dialog_btn_yes">Buy Now</string>
    <string name="dialog_btn_no">Not Now</string>
    <!-- Pro App Link -->
    <string name="pro_app_url">https://google.com</string>
```
* Ad Blocker Prevention Dialog, change dialog content or leave it as it is
```
    <string name="dialog_title_adblock">Ad Blocker Detected!</string>
    <string name="dialog_content_adblock">It seems like you\'re having an ad-blocker installed on your device. Please note, this app contains a small amount of ads in order to maintain active development. Support us by uninstalling your ad-blocker or consider buying Pro!</string>
    <string name="dialog_btn_yes_adblock">Okay</string>
    <string name="dialog_btn_no_adblock">Exit App</string>
    <string name="dialog_btn_neutral_adblock">BUY PRO</string>
```

* Email Report. This will be pre-written in email when a user trys to send you an email
```
    <string name="email_subject">"APP NAME" Bug Report/Feature Request</string>
    <string name="email_lastline">Sent using "APP NAME" email option.</string>
```

# Advance Editing 
If you wanna edit when ads are shown or/and when the "BUY PRO" dialog should be shown, then follow this.

* Head over to <b>/library/java/activities/"WallpaperBoardPreviewActivity.java"</b>

Scroll down to line number 842

* Example & Info : 

Shows ads in between min and max value randomly when user clicks on <b>Apply Homescreen Wallpaper</b> button only.

Example : Min = 2, Max = 4 : User will see an ad randomly between 2 to 4. Either the second time he applies or 3rd, or maybe 4th time. 

This method is used so that the user doesn't figure out the pattern &/or try to prevent it

Recommended value is 2 & 4 for ads

Samething for "BUY PRO" alert dialog. It will be shown after an ad has been closed (same method)

```
    private void counterCounts()
    {
        //define a new Random class
        Random r = new Random();

        //minimum number to generate as random number
        int minNumber = 2;

        //maximum number to generate as random number
        int maxNumber = 4;

        //get the next random number within range
        int randomNumber = r.nextInt((maxNumber-minNumber)+minNumber)+minNumber;

        if (+totalCount>=(randomNumber)) {
            //Resets the counter
            totalCount = 0;
            editor.putInt("counter", 0);
            editor.commit();
            //Shows ad
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
                requestNewInterstitial();
            }
        }
    }

    private void countAdsMethod()
    {
        //define a new Random class
        Random r = new Random();

        //minimum number to generate as random number
        int minNumber = 2;

        //maximum number to generate as random number
        int maxNumber = 4;

        //get the next random number within range
        int randomNumber = r.nextInt((maxNumber-minNumber)+minNumber)+minNumber;

        if (+countAds>=(randomNumber)) {
            countAds = 0;
            editor.putInt("number", 0);
            editor.commit();
            showDialog();
        }
    }
```

Change "<b>int minNumber</b>" & "<b>int maxNumber</b>" with your own numbers.

# Final Report

Ads are shown when user clicks on "Save" button, "Apply Homescreen & Lockscreen" button, and "Apply Homscreen"

Feel free to fork and make your changes.


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
