package com.example.tp1;

import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import android.os.RemoteException;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);
    @After
    public void wrapUp() {
        System.out.println("Test done");
    }
    @Before
    public void setComponent() {
        System.out.println("Components initialize");
    }
    @Test
    public void testBackKeyPress() {
        UiDevice.getInstance(getInstrumentation()).pressBack();
    }
    @Test
    public void testUi() throws RemoteException {
        UiDevice uiDevice = UiDevice.getInstance(getInstrumentation());
        if (uiDevice.isScreenOn()) {
            uiDevice.setOrientationLeft();
            uiDevice.openNotification();
            uiDevice.openQuickSettings();
            uiDevice.pressHome();
        }
    }
    @Test
    public void testComplexUi() throws RemoteException {
        UiDevice uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        if (uiDevice.isScreenOn()) {
            uiDevice.openNotification();
            uiDevice.pressBack();
            uiDevice.openQuickSettings();
            uiDevice.freezeRotation();
            uiDevice.setOrientationLeft();
            uiDevice.setOrientationRight();
            uiDevice.pressBack();
            uiDevice.pressHome();
        }
    }
}