package com.google.firebase.codelab.mlkit;

import android.os.AsyncTask;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static com.google.firebase.codelab.mlkit.ChangeIpActivity.IpAddr;
import static com.google.firebase.codelab.mlkit.ChangeIpActivity.port;
import static com.google.firebase.codelab.mlkit.OutputActivity.output;

class SendTextActivity {
    private static Socket socket;
    public static void send()
    {
        SendTask sendTask = new SendTask();
        sendTask.execute();
    }

    static class SendTask extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                socket = new Socket(IpAddr, port);
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF(output);
                dos.flush();
                dos.close();
                socket.close();
            }
            catch (IOException e) {
                e.getStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
