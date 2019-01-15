package nerv.ruts.ac.th.midtermtungz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView textuse, textpass,textadd,textmul,textsub,textdiv;
    Button btback,succ;
    EditText num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

textuse= (TextView)findViewById(R.id.textuser);
textpass= (TextView)findViewById(R.id.textpass);

num1=(EditText)findViewById(R.id.num1);
num2=(EditText)findViewById(R.id.num2);

succ=(Button)findViewById(R.id.succ);

        textadd=(TextView)findViewById(R.id.textadd);
        textmul=(TextView)findViewById(R.id.textmul);
        textsub=(TextView)findViewById(R.id.textsub);
        textdiv=(TextView)findViewById(R.id.textdiv);


        textuse.setText(getIntent().getStringExtra("user"));
        textpass.setText(getIntent().getStringExtra("pass"));

btback=(Button)findViewById(R.id.buttonback);
btback.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Main2Activity.this,MainActivity.class);
     startActivity(intent);
    }
});

succ.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        int x = Integer.parseInt(num1.getText().toString());
        int y = Integer.parseInt(num2.getText().toString());
        int result = (x+y);
        int r = (x*y);
        int e = (x-y);
        int s =(x/y);
        textadd.setText(String.valueOf(result));
        textmul.setText(String.valueOf(r));
        textsub.setText(String.valueOf(e));
        textdiv.setText(String.valueOf(s));




    }
});


    }
}