# Shoemaker

First time writing kotlin,take home assignment for implementation of Airwallex API (https://www.airwallex.com/docs/api#/Authentication/API_Access/Intro)

### Features

- <input type="checkbox" disabled checked/> Retrieves login bearer
- <input type="checkbox" disabled checked/> Create payment intent
- <input type="checkbox" disabled checked/> Unit testing for create payment intent & login
- <input type="checkbox" disabled/> Front end of the website
- <input type="checkbox" disabled/> Parse the API from documentation
- <input type="checkbox" disabled/> Process the payment

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