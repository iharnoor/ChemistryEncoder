package com.iharnoor.chemistryencoder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChemistryEncoder extends AppCompatActivity {
    EditText key;
    EditText message;
    Encryption encryption = new Encryption();
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemistry_encoder);
        message = (EditText) findViewById(R.id.msg);
        key = (EditText) findViewById(R.id.key);
        output = (TextView) findViewById(R.id.output);
        Button btn = (Button) findViewById(R.id.encode);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                encodeButton(v);
            }
        });
        Button btn2 = (Button) findViewById(R.id.decode);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decodeButton(v);
            }
        });

    }

    void encodeButton(View v) {
        int key2 = Integer.parseInt(key.getText().toString());
        String encodedMes = encryption.encode(message.getText().toString(), key2);
        output.setText(encodedMes);
    }

    void decodeButton(View v) {
        int key2 = Integer.parseInt(key.getText().toString());
        String decodedMes = encryption.decode(message.getText().toString(), key2);
        output.setText(decodedMes);
    }
}
