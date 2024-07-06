package it.unibas.progetto.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import it.unibas.progetto.R;
import it.unibas.progetto.vista.VistaLogin;

public class ActivityLogin extends AppCompatActivity {

    private ProgressDialog progressDialog;

    public static final String TAG = ActivityLogin.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_login);
    }

    public void mostraMessaggioErrori(String err){
        Toast.makeText(this, err, Toast.LENGTH_LONG);
    }

    public void mostraFinestraCaricamento(){
        this.progressDialog = ProgressDialog.show(this, "Caricamento", "Caricamento in corso...", true);
        this.progressDialog.show();
    }

    public void chiudiFinestraCaricamento(){
        this.progressDialog.dismiss();
    }

    public VistaLogin getVistaLogin() {
        return (VistaLogin) getSupportFragmentManager().findFragmentById(R.id.vistaLogin);
    }
}
