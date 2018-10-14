package com.example.juan.mapasmentiras;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
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
import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class Map extends AppCompatActivity {
    TextView mensaje1;
    TextView mensaje2, txtlatitud, txtlongitud;
    Button buca;
    double webLactitud, webLongitud;
    Location instLoc = new Location("punto1");
    double distance;
    int capturaNumero = 0;
    RequestQueue request;
    LinearLayout colores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        request = Volley.newRequestQueue(getApplicationContext());

        setContentView(R.layout.activity_map);
        mensaje1 = (TextView) findViewById(R.id.mensaje_id);
        mensaje2 = (TextView) findViewById(R.id.mensaje_id2);
        txtlatitud = findViewById(R.id.latitud);
        txtlongitud = findViewById(R.id.longitud);
        buca = findViewById(R.id.buscar);
        colores = findViewById(R.id.colores);

        buca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscar();
            }
        });

    }

    private void buscar() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
            Toast.makeText(this, "eNTRO 1", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "eNTRO 2", Toast.LENGTH_SHORT).show();
            locationStart();
        }
    }

    private void locationStart() {
        LocationManager mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Localizacion Local = new Localizacion();
        Local.setMainActivity(this);
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

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1000) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                locationStart();
                return;
            }
        }
    }

    /* Aqui empieza la Clase Localizacion */
    public class Localizacion implements LocationListener {

        Map mainActivity;

        public Map getMainActivity() {
            return mainActivity;
        }

        public void setMainActivity(Map mainActivity) {
            this.mainActivity = mainActivity;
        }

        @Override
        public void onLocationChanged(Location loc) {
            // Este metodo se ejecuta cada vez que el GPS recibe nuevas coordenadas
            // debido a la deteccion de un cambio de ubicacion
            loc.getLatitude();
            loc.getLongitude();
            if (capturaNumero == 0) {
                webLactitud = loc.getLatitude();
                webLongitud = loc.getLongitude();
                txtlatitud.setText("primera" + webLactitud);
                txtlongitud.setText("primera" + webLongitud);
                capturaNumero++;
            }
            String Text = "Mi ubicacion actual es: " + "\n Lat = "
                    + loc.getLatitude() + "\n Long = " + loc.getLongitude();
            mensaje1.setText(Text);

            LatLng point = new LatLng(webLactitud, webLongitud);
            instLoc.setLatitude(point.latitude);
            instLoc.setLongitude(point.longitude);
            distance = 0;
            distance = loc.distanceTo(instLoc);

            cambio(distance);
            mensaje2.setText(capturaNumero + " Distancia " + Double.toString(distance));
        }


        @Override
        public void onProviderDisabled(String provider) {
            // Este metodo se ejecuta cuando el GPS es desactivado
            mensaje1.setText("GPS Desactivado");
        }

        @Override
        public void onProviderEnabled(String provider) {
            // Este metodo se ejecuta cuando el GPS es activado
            mensaje1.setText("GPS Activado");
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

    private void cambio(double distance) {
        if (distance>=500){
            colores.setBackgroundColor(Color.BLUE);
            capturaNumero=0;
        }else {
            colores.setBackgroundColor(Color.YELLOW);
        }
    }

    private void cargarWebService(final String longitudIm, final String longitudFm) {
        String url;
        url = "http://cursosena.xyz/registro.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //timer.start();
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
            protected java.util.Map<String, String> getParams() throws AuthFailureError {

                java.util.Map<String, String> parametros = new HashMap<>();
                parametros.put("latitud", longitudIm);
                parametros.put("longitud", longitudFm);

                Log.i("************** ", " *  " + parametros.toString());
                return parametros;
            }

        };
        request.add(stringRequest);
    }


}