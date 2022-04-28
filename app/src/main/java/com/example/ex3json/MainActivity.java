package com.example.ex3json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    Etablissement etablissement;
    ListView ls;
    TextView t1, t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String res = loadJsonFromRaw(R.raw.etablissement);
        etablissement = getEtablissementFromJson(res);


    }


    public String loadJsonFromRaw(int resId) {
        String json = "";
        try {
            InputStream input = getResources().openRawResource(resId);
            int taille = 0;
            taille = input.available();
            byte[] content = new byte[taille];
            input.read(content);
            input.close();
            json = new String(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public Etablissement getEtablissementFromJson(String json){
        Etablissement etablissement=null;
        try {
            JSONObject obj = new JSONObject(json);

            etablissement.setNom(obj.getString("nom"));
            etablissement.setAdresse(obj.getString("adresse"));
            JSONArray array = obj.getJSONArray("filiere");

            for(int i=0;i<array.length();i++){
                JSONObject o = array.getJSONObject(i);
                Filiere fil = new Filiere();

                fil.setNom(o.getString("nom"));
                fil.setNomComplet(o.getString("nomComplet"));
                fil.setNiveau(o.getString("niveau"));
                fil.setNbModule(o.getInt("nombreModule"));

                etablissement.getFilieres().add(fil);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return etablissement;
    }
}