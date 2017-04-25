# demo-news-api-android
News Client Using News Api
Built using android studio version 2.2
Consumes json objects from     (https://newsapi.org/)



Uses volley to fetch data
uses piccasso for image loading and caching

Gradle
    compileSdkVersion 25
    buildToolsVersion "25.0.2"
    defaultConfig {
        
        minSdkVersion 16
        targetSdkVersion 25
        versionCode 1
        versionName "1.0"
        
        
            dependencies {
        classpath 'com.android.tools.build:gradle:2.2.0'
        
        
        
        Features

provides two diffrent view layouts ie  Linear /StaggeredGrid layout
Share articles 
Choice of news from a wide range of sources
choice of news from a particular source
Choice of news topic 
Login/Registration 
(future improvements
    1-Ability to save for offline mode
    2-UI improvements
    3-Login with facebook/gmail(firebase)
    4-Create a user profile for personalized recommendations 
    


        
    Dependancies
    
    dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })
    compile 'com.android.support:appcompat-v7:25.3.1'
    compile 'com.android.support:design:25.3.1'
    testCompile 'junit:junit:4.12'

    compile 'com.android.support:palette-v7:25.3.1'
    compile 'com.muddzdev:styleabletoast:1.0.7'
    compile 'com.squareup.picasso:picasso:2.5.2'
    compile 'com.android.support:cardview-v7:25.3.1'
    compile 'com.android.support:recyclerview-v7:25.3.1'
    compile 'com.android.volley:volley:1.0.0'
    
    
    
    
   SCREEN SHOTS

![screenshot_2017-04-25-03-02-20](https://cloud.githubusercontent.com/assets/14289998/25363660/fc7c9282-2964-11e7-96ed-f0e8db2a2670.png)

![screenshot_2017-04-25-03-02-34](https://cloud.githubusercontent.com/assets/14289998/25363661/fc9b9650-2964-11e7-9da6-d704e8ae9a7e.png)

![screenshot_2017-04-25-03-03-50](https://cloud.githubusercontent.com/assets/14289998/25363662/fcaba34c-2964-11e7-96cc-4c946cfb790f.png)

![screenshot_2017-04-25-03-04-24](https://cloud.githubusercontent.com/assets/14289998/25363668/0219a432-2965-11e7-9fd9-a8eeda2c2654.png)

![screenshot_2017-04-25-03-05-11](https://cloud.githubusercontent.com/assets/14289998/25363663/fcdc3fca-2964-11e7-814c-d75191cbd7f0.png)

![screenshot_2017-04-25-03-07-27](https://cloud.githubusercontent.com/assets/14289998/25363664/fd011bb0-2964-11e7-8025-0e4a02fae6df.png)

![screenshot_2017-04-25-03-07-48](https://cloud.githubusercontent.com/assets/14289998/25363665/fd094560-2964-11e7-8526-cda3545b61a0.png)

![screenshot_2017-04-25-03-07-59](https://cloud.githubusercontent.com/assets/14289998/25363666/fd2504e4-2964-11e7-96e1-7934372c54b7.png)
