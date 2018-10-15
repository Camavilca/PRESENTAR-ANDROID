package com.camavilca.orlando.p04.frames;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.camavilca.orlando.p04.R;
import com.camavilca.orlando.p04.repository.RepositoryMascota;

public class Registrar extends Fragment {

    EditText nom;
    EditText raz;
    EditText eda;
    Button btn;
    public Registrar() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =   inflater.inflate(R.layout.fragment_registrar, container, false);
        nom = (EditText)view.findViewById(R.id.registro_nombre);
        raz = (EditText)view.findViewById(R.id.registro_raza);
        eda = (EditText)view.findViewById(R.id.registro_edad);
        btn = (Button)view.findViewById(R.id.btn_fragment_guardar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = nom.getText().toString();
                String raza = raz.getText().toString();
                String edad = eda.getText().toString();
                ///int e = Integer.parseInt(edad);

                if(nombre.isEmpty() || raza.isEmpty() || edad.isEmpty()){
                    Toast.makeText(getContext(),"Los campos son requeridos",Toast.LENGTH_LONG).show();
                }
                RepositoryMascota.create(nombre,raza,edad);
                limpiar();
            }
        });
        return view;
    }
    public void onButtonPressed(Uri uri) {}
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
    @Override
    public void onDetach() {
        super.onDetach();
    }
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
    public void validarYguardarDatos(){

    }

    private void limpiar() {
        nom.setText("");
        raz.setText("");
        eda.setText("");
    }


}
