package informatico.to.checkboxcalcular;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //variables
    //variable de edittext
    EditText num1, num2;
    //Ckeckbox
    CheckBox checksuma, checkresta;
    //txtview donde se mostrara los resultados
    TextView textresultado;
    //boton calcular para la operacion
    Button btncalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //habilitamos para que se pueda visualizar el action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //Indicamos donde esta la imagen para el action bar
        getSupportActionBar().setIcon(R.drawable.ic_action_name);
        //instanciamos las variables con sus respectivos id de los controles de la vista
        num1 = (EditText) findViewById(R.id.etvalor1);
        num2 = (EditText) findViewById(R.id.etvalor2);
        checksuma = (CheckBox) findViewById(R.id.checkBoxsuma);
        checkresta = (CheckBox) findViewById(R.id.checkBoxresta);
        textresultado = (TextView) findViewById(R.id.tvresultado);
        btncalcular=(Button)findViewById(R.id.btncalcular);
        //Llamamos al metodo Onclistener y le decimos que escuche con el onclick
        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creamos las variables estrins y convertimos a cadena los datos
                String valor1 = num1.getText().toString();
                String valor2 = num2.getText().toString();
                //creamos variables enteros y parseamos los string para que se convirta a string
                int nume1 = Integer.parseInt(valor1);
                int nume2 = Integer.parseInt(valor2);
                //Condicional para que si no se ingreso ningun dato el sistema no se caiga
                if(valor1.isEmpty()&&valor2.isEmpty()&&checksuma.isChecked()!=true&&checkresta.isChecked()!=true){
                    Toast noti=Toast.makeText (getApplicationContext(),"Ingrese datos númericos y Seleccione una operación",Toast.LENGTH_LONG);
                    noti.show();
                }
                /*Condicional si tengo valores en los edittext y no tengo
                ninguna opcion de operacion seleccionado que lanze un toast
                 */
                if(!valor1.isEmpty()&& !valor2.isEmpty()&& !checksuma.isChecked() && checkresta.isChecked() != true){
                    Toast noti=Toast.makeText (getApplicationContext(),"Selecciona una operación",Toast.LENGTH_LONG);
                    noti.show();
                }
                //preguntamos si checksuma esta seleccionado
                if (checksuma.isChecked() == true) {
                        int suma = nume1 + nume2;
                        String res = String.valueOf(suma);
                        textresultado.setText("La suma es: " + res);
                }
                //preguntamos si checkresta esta seleccionado
                if (checkresta.isChecked() == true) {
                    int res = nume1 - nume2;
                    String resu = String.valueOf(res);
                    textresultado.setText("La resta es: " + resu);
                }
                //preguntamos si checksuma y checkresta esta seleccionado
                if(checksuma.isChecked()==true&&checkresta.isChecked() == true){
                    textresultado.setText("Selecciona una operación");
                    Toast noti=Toast.makeText (getApplicationContext(),"Selecciona solo una operación",Toast.LENGTH_LONG);
                    noti.show();
                } }
        });    }}