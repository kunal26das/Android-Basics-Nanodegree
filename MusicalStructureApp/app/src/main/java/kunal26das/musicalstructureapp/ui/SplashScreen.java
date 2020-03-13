package kunal26das.musicalstructureapp.ui;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by kunal on 09-03-2020.
 */
public class SplashScreen extends Activity {

    @Override
    protected void onResume() {
        super.onResume();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
