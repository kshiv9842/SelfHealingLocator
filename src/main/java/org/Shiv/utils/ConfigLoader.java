package org.Shiv.utils;

import io.github.cdimascio.dotenv.Dotenv;

public class ConfigLoader {

    // Load the .env file
    private static final Dotenv dotenv = Dotenv.load();
    // Method to fetch the API URL from .env
    public static String getApiBaseURI() {
        return dotenv.get("GEMINIAI_API_BASE_URI");
    }
    public static String getApiBasePath() {
        return dotenv.get("GEMINIAI_API_BASE_PATH");
    }

    // Method to fetch the API key from .env
    public static String getApiKey() {
        return dotenv.get("GEMINIAI_API_KEY");
    }

    // Method to fetch the model from .env
    public static String getModel() {
        return dotenv.get("GEMINI_MODEL");
    }
   }
