# Android Programming - The Big Nerd Ranch Guide 5th Edition (2022)

Chapter code and solutions to [Android Programming: The Big Nerd Ranch Guide (5th Edition)](https://bignerdranch.com/books/android-programming-the-big-nerd-ranch-guide-5th-edition/).

This file outlines some of the Kotlin and Android features introduced in each chapter. Links to official documentation are provided. 

## Chapter #1: Your First Android Application

### Kotlin 

- [Basic Syntax](https://kotlinlang.org/docs/basic-syntax.html)
    - all of the basics to get started
- [Late Init Properties](https://kotlinlang.org/docs/properties.html#late-initialized-properties-and-variables)
    - used for non-null private class variables that will hold references to the button views
- [Single Abstract Method](https://kotlinlang.org/docs/fun-interfaces.html)
    - shorted syntax used with the button's `setOnClickListener()` method
    - the single abstract method is implemented and passed to the `setOnClickLister()`

### Andorid 

- [Keyboard Shortcuts](https://developer.android.com/studio/intro/keyboard-shortcuts)
    - **ALT+Enter**: project quickfix
- Center all content within ViewGroup using the **android:gravity** property
- [Toast](https://developer.android.com/guide/topics/ui/notifiers/toasts)
- [Snackbar](https://developer.android.com/develop/ui/views/notifications/snackbar)
- Toast is passed a context, Snackbar is passed a view
- Snackbar supersedes Toast, use Snackbar instead
- [App Resources Overview](https://developer.android.com/guide/topics/resources/providing-resources)
    - accessed root view using **android.R.id.content**
- [String Resources](https://developer.android.com/guide/topics/resources/string-resource)

### Challenge #1: Switching Your Toast for a Snackbar

## Chapter 2: Interactive User Interfaces

### Kotlin

- [Basic Types](https://kotlinlang.org/docs/basic-types.html)
    - first letter of primitives are capitalized: 
- [Data Classes](https://kotlinlang.org/docs/data-classes.html)
    - used as a data Model, similar to the Model-View-Controller software architecture
- [listOf](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/list-of.html)
    - used to create a list of `Question` objects
- [If Expression](https://kotlinlang.org/docs/control-flow.html#when-expression) 
    - can return a value 
    - replaces the ternary operator
- See also: [Kotlin Built-in Collection Operations](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/)


### Android 

- [@StringRes](https://developer.android.com/reference/androidx/annotation/StringRes?hl=en) 
    - marked a property as requiring a string id resource
- [Tools Attribute Reference](https://developer.android.com/studio/write/tool-attributes)
    - tools namespace:`xmlns:tools="http://schemas.android.com/tools`
    - `tools:text`: show text in the Android Studio preview only
- [ViewBinding](https://developer.android.com/topic/libraries/view-binding)
    - [setup](https://developer.android.com/topic/libraries/view-binding#setup)
    - [usage](https://developer.android.com/topic/libraries/view-binding#usage)
    - used **View Binding** instead of [View.findViewById](https://developer.android.com/reference/android/view/View#findViewById(int))
- [Vector Assets](https://developer.android.com/studio/write/vector-asset-studio)
    - created a right arrow vector asset
- [Icon Image Assets](https://developer.android.com/studio/write/image-asset-studio)
    - added an icon to a button
- [Buttons](https://developer.android.com/develop/ui/views/components/button): Click Events and Styling
    - added the app namespace: `xmlns:app="http://schemas.android.com/apk/res-auto"`
    - used the `app:icon` attribute with a `@drawable/...` resource
    - used `app:iconGravity` to change the orientation of the icon
- [Pixel Densities](https://developer.android.com/training/multiscreen/screendensities)
    - use **SP** for text and **DP** for margins, padding, etc

### Challenge #2: Add a Listener to the TextView
### Challenge #3: Add a Previous Button

## Chapter 3: The Activity Lifecycle

### Kotlin

- [Compile-time Constant](https://kotlinlang.org/docs/properties.html#compile-time-constants)
    - used for the string TAG variable passed to the logging function
- [Conditions and Loops](https://kotlinlang.org/docs/control-flow.html)
    - used in the challenges
    - [if statement](https://kotlinlang.org/docs/control-flow.html#if-expression)
    - [for loops](https://kotlinlang.org/docs/control-flow.html#for-loops)
- [Formatting String Resources](https://developer.android.com/guide/topics/resources/string-resource.html#formatting-strings)


### Android 

- [Activity Lifecyle](https://developer.android.com/guide/components/activities/activity-lifecycle)
    - overrided lifecyle methods
    - called super class implementation on first line of each lifecycle method
    - logged activity lifecyle
    - use `onStart()` and `onStop` for updating the UI
    - [multi-resume](https://developer.android.com/guide/topics/large-screens/multi-window-support#multi-resume)
- [Configuration Changes](https://developer.android.com/guide/components/activities/state-changes)
    - occurs when device is rotated
- [Logging](https://developer.android.com/reference/android/util/Log)
    - used the android logging utility
- [Logcat Utility](https://developer.android.com/studio/debug/am-logcat)
    - created a log filter
    - extra: [commandline utility](https://developer.android.com/studio/command-line/logcat)
- [Activity.finish()](https://developer.android.com/reference/android/app/Activity#finish())

### Challenge #4: Preventing Repeat Answers
### Challenge #5: Graded Quiz

## Chapter 4: Persisting UI State

### Kotin 

- [Class Constructor / Initializer](https://kotlinlang.org/docs/classes.html#constructors)
- [Property Delegation](https://kotlinlang.org/docs/delegated-properties.html) using the `by` keyword
- [Lazy Initialized Properties](https://kotlinlang.org/docs/properties.html#late-initialized-properties-and-variables)
- [Computed Properties / Getters & Setters](https://kotlinlang.org/docs/properties.html#getters-and-setters)

### Andorid 

- [Build Dependencies](https://developer.android.com/studio/build/dependencies)
- [ViewModel Overview](https://developer.android.com/topic/libraries/architecture/viewmodel)
    - [Implement ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel#implement-viewmodel)
        - extended the ViewModel class
        - invoked the `viewModels()` property delegate
    - do not reference the Activity or its Views in the ViewModel
- [ViewModel Lifecycle](https://developer.android.com/topic/libraries/architecture/viewmodel#lifecycle)
    - used the `onCleared()` method to display a message
- [ViewModel Scope](https://developer.android.com/topic/libraries/architecture/viewmodel/viewmodel-apis)
    - scoped the viewModel to the MainActivity lifecycle
- [SavedStateHandle](https://developer.android.com/topic/libraries/architecture/viewmodel/viewmodel-savedstate)
    - store the saved state in the view model
    - use computed properties to get value out of the savedStateHandle
    - deleted when task stack goes away
    - [UI dismissal](https://developer.android.com/topic/libraries/architecture/saving-states#ui-dismissal-system)
        - saved state is also removed during these events
- [Android Jetpack](https://developer.android.com/jetpack/)
    - various androidx libraries enabling the latest android features


## Chapter 5: Debugging Android

### Kotlin

- [Kotlin Exceptions Overview](https://kotlinlang.org/docs/exceptions.html#exception-classes)

### Android

- [Debug Your App](https://developer.android.com/studio/debug)
    - [breakpoints](https://developer.android.com/studio/debug#breakPoints)
        - [conditional breakpoints](https://developer.android.com/codelabs/basic-android-kotlin-training-debugging-with-breakpoints#3)
    - [view variables](https://developer.android.com/studio/debug#variablesAndWatches)
    - set conditional breakpoint
    - executed kotlin computed properties with Evaluate Expression in debug mode
- [Write and View Logs](https://developer.android.com/studio/debug/am-logcat)
    - device stores latest lines written to log in case of crash
- [Stack Tracing](https://developer.android.com/studio/debug/stacktraces)
    - logged stack traces while app was running
- [Lint Checks](https://developer.android.com/studio/write/lint#manuallyRunInspections)
    - identified and resolved an internationalization issue
    - interface provides auto correction of many problems
- Resolving Issues
    - double check XML resources for syntax errors
    - select Build > Clean Croject
    - select File > Sync Project With Gradle Files
    - select Code > Inspect Code for run Lint Checks
    - select File > Invalidate Caches
- [Layout Inspector](https://developer.android.com/studio/debug/layout-inspector)
    - selected Tools > Layout Inspector
    - inspected a live view of the app in android studio

### Challenge #6: Using conditional Breakpoints
### Challenge #7: Exploring the Layout Inspector
### Challenge #8: Exploring the Profiler
