# Shoemaker

First time writing kotlin,take home assignment for implementation of Airwallex API (https://www.airwallex.com/docs/api#/Authentication/API_Access/Intro)

##

| Features                                          | Done |
| ------------------------------------------------- | ---- |
| Retrieves login bearer  |✓|
| Update login bearer|✓|
| Create payment intent |✓|
| Confirm payment intent |      |
| Tests for payment intent|✓|
| Create payment link|✓|
| Test for payment link|    |
| Simple front end |✓|

## Usage

Currently test payment queries
```
./gradlew test
```

```
./gradlew run
```

hosted on `127.0.0.1:8080`, (Note: this doesn't have much frontend feedback yet) 

## UI

![img.png](sampleView.png)

Hovering on an image css
![](sampleView2.png)

Clicking on an image would redirect to the checkout page handled by Airwallex