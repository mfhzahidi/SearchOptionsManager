package au.com.nextdot.searchoptionsmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Spinner spinner;
    private TextView textView1,textView2,textView3;
    private String group1="",group2="",group3="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferenceManager sharedPreferenceManager=SharedPreferenceManager.getInstance(this);
        button=(Button)findViewById(R.id.button);
        spinner=(Spinner)findViewById(R.id.spinner_search);

        String[] search_options=new String[]{"A+","AB+","B+","O+","A-","AB-","B-","O-"};
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,search_options);
        spinner.setAdapter(adapter);
        textView1=(TextView)findViewById(R.id.listtext1);
        textView2=(TextView)findViewById(R.id.listtext2);
        textView3=(TextView)findViewById(R.id.listtext3);


        group1=sharedPreferenceManager.getGroup1(group1,"group1");
        group2=sharedPreferenceManager.getGroup2(group2,"group2");
        group3=sharedPreferenceManager.getGroup3(group3,"group3");
        Log.d("group1",group1);
        textView1.setText(group1);
        textView2.setText(group2);
        textView3.setText(group3);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String spinnerValue;

                spinnerValue=spinner.getSelectedItem().toString();
                //Log.d("spinner",spinnerValue);
                sharedPreferenceManager.setGroups("group1","group2","group3",spinnerValue,group1,group2);
                group1=sharedPreferenceManager.getGroup1(group1,"group1");
                group2=sharedPreferenceManager.getGroup2(group2,"group2");
                group3=sharedPreferenceManager.getGroup3(group3,"group3");
               // Log.d("group1",group1);
               // Log.d("group2",group2);
               // Log.d("group3",group3);

            }
        });

    }
}
