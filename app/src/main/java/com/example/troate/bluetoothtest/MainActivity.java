package com.example.troate.bluetoothtest;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int REQUEST_ENABLE_BT=0;
        BluetoothAdapter mBA=BluetoothAdapter.getDefaultAdapter();
        if(mBA==null);//Device does no support Bluetooth

        if(mBA.isEnabled()) {
            Intent enableBT = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBT, REQUEST_ENABLE_BT);


            Set<BluetoothDevice> pairedDevices = mBA.getBondedDevices();
            ArrayAdapter<String> mArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
            if (pairedDevices.size() > 0) {
                for (BluetoothDevice device : pairedDevices) {
                    mArrayAdapter.add(device.getName() + "\n" + device.getAddress());
                }
            }
        }
    }
}
