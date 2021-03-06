MonologFX
=========

After creating the DialogFX library for JavaFX, I received several suggestions and requests for additional or different
functionality, some of which ran counter to the interfaces and/or intent of the DialogFX "way of doing things". Great
ideas, but not completely compatible with the existing functionality. Wanting to incorporate these capabilities, 
I started over...incorporating some parts of DialogFX into the new MonologFX, as I called it, but taking it in a 
different direction when it seemed sensible to do so.

In the meantime, the OpenJFX team has released dialog code that will be refined and eventually incorporated into 
JavaFX and OpenJFX. Rather than just scrap the MonologFX code or hoard it, I'm releasing it here on GitHub with the 
hope that someone may find it useful, interesting, or entertaining. You may never need it, but regardless,
MonologFX is there for the taking.

Looking forward to ideas, discussions, etc. Share to learn!

All the best,
Mark Heckler
mark.heckler@gmail.com
@MkHeck

UPDATES:
--------
20131117 So many good ideas for enhancements! I'm pleased to announce that one of those in particular made this update: a timed dialog that doesn't require a user response before disappearing. I added fade in/out effects (similar to some well-known OS and email notifications) because it seemed the right thing to do. :) See the `setDisplayTime(int displayTime)` method for more information.

I also made some much-needed (at least in my mind) architectural changes to MonologFX. I'm not done, but this is a good start. :)

20130408 For those who are still finding MonologFX useful, thank you! Your feedback & ideas have encouraged me to continue maintaining and improving it. I'll be updating the JFXtras lib with the updates as well, so please take a look at all the other things (in addition to dialogs) that it has to offer. Best coding!