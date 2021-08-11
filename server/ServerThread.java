package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable {

    Thread thread;
    Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            double radius = Double.valueOf(bufferedReader.readLine());

            double area = getArea(radius);

            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println(area);

            MyServer.appendString(radius, area);

        } catch (IOException e) {
            System.out.println("Some Error is Occured In Threads .....");
        }

    }

    public static double getArea(double radius) {
        double area = Math.PI * radius * radius;
        return area;
    }

}
