/*package example.learning.kotlin.gabriel.zendone.Banco;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ResourceBundle;

import example.learning.kotlin.gabriel.zendone.Banco.bd;
import example.learning.kotlin.gabriel.zendone.R;

public class Controlador {
    private SQLiteDatabase db;
    private bd banco;

        public Controlador (Context context){
            banco = new bd (context);
        }
        public String insereDado (String title, String desc) {
            ContentValues valores;
            long resultado;

            db= banco.getWritableDatabase();
            valores = new ContentValues();
            valores.put(bd.getTitulo(), title);
            valores.put(bd.getDesc(),desc);
          //  valores.put(bd.isFavo(),favo);
            resultado = db.insert(bd.getTabela(), null, valores);
            db.close();

            if (resultado==-1)
                return "Erro ao inserir registro";
            else
                return "Sucesso";
        }
        public class insereDado extends Activity {
            @Override
            protected void onCreate (Bundle savedInstaceState ) {
                super.onCreate(savedInstaceState);
                setContentView ( R.layout.activity_inicial);
                Button botao = (Button)findViewById(R.id.button);
                botao.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick (View v){
                        Controlador crud = new Controlador (getBaseContext());
                        TextView TvTitle = (TextView) findViewById(R.id.tvTitle);
                        TextView TvDes = (TextView) findViewById((R.id.tvDes));
                        String tituloString = TvTitle.getText().toString();
                        String discString = TvDes.getText().toString();
                        resultado = crud.insereDado(tituloString,discString);

                    }
                });

            }
        }

}
*/