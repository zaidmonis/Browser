package zaidstudios.browseit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button gobutton;
    private String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        gobutton = findViewById(R.id.gobutton);

        gobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url = editText.getText().toString();
                if (url.startsWith("http://")){
                    url = url;
                }
                else{
                    if (url.endsWith(".com")||url.endsWith(".in")||url.endsWith(".org")||url.endsWith(".net")){
                        url = "http://" + url;
                    }
                    else{
                        url = "https://www.google.co.in/search?q=" + url;
                        url.replaceAll(" ", "%20");
                    }

                }
                Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });
    }
}
