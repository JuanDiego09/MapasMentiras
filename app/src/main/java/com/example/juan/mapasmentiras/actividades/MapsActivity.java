package com.example.juan.mapasmentiras.actividades;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.juan.mapasmentiras.R;
import com.example.juan.mapasmentiras.entidades.LugaresVo;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        System.out.println("entra *****************++");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        ArrayList<LugaresVo> lugares=new ArrayList<>();
        LugaresVo miLugaresVo;
        for (int a=0;a<10;a++){
            miLugaresVo=new LugaresVo();
            miLugaresVo.setLatitud(4.545695136892776);
            miLugaresVo.setLongitud(-75.67256734597161);
            miLugaresVo.setNombre("Centro Comercial Portal del Quindío "+a);
            lugares.add(miLugaresVo);
        }
        LatLng centro;
        for (int i=0;i<lugares.size();i++){
            centro= new LatLng(lugares.get(i).getLatitud(), -lugares.get(i).getLatitud());
            mMap.addMarker(new MarkerOptions().position(centro).title(lugares.get(i).getNombre()+i));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(centro));
        }

        // Add a marker in Sydney and move the camera
       /* LatLng centro = new LatLng(4.545695136892776, -75.67256734597161);
        mMap.addMarker(new MarkerOptions().position(centro).title("Centro Comercial Portal del Quindío "));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(centro));
*/
        /*LatLng unicentro = new LatLng(4.537481262607865, -75.66655919777826);
        mMap.addMarker(new MarkerOptions().position(unicentro).title("Unicentro - Armenia."));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(unicentro));

        LatLng calima = new LatLng(4.5268715367044985, -75.68767354714349);
        mMap.addMarker(new MarkerOptions().position(calima).title("Calima Centro Comercial Armenia"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(calima));

        LatLng panaca = new LatLng(4.622357223916545, -75.76650045717768);
        mMap.addMarker(new MarkerOptions().position(panaca).title("Panaca"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(panaca));

        LatLng salento = new LatLng(4.621929466163072, -75.76083563173823);
        mMap.addMarker(new MarkerOptions().position(salento).title("Salento"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(salento));

        LatLng cafe = new LatLng(4.569482343671689, -75.74745929865719);
        mMap.addMarker(new MarkerOptions().position(cafe).title("Parque del Café"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cafe));

        LatLng eco = new LatLng(4.62470988694496, -75.7556428750854);
        mMap.addMarker(new MarkerOptions().position(eco).title("Eco Parque Peñas Blancas"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(eco));

        LatLng lulu1 = new LatLng(4.640840820686086, -75.56895314786989);
        mMap.addMarker(new MarkerOptions().position(lulu1).title("La Pequeña Granja de Mamá Lulú "));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lulu1));

        LatLng lulu2 = new LatLng(4.634125169564153, -75.57004748914797);
        mMap.addMarker(new MarkerOptions().position(lulu2).title("La Pequeña Granja de Mamá Lulú, es un paraíso ecológico "));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lulu2));

        LatLng parque = new LatLng(4.531577482735009, -75.64214036690667);
        mMap.addMarker(new MarkerOptions().position(parque).title("Parque Los Arrieros"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(parque));

        LatLng ubicacion = new LatLng(4.5410252, -75.66828399999997);
        mMap.addMarker(new MarkerOptions().position(ubicacion).title("Ubicacion"));//icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_menu_share)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion));*/
       // mMap.setMinZoomPreference(10);
    }

}
