package br.com.usinasantafe.ppc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaMenuActivity extends Activity {

    private ListView lista;
    private PPCContext PPCContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_menu);

        PPCContext = (PPCContext) getApplication();

        Button buttonRetMenu = (Button) findViewById(R.id.buttonRetTipoApont);

        listarMenu();

        buttonRetMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ListaMenuActivity.this, ListaCabecalhoActivity.class);
                startActivity(it);
            }
        });

    }

    public void listarMenu(){

        ArrayList<String> itens = new ArrayList<String>();

        itens.add("MECANIZADA");
        itens.add("MANUAL");

        AdapterList adapterList = new AdapterList(this, itens);
        lista = (ListView) findViewById(R.id.listaMenu);
        lista.setAdapter(adapterList);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> l, View v, int position,
                                    long id) {
                // TODO Auto-generated method stub
                if(position == 0){
                    PPCContext.getCabecalhoVARTO().setTipo(1L);
                }
                else if(position == 1){
                    PPCContext.getCabecalhoVARTO().setTipo(2L);
                }

                Intent it = new Intent(ListaMenuActivity.this, Auditor1Activity.class);
                startActivity(it);

            }

        });

    }

}