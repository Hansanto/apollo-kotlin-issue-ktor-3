Repository to show the conflict when we're using Ktor 3.X.X and Apollo-Engine-Ktor (4.0.0-beta.7) that uses Ktor 2.X.X

# How to see the problem

- Start the [main class](./src/main/kotlin/Main.kt)
- See the error in the console

````shell
1. Creation of client using basic http client
1. Error
Exception in thread "main" java.lang.NoClassDefFoundError: io/ktor/client/plugins/HttpTimeout
````

# How to remove the problem

- Go on the file [build.gradle.kts](build.gradle.kts)
- Uncomment the line 14
- Comment the line 15
- Start the [main class](./src/main/kotlin/Main.kt)
- See the result

(You can also try by removing the apollo dependency and modifying the code to remove the apollo part)

````shell
1. Creation of client using basic http client
1. Success
2. Creation of client using default constructor
2. Success
````
