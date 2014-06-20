Commons-Daemon-Wrapper
======================

A simple wrapper to run java programs via jsvc and commons-daemon

This little library will help you to run your Java program as a a deamon on your system, wihtout requiring any changes to your original program. The only prerequisite is that you have a main() entry point with which to start the program.

The wrapper works by using reflection to call the original program that you want to run. The first parameter for the wrapper is going to be the entry point in which the main() method can be found. Any further parameters are simply passed on to the main, so that you can still use your program the way you want.

To use the wrapper you need to follow these steps:

1. Make sure your program runs with all libraries and you have your classpath sorted out. If you have your command line start command working, you're ready to use the jsvc wrapper.

2. Compile the daemon wrapper into a jar and place the library somewhere (for example where all your other libraries are)

3. Customize the init.example script. The individual options are explained within the file.

4. Make sure jsvc is installed (for debian e.g. ```apt-get install jsvc```)

5. Run you init script to test if it works

6. Enable start up of your init script (however you distro manages start ups)