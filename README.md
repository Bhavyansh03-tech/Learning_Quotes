# Quotes App

This project is a quotes app developed for learning purposes, focusing on demonstrating how to display items in a LazyColumn and access data from a JSON file within the project. The app does not rely on any external API and is built using the MVVM architecture.

## Description

The Quotes App is designed to showcase the implementation of displaying quotes fetched from a locally stored JSON file. It emphasizes the MVVM architecture pattern and demonstrates loading data from the JSON file directly within the app.

## Features

- **Display Quotes**: Quotes are displayed in a user-friendly format using LazyColumn.
- **Local Data Access**: Quotes are loaded from a JSON file stored within the project.

  ## Screenshots

<div style="display: flex; justify-content: center; align-items: center;">
    <img src="https://github.com/Bhavyansh03-tech/Learning_Quotes/assets/96388594/bd389393-619c-4be2-8b76-90e66e7a8e6b" alt="Loading Page" style="width: 200px; height: auto; margin-right: 10px;">
    <img src="https://github.com/Bhavyansh03-tech/Learning_Quotes/assets/96388594/37cd172b-fd4c-436a-a39d-6583d4d142f8" alt="First Screen" style="width: 200px; height: auto; margin-right: 10px;">
    <img src="https://github.com/Bhavyansh03-tech/Learning_Quotes/assets/96388594/5e6a740c-26c2-4c27-8e40-a07727b47b05" alt="Second Second" style="width: 200px; height: auto;">
</div>

## Usage

1. Clone the repository:
    ```bash
    git clone https://github.com/Bhavyansh03-tech/Learning_Quotes.git
    ```
2. Open the project in your preferred IDE.
3. Run the app on an Android emulator or device.

## Implementation Details

To load quotes from the JSON file, the following function is used:

```kotlin
fun loadAssetsFromFile(context: Context){
    val inputStream = context.assets.open("quotes.json")
    val size: Int = inputStream.available()
    val buffer = ByteArray(size)
    inputStream.read(buffer)
    inputStream.close()
    val json = String(buffer, Charsets.UTF_8)
    val gson = Gson()
    data = gson.fromJson(json, Array<QuotesClass>::class.java)
    isDataLoaded.value = true
}
```

## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are greatly appreciated.

1.> Fork the Project.\
2.> Create your Feature Branch `git checkout -b feature/AmazingFeature`.\
3.> Commit your Changes `git commit -m 'Add some AmazingFeature'`.\
4.> Push to the Branch `git push origin feature/AmazingFeature`.\
5.> Open a Pull Request

## Acknowledgements

- Inspiration from various Android development tutorials and documentation.
## Contact

For questions or feedback, please contact [@Bhavyansh03-tech](https://github.com/Bhavyansh03-tech).
