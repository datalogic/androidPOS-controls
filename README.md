[![](https://jitpack.io/v/datalogic/androidpos-controls.svg)](https://jitpack.io/#datalogic/androidpos-controls)
# Description
This project contains the controls module (library) for the AndroidPOS library.

# How to use the library
Add in your root build.gradle at the end of repositories:
~~~gradle
    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
~~~
Add the following dependency to your gradle file:
~~~gradle
    dependencies {
	        implementation 'com.github.datalogic:androidpos-controls:0.1-alpha'
	}
~~~