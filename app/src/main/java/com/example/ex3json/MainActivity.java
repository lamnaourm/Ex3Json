package com.example.ex3json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

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

        t1 = findViewById(R.id.nomEtablissement);
        t2 = findViewById(R.id.adresseEtablissement);
        ls = findViewById(R.id.lstFils);

        t1.setText(etablissement.getNom());
        t2.setText(etablissement.getAdresse());

        ArrayList<String> fils = new ArrayList<>();
        for(Filiere f : etablissement.getFilieres())
            fils.add(f.getNom() + " - " + f.getNomComplet() + " - " + f.getNiveau());

        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1,fils);
        ls.setAdapter(ad);

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
        Etablissement etablissement=new Etablissement();
        try {
            JSONObject obj = new JSONObject(json);

            etablissement.setNom(obj.getString("nom"));
            etablissement.setAdresse(obj.getString("adresse"));
            JSONArray array = obj.getJSONArray("filiere");

            for(int i=0;i<array.length();i++){
                JSONObject o = array.getJSONObject(i);
                Filiere fil = new Filiere();

                fil.setNom(o.getString("nom"));
                fil.setNomComplet(o.getString("nomcomplet"));
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