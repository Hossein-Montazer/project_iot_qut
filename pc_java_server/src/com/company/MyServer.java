package com.company;
import java.io.*;
import java.net.*;
public class MyServer {

    public static void main(String[] args) {
        System.out.println("server is running...");
        try {
            while (true){
            ServerSocket serverSocket = new ServerSocket(6000);
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String str = dataInputStream.readUTF();
            System.out.println("Client Says=" + str);

            //####################################################
            //client

            Socket sc = new Socket("192.168.100.4", 6000);
            char sr = '\n';
            String on = "on";
            //  System.out.println(str);
            if (str.equals(on)) {
                System.out.println(str);
                sr = 'o';
            } else if (str.equals("off")) {
                sr = 'f';
            }

            System.out.println(sr);
            int ascii = sr;
            System.out.println(ascii);
            DataOutputStream dataOutputStream = new DataOutputStream(sc.getOutputStream());
            //String str=dataInputStream.readUTF();
            dataOutputStream.write(ascii);
            dataOutputStream.flush();
            dataOutputStream.close();
            sc.close();
            serverSocket.close();
        }


        } catch (IOException e) {
            e.printStackTrace();
        }
        // write your code here
    }
}
