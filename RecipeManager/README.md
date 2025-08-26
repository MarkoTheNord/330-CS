# RecipeManager (Compose + Hilt + Flow + Retrofit)

CRUD Android app template for CS330 project.

## Backend (json-server)

1) Install: `npm install -g json-server`
2) Run: `json-server --watch db.json --port 3000`
3) Android Emulator base URL is `http://10.0.2.2:3000/`

## Endpoints
- GET/POST `recipes`
- GET/PUT/DELETE `recipes/{id}`
- GET/POST `authors`

## Run the app
- Open in Android Studio (Arctic/Koala+ recommended)
- Sync Gradle and run on emulator

## Tech
- Jetpack Compose
- Hilt
- Kotlin Coroutines + Flow
- Retrofit + Gson
- Coil (images)
