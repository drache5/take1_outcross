package outcross.com.coffeehistory;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.util.Log;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<CoffeeApplication> {

    final int appVersionCode = 1;
    final String appVersionName = "1.0";

    public ApplicationTest() {
        super(CoffeeApplication.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        createApplication();
    }

    /**
     * The name 'test preconditions' is a convention to signal that if this
     * test doesn't pass, the test case was not set up properly and it might
     * explain any and all failures in other tests.  This is not guaranteed
     * to run before other tests, as junit uses reflection to find the tests.
     */
    @SmallTest
    public void testPreconditions() {
    }

    /**
     * Test basic startup/shutdown of Application
     */
//    @MediumTest
//    public void testSimpleCreate() {
//        createApplication();
//    }


    public void testGetUserAgent(){
        String userAgent = getApplication().getUserAgent();
        Log.v("ApplicationTestCase", "testGetUserAgent: " + userAgent);
        assertNotNull(userAgent);
    }

    public void testGetVersionCode(){
        int versionCode = getApplication().getVersionCode();
        Log.v("ApplicationTestCase", "testGetVersionCode: " + versionCode);
        assertEquals("testGetVersionName",appVersionCode, versionCode);
    }

    public void testGetVersionName(){
        String versionName = getApplication().getVersionName();
        Log.v("ApplicationTestCase", "testGetVersionName: " + versionName);
        assertEquals("testGetVersionName",appVersionName, versionName);
    }

}
