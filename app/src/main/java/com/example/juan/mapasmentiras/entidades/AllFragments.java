package com.example.juan.mapasmentiras.entidades;

import com.example.juan.mapasmentiras.fragments.Hoteles;
import com.example.juan.mapasmentiras.fragments.Inicio;
import com.example.juan.mapasmentiras.fragments.Restaurantes;
import com.example.juan.mapasmentiras.fragments.Sitios;

public interface AllFragments extends
        Inicio.OnFragmentInteractionListener,
        Hoteles.OnFragmentInteractionListener,
        Restaurantes.OnFragmentInteractionListener,
        Sitios.OnFragmentInteractionListener {
}
