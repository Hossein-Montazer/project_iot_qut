package com.example.exam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientAndroid extends AppCompatActivity {
        EditText    txtIp,txtPort,txtMsg;
        Button      send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claient_android);
        txtIp=findViewById(R.id.txtIp);
        txtPort=findViewById(R.id.txtPort);
        txtMsg=findViewById(R.id.txtMsg);
        send=findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread t=new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {

                            Socket  s=new Socket(txtIp.getText().toString(),Integer.parseInt(txtPort.getText().toString()));
                            DataOutputStream dos=new DataOutputStream(s.getOutputStream());
                            dos.writeUTF(txtMsg.getText().toString());
                            dos.flush();
                            dos.close();
                            s.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                t.start();
            }
        });

    }
}
