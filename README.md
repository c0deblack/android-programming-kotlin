# Android Programming - The Big Nerd Ranch Guide 5th Edition (2022)

Chapter code and solutions to [Android Programming: The Big Nerd Ranch Guide (5th Edition)](https://bignerdranch.com/books/android-programming-the-big-nerd-ranch-guide-5th-edition/).

This file outlines some of the Kotlin and Android features introduced in each chapter. Links to official documentation are provided. 


## Table of Contents

 1) [Your First Android Application](https://github.com/c0deblack/android-programming-kotlin/tree/development#chapter-1-your-first-android-application)
 2) [Interactive User Interfaces](https://github.com/c0deblack/android-programming-kotlin/tree/development#chapter-2-interactive-user-interfaces)
 3) [The Activity Lifecycle](https://github.com/c0deblack/android-programming-kotlin/tree/development#chapter-3-the-activity-lifecycle)
 4) [Persisting UI State](https://github.com/c0deblack/android-programming-kotlin/tree/development#chapter-4-persisting-ui-state)
 5) [Debugging Android](https://github.com/c0deblack/android-programming-kotlin/tree/development#chapter-5-debugging-android)
 6) [Testing](https://github.com/c0deblack/android-programming-kotlin/tree/development#chapter-6-testing)
 7) [Your Second Activity](https://github.com/c0deblack/android-programming-kotlin/tree/development#chapter-7-your-second-activity)
 8) [Android SDK Versions and Compatibility](https://github.com/c0deblack/android-programming-kotlin/tree/development#chapter-8-android-sdk-versions-and-compatibility)
 9) [Fragments](https://github.com/c0deblack/android-programming-kotlin/tree/development#chapter-9-fragments)
10) [Display Lists with RecyclerView](https://github.com/c0deblack/android-programming-kotlin/tree/development#chapter-10-display-lists-with-recyclerview)
11) [Create User Interfaces with Layouts and Views](https://github.com/c0deblack/android-programming-kotlin/tree/development#chapter-11-creating-user-interfaces-with-layouts-and-views)

![Android Programming: Big Nerd Ranch Guide (5th Edition)](https://bignerdranch.com/wp-content/uploads/2021/10/BNR_Android_5E_comp-copy-scaled.jpg)

## Chapter #1: Your First Android Application
[go back to top](https://github.com/c0deblack/android-programming-kotlin/tree/development#table-of-contents)

### Kotlin 

- [Basic Syntax](https://kotlinlang.org/docs/basic-syntax.html)
    - all of the basics to get started
- [Late Init Properties](https://kotlinlang.org/docs/properties.html#late-initialized-properties-and-variables)
    - used for non-null private class variables that will hold references to the button views
- [Single Abstract Method](https://kotlinlang.org/docs/fun-interfaces.html)
    - shorted syntax used with the button's `setOnClickListener()` method
    - the single abstract method is implemented and passed to the `setOnClickLister()`
- [KDoc](https://kotlinlang.org/docs/kotlin-doc.html#kdoc-syntax)
    - used to document Kotlin code


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
[go back to top](https://github.com/c0deblack/android-programming-kotlin/tree/development#table-of-contents)

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
[go back to top](https://github.com/c0deblack/android-programming-kotlin/tree/development#table-of-contents)

### Kotlin

- [Compile-time Constant](https://kotlinlang.org/docs/properties.html#compile-time-constants)
    - used for the string TAG variable passed to the logging function
- [Conditions and Loops](https://kotlinlang.org/docs/control-flow.html)
    - used in the challenges
    - [if statement](https://kotlinlang.org/docs/control-flow.html#if-expression)
    - [for loops](https://kotlinlang.org/docs/control-flow.html#for-loops)

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
- [Formatting String Resources](https://developer.android.com/guide/topics/resources/string-resource.html#formatting-strings)
- [Activity.finish()](https://developer.android.com/reference/android/app/Activity#finish())

### Challenge #4: Preventing Repeat Answers

- Added an `isAnswered` Boolean to the `Question` class
- Added functions to `QuizViewModel` to determine the answer state of the current quesiton
- Button state loss on configuration change is fixed in Chapter 7, Challenge 10

### Challenge #5: Graded Quiz

- Modified the `checkAnswer()` function to check if all the questions are answered

## Chapter 4: Persisting UI State
[go back to top](https://github.com/c0deblack/android-programming-kotlin/tree/development#table-of-contents)

### Kotin 

- [Class Constructor / Initializer](https://kotlinlang.org/docs/classes.html#constructors)
- [Class Inheritance](https://kotlinlang.org/docs/inheritance.html)
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
- [ViewModel Dependencies](https://developer.android.com/jetpack/androidx/releases/lifecycle)
    - added dependency to build.gradle
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
[go back to top](https://github.com/c0deblack/android-programming-kotlin/tree/development#table-of-contents)

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
- [The Android Profiler](https://developer.android.com/studio/profile/android-profiler)

### Challenge #6: Using conditional Breakpoints
### Challenge #7: Exploring the Layout Inspector
### Challenge #8: Exploring the Profiler

## Chapter 6: Testing
[go back to top](https://github.com/c0deblack/android-programming-kotlin/tree/development#table-of-contents)

### Kotlin

- [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/)
    - used to pass key/value pair to the savedStateHandle constructor in the JVM test

### Android

- [Create New Test](https://developer.android.com/studio/test/test-in-android-studio#create-new-tests)
- [Testing Overview](https://developer.android.com/training/testing)
    - [Fundamentals](https://developer.android.com/training/testing/fundamentals)
    - [What to Test](https://developer.android.com/training/testing/fundamentals/what-to-test)
    - [test doubles](https://developer.android.com/training/testing/fundamentals/test-doubles): provides dependencies to subject under test
- [JVM Testing](https://developer.android.com/training/testing/local-tests) (Local testing)
    - ran tests within Android Studio
    - imported `R` in order to test string resource values
    - [create a local test](https://developer.android.com/training/testing/local-tests#test-class)
- [Instrumentation Testing](https://developer.android.com/training/testing/instrumented-tests)
    - ran tests on a physical device
    - [create an instrumented test](https://developer.android.com/training/testing/instrumented-tests#create-instrumented)
- [ActivityScenario](https://developer.android.com/reference/androidx/test/core/app/ActivityScenario)
    - [recreate()](https://developer.android.com/reference/androidx/test/core/app/ActivityScenario#recreate())
        - used recreate to similate configuration change
- [Espresso Overview](https://developer.android.com/training/testing/espresso)
    - performed actions during unit test and tested result
    - [basics](https://developer.android.com/training/testing/espresso/additional-resources#samples)
    - [additional resources & samples](https://developer.android.com/training/testing/espresso/additional-resources#samples)

### Challenge #9: Asserting Yourself

- Asserted that `QuizViewModel` showed the correct question test after the `moveToNext()` operation

## Chapter 7: Your Second Activity
[go back to top](https://github.com/c0deblack/android-programming-kotlin/tree/development#table-of-contents)

### Kotlin

- [Companion Objects](https://kotlinlang.org/docs/object-declarations.html#companion-objects)
    - used to access the `newIntent()` method directly from the CheatActivity class
    - [object expressions](https://kotlinlang.org/docs/object-declarations.html)
- [Scope Functions](https://kotlinlang.org/docs/scope-functions.html)
    - [apply() scope function](https://kotlinlang.org/docs/scope-functions.html#apply)
        -  used to configure the new intent in the CheatActivity `newIntent()` function
- [Qualified this (this@ClassName)](https://kotlinlang.org/docs/this-expressions.html#qualified-this)
    - used to pass a reference of the MainActivity in CheatActivity's `newIntent()` function
- [When Expression](https://kotlinlang.org/docs/control-flow.html#when-expression)
    - used to check the Boolean put into the intent used to launch CheatActivity
- [Lambdas](https://kotlinlang.org/docs/lambdas.html)
    - [trailing lambdas](https://kotlinlang.org/docs/lambdas.html#passing-trailing-lambdas)
        - passed as a callback to the `registerForActivityResult()` function
- [Safe Calls (?.)](https://kotlinlang.org/docs/null-safety.html#safe-calls)
    - used to access the data of the result returned by the cheatLauncher: `result.data?`

### Android

- [Activity Overview](https://developer.android.com/guide/components/activities/intro-activities)
    - [declare activity](https://developer.android.com/guide/components/activities/intro-activities#da)
    - [declare intent](https://developer.android.com/guide/components/activities/intro-activities#dif)
- [Intents Overview](https://developer.android.com/guide/components/intents-filters)
    - [explicit intent](https://developer.android.com/guide/components/intents-filters#ExampleExplicit)
        - used to specifically choose the CheatActivity as the activity to launch
    - [implicit intent](https://developer.android.com/guide/components/intents-filters#ExampleSend)
    - [common intents](https://developer.android.com/guide/components/intents-common)
    - [intent api reference](https://developer.android.com/reference/android/content/Intent)
- [Android Manifest Overview](https://developer.android.com/guide/topics/manifest/manifest-intro)
    - [activity](https://developer.android.com/guide/topics/manifest/activity-element)
        - used to declare the MainActivity and CheatActivity as being part of the app
    - [intent-filter](https://developer.android.com/guide/topics/manifest/intent-filter-element)
        - used to declare MainActivity as the first activity in the app
- [Get Result From Activity Overview](https://developer.android.com/training/basics/intents/result)
    - [launch for result](https://developer.android.com/training/basics/intents/result#launch)
        - used to start a new activity that returns data after it finishes
    - [getBooleanExtra](https://developer.android.com/reference/android/content/Intent#getBooleanExtra(java.lang.String,%20boolean))
        - used to get the data passed to CheatActivity when MainActivity launched it
    - [recieve result](https://developer.android.com/training/basics/intents/result#separate)
        - used to capture data from an activity started from another activity
    - API References
        - [startActivity()](https://developer.android.com/reference/android/app/Activity#startActivity(android.content.Intent))
        - [startActivityForResult()](https://developer.android.com/reference/android/app/Activity#startActivityForResult(android.content.Intent,%20int))
- [The Back Stack](https://developer.android.com/guide/components/activities/tasks-and-back-stack)
    - demonstrated the differences between the first activity and started activities on the backstack

### Challenge #10: Closing Loopholes for Cheaters

- Added a `cheated` Boolean variable to each `Question` object
- Modified the `Question` class to inherit from `java.io.Serializable` so it can be stored in the saveStateHandle
    - [serializable Java reference](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html)
- Added the `questionBank` in the `QuizViewModel` to the MainActivity's savedState
- Included the cheat status along with the answer in the intent used to launch `CheatActivity`
- Restored UI state of the CheatActivity using values obtained from MainActivity

### Challenge #11: Tracking Cheat Status by Question

- Added the `didUserCheat()` and `setQuestionCheatStatus()` functions to the ViewModel
- Modified the launcher callback to set the cheat status after CheatActivity exits
- Modified the `checkAnswer()` function to check the current question cheat status

## Chapter #8: Android SDK Versions and Compatibility
[go back to top](https://github.com/c0deblack/android-programming-kotlin/tree/development#table-of-contents)

### Kotlin

- [BuildString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/build-string.html)
    - used to generate the text that displays the current API level in the CheatActivity
- [If Expression](https://kotlinlang.org/docs/control-flow.html)
    - used to check the current cheat count

### Android

- [Android Developer Documentation (Top-Level)](https://developer.android.com/)
- [Android Verions Overview](https://developer.android.com/about/versions)
- [Build Version](https://developer.android.com/reference/android/os/Build.VERSION)
    - used to perform a conditional version check prior to calling a higher than minSdk API feature (blur effect)
- [Version Codes](https://developer.android.com/reference/android/os/Build.VERSION_CODES)
    - checked current API level versus API level 31 to implement a blur effect
- [Google Play Target API](https://developer.android.com/google/play/requirements/target-sdk)
- [minSdk, targetSdk, compiledSdk](https://medium.com/androiddevelopers/picking-your-compilesdkversion-minsdkversion-targetsdkversion-a098a0341ebd) 
- [Android Jetpack Overview](https://developer.android.com/jetpack/)
- [@RequiredApi Annotation](https://developer.android.com/reference/kotlin/androidx/annotation/RequiresApi)
    - used to prevet Androi Lint error when defining a function that uses an API features higher than minSdk version
- [Render Effect API](https://developer.android.com/reference/android/graphics/RenderEffect)
    - used to apply a blur effect to the cheat button

### Challenge #12: Reporting the Device's Android Version

- used the `Build.VERSION.SDK_INT` constant to get the current API
- used a formatted string resource to display the current API version with additional text

### Challenge #13: Limited Cheating

- added a cheat button and text views displaying cheat counts to the MainActivity
- added cheat count variables and a method to update them within the `QuizViewModel`
- applied updates to the MainActivity cheat counts and cheat button in the CheatActivity result callback


## Chapter #9: Fragments
[go back to top](https://github.com/c0deblack/android-programming-kotlin/tree/development#table-of-contents)

### Kotlin

- [Named Arguments](https://kotlinlang.org/docs/functions.html#named-arguments)
    - used when instantiating a single crime object from the `Crime` constructor
- [Data Class Copy](https://kotlinlang.org/docs/data-classes.html#copying)
    - updated the value of a `Crime` object using itself `copy` method.
- [checkNotNull](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/check-not-null.html)
    - used for the non-null version of the viewBinding reference within the fragment class

### Android

- [Fragments Overview](https://developer.android.com/guide/fragments?hl=en)
    - [create a fragment](https://developer.android.com/guide/fragments/create?hl=en)
        - added fragment dependency to build.gradle (module)
- [Fragment Lifecyle](https://developer.android.com/guide/fragments/lifecycle?hl=en)
    - performed various operations within fragment lifecyle methods
    - [onCreate()](https://developer.android.com/reference/androidx/fragment/app/Fragment#onCreate(android.os.Bundle))
    - [onCreateView()](https://developer.android.com/reference/androidx/fragment/app/Fragment#onCreateView(android.view.LayoutInflater,android.view.ViewGroup,android.os.Bundle))
        - generated the layout using a View Binding
        - [layoutInflator](https://developer.android.com/reference/android/view/LayoutInflater.html)
        - [viewGroup](https://developer.android.com/reference/android/view/ViewGroup.html)
    - [onViewCreated()](https://developer.android.com/reference/androidx/fragment/app/Fragment#onViewCreated(android.view.View,android.os.Bundle))
        - performed actions after the views bacome available 
- [FragmentContainerView](https://developer.android.com/reference/kotlin/androidx/fragment/app/FragmentContainerView?hl=en)
    - created a container to host fragments from the main CriminalIntent activity's layout
- [Fragment Manager](https://developer.android.com/guide/fragments/fragmentmanager?hl=en)
    - controls fragment lifecycle from the hosting activity
    - used to manually load a fragment vs using the FragmentContainerView's `android:name` attribute
    - [supportFragmentManager](https://developer.android.com/guide/fragments/fragmentmanager#access)
        - used the `supportFragmentManager` to access CriminalIntent activity fragment manager
    - [Fragment Transactions](https://developer.android.com/guide/fragments/transactions?hl=en)
        - performed a fragment transaction to load the CrimeDetailFragment into the FragmentContainerView
    - [Fragment Backstack](https://developer.android.com/guide/fragments/fragmentmanager#perform)
- [ViewBinding In Fragments](https://developer.android.com/topic/libraries/view-binding#fragments)
    - obtained a nullable reference to the view binding
    - nulled the binding referenec in the `onDestroyView` method
- [Style and Themes Overview](https://developer.android.com/develop/ui/views/theming/themes)
    - [XML andtroid:textApperance attribute](https://developer.android.com/develop/ui/views/theming/themes#textappearance)
        - used to assign a Material Design style to the fragment text elements
- [Autofill Overview](https://developer.android.com/guide/topics/text/autofill)
    - [XML android:importantForAutofill attribute](https://developer.android.com/guide/topics/text/autofill-optimize#important)
        - used to disable autofill on the fragments EditView
- [EditView Hint](https://developer.android.com/reference/android/widget/TextView#attr_android:hint)
    - used to show a hint for the fragment's EditView
- [TextView.doOnTextChanged()](https://developer.android.com/reference/kotlin/androidx/core/widget/package-summary#(android.widget.TextView).doOnTextChanged(kotlin.Function4))
    - used this Kotlin Extension function to update the title held within a `Crime` object

### Java

- [UUID](https://docs.oracle.com/javase/7/docs/api/java/util/UUID.html)
    - used to assign a unique ID to each `Crime` class object
- [Date]( https://docs.oracle.com/javase/8/docs/api/java/util/Date.html)
    - used to assign a date to each `Crime` class object


### Challenge #14: Testing with FragmentScenario

- [Fragnent Testing Overview](https://developer.android.com/guide/fragments/test)
    - added dependency to use `FragmentScenario`
    - [google issuetracker](https://issuetracker.google.com/issues/128612536)
        - resolved issue with non-functioning fragment test
- [FragmentScenario](https://developer.android.com/reference/kotlin/androidx/fragment/app/testing/FragmentScenario?hl=en)
    - used to drive CrimeDetailFragment's lifecyle in an instrumentation test


## Chapter #10: Display Lists with RecyclerView
[go back to top](https://github.com/c0deblack/android-programming-kotlin/tree/development#table-of-contents)

### Kotlin

- [Collections: mutableListOf](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/mutable-list-of.html)
    - used to create a mutable list of `Crime` objects in the ViewModel
- [Strings](https://kotlinlang.org/docs/strings.html)
    - [string template](https://kotlinlang.org/docs/strings.html)
        - used to evaluate code and concatenate the result to a string
- [Abstract Method](https://kotlinlang.org/docs/classes.html#abstract-classes)
    - used in challenge 14 to pass unique ViewHolder objects to the same adapter based on list item view type

### Android

- [RecyclerView Overview](https://developer.android.com/develop/ui/views/layout/recyclerview?hl=en)
    - created a recyclerview to list crimes
    - [layout manager](https://developer.android.com/develop/ui/views/layout/recyclerview?hl=en#plan-your-layout)
        - used to create a vertical list of items within the recyclerview
    - [viewHolder and adapter](https://developer.android.com/develop/ui/views/layout/recyclerview?hl=en#implement-adapter)
        - used to create and display the UI for each element in the recyclerview
- [RecyclerView Dependencies](https://developer.android.com/jetpack/androidx/releases/recyclerview?hl=en#declaring_dependencies)
    - added dependencies to build.gradle
- [RecyclerView Reference](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView?hl=en)
- [Customize RecyclerView](https://developer.android.com/develop/ui/views/layout/recyclerview-custom?hl=en)
    - applied the RecyclerView LinearLayout
- [RecyclerView ListAdapter](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/ListAdapter)
    - researched an efficient method to update a RecyclerView without re-creating the entire list

### Challenge #14: RecyclerView View Types

- [RecyclerView getItemViewType()](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.Adapter?hl=en#getItemViewType(int))
    - used to generate a different item view based on the data

## Chapter #11: Creating User Interfaces with Layouts and Views
[go back to top](https://github.com/c0deblack/android-programming-kotlin/tree/development#table-of-contents)

### Android

- [Constraint Layout Overview](https://developer.android.com/develop/ui/views/layout/constraint-layout?hl=en)
- [Layout Editor](https://developer.android.com/studio/write/layout-editor?hl=en)
    - [convert a view or layout](https://developer.android.com/studio/write/layout-editor?hl=en#convert-view)
        - converted a LinearLayout to a ConstrainLayout
    - [edit view attributes](https://developer.android.com/studio/write/layout-editor?hl=en#edit-properties)
        - configured view attributes including height, width, margins, and constraints
- [Styles and Themes](https://developer.android.com/develop/ui/views/theming/themes?hl=en)
    - applied material design themes
- [MotionLayout Overview](https://developer.android.com/develop/ui/views/animations/motionlayout?hl=en)
    - learned about creating animations
    - [various examples](https://developer.android.com/develop/ui/views/animations/motionlayout/examples?hl=en)
    - [carousel](https://developer.android.com/develop/ui/views/animations/motionlayout/carousel?hl=en)

### Challenge #15: Formatting the Date

- [DateFormat](https://developer.android.com/reference/kotlin/android/text/format/DateFormat?hl=en)
    - used to format a java Date object
- [Date Character Codes](https://developer.android.com/reference/kotlin/android/text/format/DateFormat?hl=en)
    - charcter codes used in the DateFormat `format()` method to display a user-friendly date

## Chapter #12: Coroutines and Databases
[go back to top](https://github.com/c0deblack/android-programming-kotlin/tree/development#table-of-contents)

### Kotlin 

- [Coroutinesi Overview](https://kotlinlang.org/docs/coroutines-overview.html)
    - [your first coroutine](https://kotlinlang.org/docs/coroutines-basics.html#your-first-coroutine)

### Android

- [Background Work Overview](https://developer.android.com/guide/background)
- [Types of Asynchronous Work](https://developer.android.com/guide/background/asynchronous)
- [Kotlin Coroutines](https://developer.android.com/kotlin/coroutines)
    - [dependencies](https://developer.android.com/kotlin/coroutines#dependency)
        - added dependencies for coroutines and lifecycle scope
    - [start a coroutine](https://developer.android.com/kotlin/coroutines/coroutines-adv#start)
        - used the coroutine builder `launch()` method to build a coroutine
        - created a suspend function to run within the launch method
    - [coroutine scope](https://developer.android.com/kotlin/coroutines/coroutines-adv#concepts)
        - launched coroutine within the coroutine scope
- [Lifecycle Aware Components](https://developer.android.com/topic/libraries/architecture/coroutines#lifecycle-aware)
    - used `viewLifecycleScope.lifecyleScope.launch()` to launch coroutine within a Fragment class
    - [viewModelScope](https://developer.android.com/topic/libraries/architecture/coroutines#viewmodelscope)
        - launched a coroutine within the scope of a viewModel
    - [lifecycle scope](https://developer.android.com/topic/libraries/architecture/coroutines#lifecyclescope)
        - scopes available for Activity and Fragment classes
    - [repeatOnLifecycle](https://developer.android.com/topic/libraries/architecture/coroutines#restart)
        - used to execute a coroutine when a specificy lifecycle state is encountered without manual `Job` cleanup
- [Coroutine Jobs](https://developer.android.com/kotlin/coroutines/coroutines-adv#job)
    - used to cancel a coroutine
- [Room Database Overview](https://developer.android.com/training/data-storage/room?hl=en)
    - [dependencies](https://developer.android.com/training/data-storage/room?hl=en#setup)
        - added kapt (Kotlin annotation processing tool), room-runtime, and room-ktx, and room-compiler
- [Room DB Entity Class](https://developer.android.com/training/data-storage/room/defining-data?hl=en)    
    - annotated the Crime model class as an entity
- [Room Database Class](https://developer.android.com/training/data-storage/room?hl=en#database)
    - created an abstract database class and annotated it with `@Database()`
    - passed in `Crime::class` as an entity to the `@Database` annotation
- [Room Type Converter](https://developer.android.com/training/data-storage/room?hl=en#database)
    - converted from the `Date` type to a Long
- [Room Data Access Object(DAO)](https://developer.android.com/training/data-storage/room/accessing-data?hl=en)
    - created an interface that provides annotated functions that will access data in database
    - [query methods](https://developer.android.com/training/data-storage/room/accessing-data?hl=en#query)
        - used to create an SQLite `SELECT` statement

### Challenge #16: Addressing the Schema Warning

