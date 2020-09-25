# toastyLib

toastyLib
A really simple library that help you to display a custom  card toast with your custom color

#Gradle

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Step 2. Add the dependency
  
  dependencies {
    implementation 'com.github.ayabsd:toastyLib:1.0'
}


Example code : 

 *To init your ToastyLib : 
 toast = ToastyLib()
 
 *To change the default tint color (test color  and icon )
 toast.seTintColor("#000000")
 
 *To change your background color 
 toast.setBackgroundColor("#ffddffbb")
 
 *To show your ToastyLib : 
 toast.make(this , "hello", duration = ToastyLib.LONG , ToastyLib.Type.INFO)

 

