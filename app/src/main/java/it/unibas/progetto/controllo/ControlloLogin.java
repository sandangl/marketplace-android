package it.unibas.progetto.controllo;

import android.util.Log;
import android.view.View;

import it.unibas.progetto.Applicazione;
import it.unibas.progetto.activity.ActivityLogin;
import it.unibas.progetto.modello.UtenteDTO;
import it.unibas.progetto.vista.VistaLogin;

public class ControlloLogin{

    private View.OnClickListener azioneLogin = new AzioneLogin();

    public View.OnClickListener getAzioneLogin() {
        return azioneLogin;
    }

    class AzioneLogin implements View.OnClickListener{

        private String TAG = AzioneLogin.class.getSimpleName();

        @Override
        public void onClick(View view) {
            Log.d(TAG, "Login...");
            //Prendo la vista e i suoi campi di interesse
            ActivityLogin activityLogin = (ActivityLogin) Applicazione.getInstance().getCurrentActivity();
            VistaLogin vistaLogin = activityLogin.getVistaLogin();
            String email = vistaLogin.getEmail().trim();
            String password = vistaLogin.getPassword();
            String errori = this.convalida(email, password, vistaLogin);
            if (!errori.isEmpty()) {
                activityLogin.mostraMessaggioErrori(errori);
                return;
            }
            UtenteDTO utenteDTO = new UtenteDTO(email, password);
            Log.d(TAG,"Utente DTO: "+utenteDTO);
            AsyncTaskLogin asyncTask = new AsyncTaskLogin();
            asyncTask.execute(utenteDTO);
        }

        private String convalida(String email, String password, VistaLogin vista){
            StringBuilder errori = new StringBuilder();
            if(email.isEmpty()){
                vista.setErroreEmail("Fornire un indirizzo email valido.");
                errori.append("Fornire un indirizzo email valido.");
            }
            if(password.isEmpty()){
                vista.setErroreEmail("Fornire una password.");
                errori.append("Fornire una password.");
            }
            return errori.toString();
        }
    }

}
