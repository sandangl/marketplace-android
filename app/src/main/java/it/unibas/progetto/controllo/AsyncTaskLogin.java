package it.unibas.progetto.controllo;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import it.unibas.progetto.Applicazione;
import it.unibas.progetto.activity.ActivityLogin;
import it.unibas.progetto.modello.Costanti;
import it.unibas.progetto.modello.RispostaErroreDTO;
import it.unibas.progetto.modello.RispostaLoginDTO;
import it.unibas.progetto.modello.UtenteDTO;
import it.unibas.progetto.persistenza.DAOGenericoJson;

public class AsyncTaskLogin extends AsyncTask<UtenteDTO, Void, String> {

    public static final String TAG = AsyncTaskLogin.class.getSimpleName();

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        ActivityLogin activityLogin = (ActivityLogin) Applicazione.getInstance().getCurrentActivity();
        activityLogin.mostraFinestraCaricamento();
    }

    @Override
    protected String doInBackground(UtenteDTO... utenteDTOS) {
        UtenteDTO utenteDTO = utenteDTOS[0];
        try{
            URL url = new URL(Costanti.API_URL + "/utenti/login");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("accept", "application/json");
            connection.setDoOutput(true);
            DAOGenericoJson daoGenericoJson = new DAOGenericoJson();
            String body = daoGenericoJson.toJson(utenteDTO);
            PrintWriter writer = new PrintWriter(connection.getOutputStream());
            writer.write(body);
            writer.flush();
            connection.connect();
            int esito = connection.getResponseCode();
            if(esito != 200){
                RispostaErroreDTO rispostaErroreDTO = daoGenericoJson.carica(connection.getInputStream(), RispostaErroreDTO.class);
                Log.d(TAG, "Ricevuta risposta errore: "+ rispostaErroreDTO.getError());
                return rispostaErroreDTO.getError();
            }
            RispostaLoginDTO rispostaLoginDTO = daoGenericoJson.carica(connection.getInputStream(), RispostaLoginDTO.class);
            Applicazione.getInstance().getModelloPersistente().saveBean(Costanti.RISPOSTA_LOGIN, rispostaLoginDTO);
            return null;
        } catch (Exception e) {
            Log.d(TAG, "Eccezione in fase di login: " + e.getLocalizedMessage());
            return e.getLocalizedMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        ActivityLogin activityLogin = (ActivityLogin) Applicazione.getInstance().getCurrentActivity();
        activityLogin.chiudiFinestraCaricamento();
        if(s != null){
            activityLogin.mostraMessaggioErrori(s);
            return;
        }

    }
}
