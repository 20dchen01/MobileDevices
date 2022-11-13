# Lab 6B solution - MVVM implementation of Lab 5B

This Readme file is used as a central place to stick information you might want to pay attention to.

This solution is not anywhere near perfect, even while refactoring it, I opted to skip several things
as long as the learning objective was covered somewhere else. 

The code is spotted with comments that are intended to guide/inform you. As much as possible, 
the comments are left close to to the point in the code where they will be contextually relevant.

The code has also been re-factored a bit. For example:
- Some classes have been given more semantically suitable names
- Most classes have been grouped into suitably named packages
- Some classes have been made inner classes

Observe the code is cleaner, simpler, has fewer lines of code because of fewer boiler plate coding to retrieve and display data.

In this sample solution, you may observe the use of top level Kotlin functions and/or extension functions.
So you are not entirely surprised when you see one, read about Kotlin function scopes here:
https://kotlinlang.org/docs/functions.html#function-scope
https://kotlinlang.org/docs/extensions.html#extension-functions

If you care to practice some more, here is a simple Colab which you can follow which demonstrates
a similar set of features as this example solution, but may also show you other interesting practices:
https://developer.android.com/codelabs/android-room-with-a-view-kotlin

Finally, to further appreciate how understand just how much boiler code saving the observer pattern is 