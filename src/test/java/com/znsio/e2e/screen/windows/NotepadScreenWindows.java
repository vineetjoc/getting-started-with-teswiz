package com.znsio.e2e.screen.windows;

import com.znsio.e2e.screen.NotepadScreen;
import com.znsio.e2e.tools.Driver;
import com.znsio.e2e.tools.Visual;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class NotepadScreenWindows
        extends NotepadScreen {
    private static final Logger LOGGER = Logger.getLogger(NotepadScreenWindows.class.getName());
    private final Driver driver;
    private final Visual visually;
    private final String SCREEN_NAME = NotepadScreenWindows.class.getSimpleName();
    private final By byEditorName = By.name("Text Editor");

    public NotepadScreenWindows(Driver driver, Visual visually) {
        this.driver = driver;
        this.visually = visually;
    }

    @Override
    public NotepadScreen takeScreenshot() {
        visually.takeScreenshot(SCREEN_NAME, "Notepad launched");
        return this;
    }

    @Override
    public NotepadScreen typeMessage(String message) {
        LOGGER.info(String.format("Typing message: '%s'", message));
        driver.findElement(byEditorName).sendKeys(message);
        visually.takeScreenshot(SCREEN_NAME, "Typed message in Notepad");
        return this;
    }
}
