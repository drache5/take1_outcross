package outcross.com.coffeehistory;

import android.app.Application;
import android.content.pm.PackageManager.NameNotFoundException;

public class CoffeeApplication extends Application {

    public static final String appName = "CoffeeHistory";

    private static final boolean ENABLED_LOGGING_LIFECYCLE = false;

    private static CoffeeApplication INSTANCE;

	private static final String TAG = CoffeeApplication.class.getSimpleName();


    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }

    public static CoffeeApplication getInstance() {
        return INSTANCE;
    }


    public String getUserAgent() {
        String version = android.os.Build.VERSION.RELEASE + "|" + android.os.Build.VERSION.SDK_INT;
        String userAgent = appName + " (" + android.os.Build.MODEL + "; U; Android " + version + "; ko-kr) "+ "/" + getVersionName();
		return userAgent;
	}

	public String getVersionName() {
		try {
			return getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
		} catch (NameNotFoundException e) {
			return "0.0.0";
		}
	}

	public int getVersionCode() {
		try {
			return getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
		} catch (NameNotFoundException e) {
			return 0;
		}
	}
}
