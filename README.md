# Android Databinding Command

Command design pattern implementation for Android Databinding

[![](https://jitpack.io/v/radzio/android-data-binding-command.svg)](https://jitpack.io/#radzio/android-data-binding-command)

## Demo
![gif2](https://cloud.githubusercontent.com/assets/469111/14364731/755e787e-fd0a-11e5-9978-569d20451f14.gif)


## How to start?

Step 1. Add it in your root build.gradle at the end of repositories:

```gradle
	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```

Step 2. Add the dependency

```gradle
	dependencies {
	        compile 'com.github.radzio:android-data-binding-command:1.0.1'
	}
```

Share this release:

### Change your gradle file

- In your main  build.gradle add:
 
```gradle
classpath 'com.android.tools.build:gradle:1.5.0'
```

- In your app build.gradle add:
    
    
```gradle
    dataBinding {
        enabled = true
    }
```

### Add to your code ###

Modify your layout, add  __bind:command="@{viewModel.myCommand}"__

```xml
        <android.support.design.widget.FloatingActionButton
            bind:command="@{viewModel.myCommand}"
            android:id="@+id/fab"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="bottom|end"
            android:layout_margin="@dimen/fab_margin"
            android:src="@android:drawable/ic_dialog_email"/>
``` 

Add in your binding class

```java
    public ICommand myCommand = new Command()
    {
        @Override
        public void execute()
        {
            MainActivityViewModel.this.view.showMessage("Hello from Command!");
        }
    };
```    
