package com.example.juan.mapasmentiras;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
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
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
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
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {

    RequestQueue request;

    private GoogleMap mMap;

    LatLng sydney;
    boolean enviar = false;
    CountDownTimer timer;

    String lactitudI = "";
    String longitudI = "";

    Location instLoc = new Location("punto1");
    float distance;


    double webLactitud;
    double webLongitud;
    int enviado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        request = Volley.newRequestQueue(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        tiempo();

    }

    private void tiempo() {
        timer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long l) {
                //Toast.makeText(getApplicationContext(), "tiempo " + l / 1000, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinish() {
                timer.cancel();
                locationStart();
            }
        };
        timer.start();
    }

    /*private void cargarWebservices(String lactitudI, String longitudI, String lactitudF, String longitudF) {
        //String url="https://maps.googleapis.com/maps/api/directions/json?origin=4.547195915737696,-75.66195130348206&destination=4.540984,-75.668126";
        //String url = "https://maps.googleapis.com/maps/api/directions/json?origin=" + lactitudI + "," + longitudI + "&destination=4.611758 + -74.071124";
        String url = "https://maps.googleapis.com/maps/api/directions/json?origin=" + lactitudI + "," + longitudI + "&destination=" + lactitudF + "," + longitudF;

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                cargarPuntos(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "No se puede conectar " + error.toString(), Toast.LENGTH_LONG).show();
            }
        });
        request.add(jsonObjectRequest);
    }

    private List cargarPuntos(JSONObject json) {
        List lista = new ArrayList();

        JSONArray Jroutes, Jlegs, Jsteps;


        try {
            Jroutes = json.getJSONArray("routes");
            for (int i = 0; i < Jroutes.length(); i++) {
                Jlegs = ((JSONObject) (Jroutes.get(i))).getJSONArray("legs");

                for (int j = 0; j < Jlegs.length(); j++) {

                    Jsteps = ((JSONObject) (Jlegs.get(j))).getJSONArray("steps");
                    for (int k = 0; k < Jsteps.length(); k++) {

                        polyline = "" + ((JSONObject) ((JSONObject) Jsteps.get(k)).get("polyline")).get("points");
                        List<LatLng> list = PolyUtil.decode(polyline);
                        mMap.addPolyline(new PolylineOptions().addAll(list).color(Color.GREEN));

                    }

                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return lista;
    }*/


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

    }


    private void locationStart() {
        LocationManager mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Localizacion Local = new Localizacion();
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

    public void setLocation(Location loc) {
        //Obtener la direccion de la calle a partir de la latitud y la longitud
        if (loc.getLatitude() != 0.0 && loc.getLongitude() != 0.0) {
            try {
                Geocoder geocoder = new Geocoder(this, Locale.getDefault());
                List<Address> list = geocoder.getFromLocation(
                        loc.getLatitude(), loc.getLongitude(), 1);
                if (!list.isEmpty()) {
                    Address DirCalle = list.get(0);
                    Toast.makeText(getApplicationContext(), "Mi direccion es: \n"
                            + DirCalle.getAddressLine(0), Toast.LENGTH_SHORT).show();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* Aqui empieza la Clase Localizacion */
    public class Localizacion implements LocationListener {
        MainActivity mainActivity;

        public MainActivity getMainActivity() {
            return mainActivity;
        }

        public void setMainActivity(MainActivity mainActivity) {
            this.mainActivity = mainActivity;
        }

        @SuppressLint("LongLogTag")
        @Override
        public void onLocationChanged(Location loc) {
            // Este metodo se ejecuta cada vez que el GPS recibe nuevas coordenadas
            // debido a la deteccion de un cambio de ubicacion
            lactitudI = "" + loc.getLatitude();
            longitudI = "" + loc.getLongitude();
            //cargarWebservices(lactitudI, longitudI, lactitudF, longitudF);
            if (enviado == 0) {
                cargarWebService(lactitudI, longitudI);
            } else if (enviado == 1) {
                LatLng point = new LatLng(webLactitud, webLongitud);
                //Toast.makeText(getApplicationContext(), webLactitud + " web " + webLongitud, Toast.LENGTH_LONG).show();
                instLoc.setLatitude(point.latitude);
                instLoc.setLongitude(point.longitude);
                distance = loc.distanceTo(instLoc);
                Toast.makeText(getApplicationContext(), ""+distance, Toast.LENGTH_SHORT).show();
                if (distance >= 500) {
                    Toast.makeText(getApplicationContext(), "es mayor"+distance, Toast.LENGTH_SHORT).show();
                    enviado = 0;
                    cargarWebService(lactitudI, longitudI);
                } else {
                    timer.start();
                }
            }
            sydney = new LatLng(loc.getLatitude(), loc.getLongitude());
            mMap.addMarker(new MarkerOptions().position(sydney));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
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
        url = "http://cursosena.xyz/registro.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (enviado == 0) {
                    webLactitud = Double.parseDouble(longitudIm);
                    webLongitud = Double.parseDouble(longitudFm);
                    enviado++;
                }
                //Toast.makeText(getApplicationContext(), longitudIm + " capturado " + longitudFm, Toast.LENGTH_LONG).show();

                //Toast.makeText(getApplicationContext(), " response " + response, Toast.LENGTH_LONG).show();
                timer.start();

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
                return parametros;
            }
        };

        request.add(stringRequest);
    }
}
