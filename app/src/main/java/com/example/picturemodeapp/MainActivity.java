package com.example.picturemodeapp;
//
//
//import androidx.appcompat.app.AppCompatActivity;
//import android.*;
//import android.app.Activity;
//import android.app.ActivityManager;
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.content.IntentFilter;
//import android.content.SharedPreferences;
//import android.content.pm.PackageManager;
//import android.location.Address;
//import android.location.Geocoder;
//import android.preference.PreferenceManager;
//import android.renderscript.Double2;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.content.ContextCompat;
//import androidx.core.app.ActivityCompat;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Locale;
//import android.app.PictureInPictureParams;
//import android.os.Bundle;
//
//public class MainActivity extends AppCompatActivity {
//
//    Button btn_start;
//    private static final int REQUEST_PERMISSIONS = 100;
//    boolean boolean_permission;
//    TextView tv_latitude, tv_longitude, tv_address, tv_area, tv_locality;
//    SharedPreferences mPref;
//    SharedPreferences.Editor medit;
//    Double latitude, longitude;
//    Geocoder geocoder;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        btn_start = (Button) findViewById(R.id.btn_start);
//        tv_address = (TextView) findViewById(R.id.tv_address);
//        tv_latitude = (TextView) findViewById(R.id.tv_latitude);
//        tv_longitude = (TextView) findViewById(R.id.tv_longitude);
//        tv_area = (TextView) findViewById(R.id.tv_area);
//        tv_locality = (TextView) findViewById(R.id.tv_locality);
//        geocoder = new Geocoder(this, Locale.getDefault());
//        mPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//        medit = mPref.edit();
//
//
//        btn_start.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (boolean_permission) {
//
//                    if (mPref.getString("service", "").matches("")) {
//                        medit.putString("service", "service").commit();
//
//                        Intent intent = new Intent(getApplicationContext(), GoogleService.class);
//                        startService(intent);
//
//                    } else {
//                        Toast.makeText(getApplicationContext(), "Service is already running", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Toast.makeText(getApplicationContext(), "Please enable the gps", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });
//
//        fn_permission();
//    }
//
//    private void fn_permission() {
//        if ((ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
//
//            if ((ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, android.Manifest.permission.ACCESS_FINE_LOCATION))) {
//
//
//            } else {
//                ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION
//
//                        },
//                        REQUEST_PERMISSIONS);
//
//            }
//        } else {
//            boolean_permission = true;
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//
//        switch (requestCode) {
//            case REQUEST_PERMISSIONS: {
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    boolean_permission = true;
//
//                } else {
//                    Toast.makeText(getApplicationContext(), "Please allow the permission", Toast.LENGTH_LONG).show();
//
//                }
//            }
//        }
//    }
//
//    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//
//            latitude = Double.valueOf(intent.getStringExtra("latutide"));
//            longitude = Double.valueOf(intent.getStringExtra("longitude"));
//
//            List<Address> addresses = null;
//
//            try {
//                addresses = geocoder.getFromLocation(latitude, longitude, 1);
//                String cityName = addresses.get(0).getAddressLine(0);
//                String stateName = addresses.get(0).getAddressLine(1);
//                String countryName = addresses.get(0).getAddressLine(2);
//
//                tv_area.setText(addresses.get(0).getAdminArea());
//                tv_locality.setText(stateName);
//                tv_address.setText(countryName);
//
//
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
//
//
//            tv_latitude.setText(latitude + "");
//            tv_longitude.setText(longitude + "");
//            tv_address.getText();
//
//
//        }
//    };
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        registerReceiver(broadcastReceiver, new IntentFilter(GoogleService.str_receiver));
//
//
//        ActivityCompat.requestPermissions( this,
//                new String[] {
//
//                        Manifest.permission.ACCESS_COARSE_LOCATION,
//                        Manifest.permission.ACCESS_FINE_LOCATION,
//                        Manifest.permission.ACCESS_BACKGROUND_LOCATION
//                },
//                PackageManager.PERMISSION_GRANTED  );
//
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        unregisterReceiver(broadcastReceiver);
//    }
//
//
//
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_main);
////    }
//    @Override
//    public void onUserLeaveHint () {
//
//
//        PictureInPictureParams pictureInPictureParams = new PictureInPictureParams.Builder().build();
//              enterPictureInPictureMode(pictureInPictureParams);
//
//    }
//}


import androidx.appcompat.app.AppCompatActivity;



import android.Manifest;

import android.app.AlertDialog;

import android.content.Context;

import android.content.DialogInterface;

import android.content.Intent;

import android.content.IntentSender;

import android.location.LocationManager;

import android.net.Uri;

import android.os.Bundle;

import android.provider.Settings;

import android.view.View;

import android.widget.Button;



import com.google.android.gms.common.api.ResolvableApiException;

import com.google.android.gms.location.LocationRequest;

import com.google.android.gms.location.LocationServices;

import com.google.android.gms.location.LocationSettingsRequest;

import com.google.android.gms.location.LocationSettingsResponse;

import com.karumi.dexter.Dexter;

import com.karumi.dexter.MultiplePermissionsReport;

import com.karumi.dexter.PermissionToken;

import com.karumi.dexter.listener.PermissionRequest;

import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;



public class MainActivity extends AppCompatActivity {

    private Button btn_get;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);



        btn_get = findViewById(R.id.btn_get);

        btn_get.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {

                    enableLocationSettings();

                } else {

                    requestAppPermissions();

                }

            }

        });

    }

    private void requestAppPermissions() {

        Dexter.withActivity(MainActivity.this)

                .withPermissions(

                        Manifest.permission.ACCESS_FINE_LOCATION,

                        Manifest.permission.ACCESS_COARSE_LOCATION)

                .withListener(new MultiplePermissionsListener() {

                    @Override

                    public void onPermissionsChecked(MultiplePermissionsReport report) {

                        // check if all permissions are granted

                        if (report.areAllPermissionsGranted()) {

                            // do you work now

                            //interact.downloadImage(array);

                            startService(new Intent(MainActivity.this, ForegroundService.class));

                        }



                        // check for permanent denial of any permission

                        if (report.isAnyPermissionPermanentlyDenied()) {

                            // permission is denied permenantly, navigate user to app settings

                            showSettingsDialog();

                            //finish();

                        }

                    }

                    @Override

                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {

                        token.continuePermissionRequest();

                    }

                })

                .onSameThread()

                .check();

    }

    private void showSettingsDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Need Permissions");

        builder.setMessage("This app needs permission to use this feature. You can grant them in app settings.");

        builder.setPositiveButton("GOTO SETTINGS", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();

                openSettings();

            }

        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();

            }

        });

        builder.show();

    }

    private void openSettings() {

        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);

        Uri uri = Uri.fromParts("package", getPackageName(), null);

        intent.setData(uri);

        startActivityForResult(intent, 101);

    }

    protected void enableLocationSettings() {

        LocationRequest locationRequest = LocationRequest.create()

                .setInterval(1000)

                .setFastestInterval(3000)

                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()

                .addLocationRequest(locationRequest);

        LocationServices

                .getSettingsClient(this)

                .checkLocationSettings(builder.build())

                .addOnSuccessListener(this, (LocationSettingsResponse response) -> {

                    // startUpdatingLocation(...);

                })

                .addOnFailureListener(this, ex -> {

                    if (ex instanceof ResolvableApiException) {

                        // Location settings are NOT satisfied,  but this can be fixed  by showing the user a dialog.

                        try {

                            // Show the dialog by calling startResolutionForResult(),  and check the result in onActivityResult().

                            ResolvableApiException resolvable = (ResolvableApiException) ex;

                            resolvable.startResolutionForResult(this, 123);

                        } catch (IntentSender.SendIntentException sendEx) {

                            // Ignore the error.

                        }

                    }

                });

    }

}

