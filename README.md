# Android Routes [![](https://jitpack.io/v/moh-abdullah-it/android-routes.svg)](https://jitpack.io/#moh-abdullah-it/android-routes)


Android Routes library is easy way to use android Intent
## Installation

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	...
	implementation 'com.github.moh-abdullah-it:android-routes:v0.1.0'
}
```


## Usage

1- Create your Route Class

``` Android
public class Route extends BaseRoute {

    public Route(Context context) {
        super(context);
    }
    /*
     * write routes hear
     */
    ....
}
```
2- add routes to `Route.java` example:

``` Android
    public Route mainActivity() {
        to(MainActivity.class);
        return this;
    }
```
3- in any place from your project can use route

``` Android
    Route route;

    route = new Route(this);

    route.mainActivity().start();
```
4- withData:

``` Android
    route.mainActivity()
         .withData("id",10)
         .withData("title","activity title")
         .start();
```

5- check condition before start:

``` Android
    route.mainActivity()
         .withData("id",10)
         .withData("title","activity title")
         .start(your condition here);
```
6- check route has data:
``` Android
    if(route.has("id")){
      //this is true
    }
```
7- get data from route:
``` Android
    Int id = route.getInt("id");
    String title = route.getString("title");
```
## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.
