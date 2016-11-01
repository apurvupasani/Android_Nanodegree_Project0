package project.udacity.apurv.com.portfolioapp;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.StyleRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String toastPrefix = "This button will launch ";
    private static final int duration = Toast.LENGTH_SHORT;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onButtonClick(View view) {
            makeToast(view);
    }

    /**
     * This is a private method which is invoked on every button click. It gets the view from calling method
     * and generates a toast to display on the button.
     * @param view - ButtonView for which the button press event happens.
     */
    private void makeToast(final View view) {
        final Button b = (Button)view;
        final String buttonText = b.getText().toString();
        final Context context = getApplicationContext();
        final Toast toast = Toast.makeText(context, toastPrefix + buttonText.toLowerCase(), duration);
        toast.setGravity(Gravity.RIGHT |Gravity.TOP, view.getLeft(), view.getTop()+(view.getBottom()-view.getTop())/2);
        toast.show();
    }

}
