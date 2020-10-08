package com.javadev.httpserver.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.javadev.httpserver.util.Json;

import java.io.FileReader;
import java.io.IOException;

public class ConfigManager {

    private static ConfigManager myConfigManager;
    private static Configuration myCurrentConfig;

    private ConfigManager() {
    }

    public static ConfigManager getInstance() {
        if (myConfigManager == null) {
            myConfigManager = new ConfigManager();

        }
        return myConfigManager;
    }

    //Load Config file by the path provided
    public void loadConfigFile(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        StringBuffer sb = new StringBuffer();
        int i;
        while ((i = fileReader.read()) != -1) {
            sb.append((char) i);
        }
        JsonNode conf = Json.parse(sb.toString());
        myCurrentConfig = Json.fromJson(conf, Configuration.class);
    }

    public Configuration getCurrentConfig() {
        if (myCurrentConfig == null) {

        }
        return myCurrentConfig;
    }
}
