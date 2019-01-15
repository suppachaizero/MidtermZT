package nerv.ruts.ac.th.midtermtungz;

import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class Main3Activity extends AppCompatActivity {
    TextView textuse, textpass;

    public FirebaseDatabase firebaseDatabase;
    public DatabaseReference Led1,Led2,refer1;
    private static final String TAG = " LEDs Control";
    public  Button sw1,sw2,btback;
    public String data;
    public Integer Value,value1,value2,value_refer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        firebaseDatabase = FirebaseDatabase.getInstance();
        Led1 = firebaseDatabase.getReference("led1");
        Led2 = firebaseDatabase.getReference("led2");
        textuse =(TextView)findViewById(R.id.textuser2);
        textpass=(TextView)findViewById(R.id.textpass2);
        refer1 = firebaseDatabase.getReference();
        sw1=(Button)findViewById(R.id.btsw1);
        sw2=(Button)findViewById(R.id.btsw2) ;

        textuse.setText(getIntent().getStringExtra("user"));
        textpass.setText(getIntent().getStringExtra("pass"));


       btback=(Button)findViewById(R.id.bc);
       btback.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(Main3Activity.this,MainActivity.class);
               startActivity(intent);
           }
       });
        refer1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map)dataSnapshot.getValue();
                data = String.valueOf(map.get("led1"));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        refer1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map)dataSnapshot.getValue();
                data = String.valueOf(map.get("led2"));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        Led1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Value = dataSnapshot.getValue(Integer.class);
                Log.d(TAG,"Value id Value"+Value);
                if (Value == 1){
                    sw1.setText("Led1-ON");
                    value1 = 0;
                }else {
                    sw1.setText("Led1-OFF");
                    value1 = 1;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG,"Error",databaseError.toException());

            }
        });
        sw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Led1.setValue(value1);
            }
        });
        Led2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Value = dataSnapshot.getValue(Integer.class);
                if (Value == 1){
                    sw2.setText("Led2 - ON");
                    value2=0;
                }else {
                    sw2.setText("Led2-OFF");
                    value2=1;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG,"Error",databaseError.toException());

            }
        });
        sw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Led2.setValue(value2);
            }
        });
}
    }