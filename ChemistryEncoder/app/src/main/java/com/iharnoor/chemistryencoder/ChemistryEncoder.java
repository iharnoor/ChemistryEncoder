package com.iharnoor.chemistryencoder;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        //enable copy pasting for Output TextView
        output.setTextIsSelectable(true);
        //encoding button
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                encodeButton(v);
            }
        });
        Button btn2 = (Button) findViewById(R.id.decode);
        //decoding button
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decodeButton(v);
            }
        });

        output.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickOuput(v);
            }
        });
    }

    void encodeButton(View v) {
        if (!isEmpty(key) && !isEmpty(message)) {
            int key2 = Integer.parseInt(key.getText().toString());
            String encodedMes = encryption.encode(message.getText().toString(), key2);
            output.setText(encodedMes);
        } else output.setText("Please enter both Message and Key");
    }

    void decodeButton(View v) {
        if (!isEmpty(key) && !isEmpty(message)) {
            int key2 = Integer.parseInt(key.getText().toString());
            String decodedMes = encryption.decode(message.getText().toString(), key2);
            output.setText(decodedMes);
        } else output.setText("Please enter both Message and Key");
    }

    void onClickOuput(View view) {
        ClipboardManager cm = (ClipboardManager) this.getSystemService(Context.CLIPBOARD_SERVICE);
        cm.setText(output.getText());
        Toast.makeText(this, "Copied to clipboard", Toast.LENGTH_SHORT).show();
    }

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

}
