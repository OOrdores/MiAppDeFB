package ordores.dev.miappdefb;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;


public class MenuActivity extends Activity  {

    ImageButton concierto, teatro, entretenimiento ,deporte, conferencia, favorito;



    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_menu);
        concierto =(ImageButton)findViewById(R.id.concierto);
        concierto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, ConciertoActivity.class);
            }
        });

        teatro =(ImageButton)findViewById(R.id.teatro);
           teatro.setOnClickListener(new View.OnClickListener(){
               @Override
               public void onClick(View v) {
                   Intent i = new Intent(MenuActivity.this, TeatroActivity.class);
               }
           });

        entretenimiento =(ImageButton)findViewById(R.id.entretenimiento);
        entretenimiento.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, EntretenimientoActivity.class);


            }
        });



        deporte=(ImageButton)findViewById(R.id.deporte);

        deporte.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, DeporteActivity.class);
            }
        });

        conferencia=(ImageButton)findViewById(R.id.conferencia);

        conferencia.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MenuActivity.this, ConferenciaActivity.class);

            }
        });

        favorito=(ImageButton)findViewById(R.id.favoritos);


        favorito.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, FavoritoActivity.class);
            }
        });


    }

    public void seleccionar(ImageButton ib){
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }



    public void seleccion(ImageButton ib){
        switch (ib.getId()){
            case R.id.concierto:


                Intent i= new Intent(MenuActivity.this, ConciertoActivity.class);

                break;
            case R.id.teatro:
                Intent teatro = new Intent(MenuActivity.this, TeatroActivity.class);

                break;
            case R.id.entretenimiento:
                Intent entretenimiento = new Intent(MenuActivity.this, EntretenimientoActivity.class);

                break;
            case R.id.deporte:
                Intent deporte = new Intent(MenuActivity.this, DeporteActivity.class);

                break;
            case R.id.conferencia:
                Intent conferencia = new Intent(MenuActivity.this, ConferenciaActivity.class);

                break;
            case R.id.favoritos:
                Intent favorito = new Intent(MenuActivity.this, FavoritoActivity.class);

                break;
        }
    }


}
