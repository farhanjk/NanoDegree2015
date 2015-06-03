package nanodegree.udacity.project0;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupButtonClickResponses();
    }

    private void setupButtonClickResponses() {
        Button button = (Button) findViewById(R.id.buttonSpotify);
        button.setOnClickListener(new ResponseOnClickListener(this, (String) button.getText()));

        button = (Button) findViewById(R.id.buttonScores);
        button.setOnClickListener(new ResponseOnClickListener(this, (String) button.getText()));

        button = (Button) findViewById(R.id.buttonLibrary);
        button.setOnClickListener(new ResponseOnClickListener(this, (String) button.getText()));

        button = (Button) findViewById(R.id.buttonBigger);
        button.setOnClickListener(new ResponseOnClickListener(this, (String) button.getText()));

        button = (Button) findViewById(R.id.buttonXYZ);
        button.setOnClickListener(new ResponseOnClickListener(this, (String) button.getText()));

        button = (Button) findViewById(R.id.buttonCapstone);
        button.setOnClickListener(new ResponseOnClickListener(this, (String) button.getText()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private static class ResponseOnClickListener implements View.OnClickListener {

        private final String appName;
        private final WeakReference<Context> context;

        private ResponseOnClickListener(final Context context, final String appName) {
            this.appName = appName;
            this.context = new WeakReference<Context>(context);
        }

        @Override
        public void onClick(View v) {
            if (context.get() == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context.get(), "This is a button for " + appName, Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

}
