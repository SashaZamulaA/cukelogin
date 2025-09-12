package com.example.cukelogin.test

import io.cucumber.junit.CucumberOptions

/**
 * Порожній клас тільки як носій @CucumberOptions.
 * ЙОГО НЕ ПОТРІБНО запускати, без @RunWith!
 */
@CucumberOptions(
    features = ["features"],                  // відносно app/src/androidTest/assets/
    glue = ["com.example.cukelogin.steps"],   // пакет зі Step Definition
    plugin = ["pretty"]                       // можна додати: "html:/sdcard/Download/cucumber.html"
)
class CucumberConfig
