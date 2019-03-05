package nerv.ruts.ac.th.midtermtungz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    MediaPlayer m1;
    EditText user, pass;
    Button buttonok,bt2,btgo,map;
    private RadioGroup rg;
    private RadioButton c1, fire;
    private MediaPlayer btsound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//btgo = (Button) findViewById(R.id.buttongo);
        buttonok = (Button) findViewById(R.id.buttonok);
        user = (EditText) findViewById(R.id.editUser);
        rg = (RadioGroup) findViewById(R.id.radgroup);
        map = (Button)findViewById(R.id.map);


        c1 = (RadioButton) findViewById(R.id.radiocal);
        fire = (RadioButton) findViewById(R.id.radiofirebase);


bt2=(Button)findViewById(R.id.buttonok2);


        pass = (EditText) findViewById(R.id.editPass);


        //m1 = MediaPlayer.create(this, R.raw.song);
       // m1.start();
       // m1.setLooping(true);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });
        buttonok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("user", user.getText().toString());
                intent.putExtra("pass", pass.getText().toString());
                startActivity(intent);
            }

            {
                soundButton();
            }

            private void soundButton() {
                btsound = MediaPlayer.create(getBaseContext(), R.raw.click);
                btsound.start();

            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main3Activity.class);
                intent.putExtra("user", user.getText().toString());
                intent.putExtra("pass", pass.getText().toString());
                startActivity(intent);
            }
        });

            }

}
