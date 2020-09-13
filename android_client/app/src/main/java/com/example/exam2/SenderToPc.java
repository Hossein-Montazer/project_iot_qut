package com.example.exam2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class SenderToPc extends AppCompatActivity {
    EditText editText1_port, editText2_ip, editText3_textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender_to_pc);
        editText3_textMessage =findViewById(R.id.textMessage);
        editText2_ip =findViewById(R.id.ipAddress);
        editText1_port =findViewById(R.id.port);
        Thread myThread =new Thread((new MyServer()));
        myThread.start();
    }

    class MyServer implements Runnable{
        ServerSocket serverSocket;
        Socket mySocket;
        DataInputStream dataInputStream;
        String textMessage;

        Handler handler=new Handler();
        @Override
        public void run() {
            try {
                serverSocket =new ServerSocket(6000);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),"wait for client",Toast.LENGTH_LONG).show();
                    }
                });
                while (true) {
                    mySocket = serverSocket.accept();
                    dataInputStream = new DataInputStream(mySocket.getInputStream());
                    textMessage = dataInputStream.readUTF();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "messag clinent:" + textMessage, Toast.LENGTH_LONG).show();
                        }
                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public  void button_click(View v){
        //String message=e1.getText().toString();

        BackgroundTask backgroundTask=new BackgroundTask();
            backgroundTask.execute(editText1_port.getText().toString(), editText2_ip.getText().toString(), editText3_textMessage.getText().toString());
    }


    class BackgroundTask extends AsyncTask<String,String,String>{
        Socket socket;
        DataOutputStream dataOutputStream;
        String ip,message,port;
        @Override
        protected String doInBackground(String... params) {
            ip=params[1];
            port=params[0];
            message=params[2];

            try {

                socket =new Socket(ip, Integer.parseInt(port));

                dataOutputStream =new DataOutputStream(socket.getOutputStream());

                dataOutputStream.writeUTF(message);

                dataOutputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
