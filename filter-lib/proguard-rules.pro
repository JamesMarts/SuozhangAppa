# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/baiiu/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
#所有实体，项目中的实体都继承自BaseEntity
-keep class com.baiiu.filter.BaseEntity
-keepclasseswithmembers  class * implements com.baiiu.filter.BaseEntity{*; }