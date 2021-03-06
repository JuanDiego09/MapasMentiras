package com.example.juan.mapasmentiras.fragments;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.juan.mapasmentiras.R;
import com.example.juan.mapasmentiras.adapter.Adapter;
import com.example.juan.mapasmentiras.entidades.LugaresVo;
import com.example.juan.mapasmentiras.entidades.Puente;
import com.example.juan.mapasmentiras.utilidades.Conexion;
import com.example.juan.mapasmentiras.utilidades.Utilidades;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Sitios.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Sitios#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Sitios extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    RecyclerView recyclerView;
    ArrayList<LugaresVo> listaLugares;
    LugaresVo lugaresVo;
    Puente miPuente;
    Activity activity;

    SQLiteDatabase db;
    Conexion conn;

    public Sitios() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Sitios.
     */
    // TODO: Rename and change types and number of parameters
    public static Sitios newInstance(String param1, String param2) {
        Sitios fragment = new Sitios();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_sitios, container, false);

        conn = new Conexion(getContext(), "mapas", null, 1);
        recyclerView=vista.findViewById(R.id.recyclerSitios);
        listaLugares=new ArrayList<>();

        llenarArray();

        FloatingActionButton fab = (FloatingActionButton) vista.findViewById(R.id.btnFlotanteSitios);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                miPuente.pantalla(1);
            }
        });

        return vista;
    }

    private void llenarArray() {
        db = conn.getReadableDatabase();


        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_SITIOS,null);

        while (cursor.moveToNext()){
            lugaresVo=new LugaresVo();
            lugaresVo.setNombre(cursor.getString(0));
            lugaresVo.setDescripcionCorta(cursor.getString(1));
            lugaresVo.setDescripcionLarga(cursor.getString(2));
            lugaresVo.setUbicacion(cursor.getString(3));
            listaLugares.add(lugaresVo);
        }
        final Adapter miAdapter=new Adapter(listaLugares);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));
        recyclerView.setAdapter(miAdapter);


        miAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                miPuente.enviar(1,  listaLugares.get(recyclerView.getChildAdapterPosition(view)));
            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Activity){
            this.activity=(Activity) context;
            miPuente=(Puente) activity;
        }
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
