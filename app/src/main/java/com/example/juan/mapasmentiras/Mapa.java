package com.example.juan.mapasmentiras;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.juan.mapasmentiras.actividades.MainActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Mapa extends AppCompatActivity {
    RequestQueue request;

    LinearLayout colr;
    LatLng sydney;
    boolean enviar = false;
    CountDownTimer timer;

    String lactitudI = "";
    String longitudI = "";

    Location instLoc = new Location("punto1");
    float distance;

    TextView tiempo, lat, lon, distancia;
    Button buscar;

    double webLactitud;
    double webLongitud;
    int enviado = 0;

    LocationManager locationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        request = Volley.newRequestQueue(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        tiempo = findViewById(R.id.tiempo);
        lat = findViewById(R.id.latitud);
        lon = findViewById(R.id.longitud);
        buscar = findViewById(R.id.buscar);
        distancia = findViewById(R.id.dista);
        //tiempo();

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                timer.cancel();
                enviado = 1;
                locationStart();
            }
        });

    }

    private void tiempo() {
        timer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long l) {
                //Toast.makeText(getApplicationContext(), "tiempo " + l / 1000, Toast.LENGTH_SHORT).show();
                tiempo.setText("Tiempo " + l / 1000);
            }

            @Override
            public void onFinish() {
                timer.cancel();
                locationStart();
                enviar = true;
            }
        };
        timer.start();
    }

    private void locationStart() {
        LocationManager mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Mapa.Localizacion Local = new Mapa.Localizacion();
        final boolean gpsEnabled = mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (!gpsEnabled) {
            Intent settingsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(settingsIntent);
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
            return;
        }
        mlocManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, (LocationListener) Local);
        mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, (LocationListener) Local);
    }


    /* Aqui empieza la Clase Localizacion */
    public class Localizacion implements LocationListener {
        @SuppressLint("LongLogTag")
        @Override
        public void onLocationChanged(Location loc) {
            // Este metodo se ejecuta cada vez que el GPS recibe nuevas coordenadas
            // debido a la deteccion de un cambio de ubicacion


            if (enviado == 1) {

                lactitudI = "" + loc.getLatitude();
                longitudI = "" + loc.getLongitude();
                enviado = 1;
                LatLng point = new LatLng(webLactitud, webLongitud);
                instLoc.setLatitude(point.latitude);
                instLoc.setLongitude(point.longitude);
                distance = loc.distanceTo(instLoc);
                lat.setText("Latitud " + lactitudI);
                lon.setText("Longitud " + longitudI);
                distancia.setText("Distancia " + distance);
                cargarWebService(lactitudI, longitudI);
            } else {
                Toast.makeText(getApplicationContext(), " Cambio 0 ", Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onProviderDisabled(String provider) {
            // Este metodo se ejecuta cuando el GPS es desactivado
            // mensaje1.setText("GPS Desactivado");
        }

        @Override
        public void onProviderEnabled(String provider) {
            // Este metodo se ejecuta cuando el GPS es activado
            //mensaje1.setText("GPS Activado");
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            switch (status) {
                case LocationProvider.AVAILABLE:
                    Log.d("debug", "LocationProvider.AVAILABLE");
                    break;
                case LocationProvider.OUT_OF_SERVICE:
                    Log.d("debug", "LocationProvider.OUT_OF_SERVICE");
                    break;
                case LocationProvider.TEMPORARILY_UNAVAILABLE:
                    Log.d("debug", "LocationProvider.TEMPORARILY_UNAVAILABLE");
                    break;
            }
        }
    }

    private void cargarWebService(final String longitudIm, final String longitudFm) {
        String url;
        url = "https://contaniif.club/movil/gps.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                enviar = false;
                //timer.start();
                enviado = 0;
                webLactitud = Double.parseDouble(longitudIm);
                webLongitud = Double.parseDouble(longitudFm);
                Toast.makeText(getApplicationContext(), "Termino", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "No se pudo registrar el comentario" + error.toString(), Toast.LENGTH_LONG).show();
            }

        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> parametros = new HashMap<>();
                parametros.put("latitud", longitudIm);
                parametros.put("longitud", longitudFm);

                Log.i("************** ", " *  " + parametros.toString());
                return parametros;
            }

        };
        request.add(stringRequest);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        finish();
        timer.cancel();
    }
}
