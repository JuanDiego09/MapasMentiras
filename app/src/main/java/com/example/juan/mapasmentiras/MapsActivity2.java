
package com.example.juan.mapasmentiras;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {

    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    private GoogleMap mMap;

    String polyline = "";
    List<LatLng> list;

    String lactitudI = "4.596616112679607";
    String longitudI = "-74.07291412353516";

    String lactitudF = "3.7162636347405167";
    String longitudF = "-74.0423583984375";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        cargarWebservices(lactitudI, longitudI, lactitudF, longitudF);

    }

    private void cargarWebservices(String lactitudI, String longitudI, String lactitudF, String longitudF) {
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

    }

    private List cargarPuntos(JSONObject json) {
        List lista = new ArrayList();

        List<List<HashMap<String, String>>> routes = new ArrayList<>();
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
    }


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
        public void onMapReady (GoogleMap googleMap){
            mMap = googleMap;

            // Add a marker in Sydney and move the camera
            LatLng sydney = new LatLng(-34, 151);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        }
    }
