package it.unibas.progetto.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import it.unibas.progetto.Applicazione;
import it.unibas.progetto.R;

public class VistaLogin extends Fragment {
    private EditText campoEmail;
    private EditText campoPassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.vista_login, container, false);
        this.campoEmail = vista.findViewById(R.id.campoEmail);
        this.campoPassword = vista.findViewById(R.id.campoPassword);
        Button bottoneLogin = vista.findViewById(R.id.bottoneLogin);
        bottoneLogin.setOnClickListener(Applicazione.getInstance().getControlloLogin().getAzioneLogin());
        return vista;
    }

    public String getEmail(){
        return this.campoEmail.getText().toString();
    }

    public String getPassword(){
        return this.campoPassword.getText().toString();
    }

    public void setErroreEmail(String error){
        this.campoEmail.setError(error);
    }

    public void setErrorePassword(String error){
        this.campoPassword.setError(error);
    }

}
