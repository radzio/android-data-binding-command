# Android Data Binding Command

Command design pattern implementation for Android Data Binding

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

### Make sure that you are using Android Data Binding

- In your main  build.gradle you have gradle plugin 1.5.0 or newer:
 
```gradle
classpath 'com.android.tools.build:gradle:1.5.0'
```

- In your app build.gradle you've enabled databinding:
    
    
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

### Command features ###

Each command implements ICommand interface

```java
    public interface ICommand extends Observable
    {
        @Bindable
        boolean isEnabled();
    
        void isEnabled(boolean isEnabled);
    
        @Bindable
        boolean isRefreshing();
    
        void isRefreshing(boolean isRefreshing);
    
        void execute();
    }
```

You can use isEnabled and isRefreshing properties in your [java code](https://jitpack.io/#radzio/android-data-binding-command) and xml layouts:

```xml
     <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:id="@+id/button2"
            android:layout_below="@+id/button"
            bind:command="@{viewModel.enableButtonCommand}"
            android:text="@{viewModel.buttonCommand.enabled ? `Disable Timer` : `Enable Timer`}"
            android:enabled="@{viewModel.buttonCommand.refreshing == false}"
            android:layout_centerHorizontal="true"/>
```