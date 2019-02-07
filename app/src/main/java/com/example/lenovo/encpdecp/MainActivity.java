package com.example.lenovo.encpdecp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.encpdecp.R;

public class MainActivity extends AppCompatActivity {

    Button button,encryp,decryp,home;
    EditText et;
    TextView tv;
    String a, enc = "", dec = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        encryp=findViewById(R.id.bt_enc);
        decryp=findViewById(R.id.bt_dec);
        tv=findViewById(R.id.text2);
        et=findViewById(R.id.et_text);
        home=findViewById(R.id.home);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(button.getText()=="Encryption") {
                    encryp();
                    et.setText("");
                }
                if(button.getText()=="decryption") {
                    decryp();
                }
            }
        });
    }


    public void ency(View view) {
        button.setVisibility(View.VISIBLE);
        home.setVisibility(View.VISIBLE);
        tv.setVisibility(View.VISIBLE);
        et.setVisibility(View.VISIBLE);
        encryp.setVisibility(View.INVISIBLE);
        decryp.setVisibility(View.INVISIBLE);
        button.setText("Encryption");
    }

    public void decryp(View view) {
        button.setVisibility(View.VISIBLE);
        tv.setVisibility(View.VISIBLE);
        et.setVisibility(View.VISIBLE);
        home.setVisibility(View.VISIBLE);
        encryp.setVisibility(View.INVISIBLE);
        decryp.setVisibility(View.INVISIBLE);
        button.setText("decryption");
    }

    public void home(View view) {
        tv.setVisibility(View.INVISIBLE);
        et.setVisibility(View.INVISIBLE);
        encryp.setVisibility(View.VISIBLE);
        decryp.setVisibility(View.VISIBLE);
        button.setVisibility(View.INVISIBLE);
        home.setVisibility(View.INVISIBLE);
    }
    private void encryp() {
            et.setFocusable(true);
            a = et.getText().toString();
            et.clearFocus();
            int n = a.length();
            for (int i = 0; i < n; i++) {
                int count = 1;
                while (i < n - 1 && a.charAt(i) == a.charAt(i + 1)) {
                    count++;
                    i++;
                }
                if (a.charAt(i) == ' ')
                    enc += " ";
                else
                    enc += a.charAt(i) + "" + count;
            }
        Toast.makeText(this, "" + enc, Toast.LENGTH_SHORT).show();
        tv.setVisibility(View.VISIBLE);
        tv.setText(enc);
    }
    public void decryp(){

           enc=et.getText().toString();
            StringBuilder str=new StringBuilder(enc);
            StringBuilder s=new StringBuilder();
            for(int i=str.length()-1;i>0;i=i-1)
            {
                if (str.charAt(i) == ' ') {
                    s.append(str.charAt(i));
                }
                else {
                    int k = str.charAt(i) - 48;
                    for (int j = k; j > 0; j--) {
                        s.append(str.charAt(i - 1));
                    }
                    i--;
                }
            }
            Toast.makeText(this,""+s.reverse(), Toast.LENGTH_SHORT).show();
            tv.setVisibility(View.VISIBLE);
            Log.i("string,",s.reverse().toString());
            tv.setText(s.reverse());
        }
}
