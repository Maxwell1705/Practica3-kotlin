package com.example.practica3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

// Declarar las variables
private lateinit var btnSumar: Button;
private lateinit var btnRestar: Button;
private lateinit var btnMultiplicar: Button;
private lateinit var btnDividir: Button;
private lateinit var btnLimpiar: Button;
private lateinit var btnRegresar: Button;
private lateinit var lblUsuario: TextView;
private lateinit var lblResultado: TextView;
private lateinit var txtUno: EditText;
private lateinit var txtDos: EditText;

// Declarar el objeto Calculadora
private var calculadora = Calculadora(0, 0);

class CalculadoraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)
        iniciarComponentes();

        // Obtener los datos del mainActivity
        var datos = intent.extras;
        var usuario = datos!!.getString("usuario");
        lblUsuario.text = usuario.toString();

        btnSumar.setOnClickListener { btnSumar() }
        btnRestar.setOnClickListener { btnRestar() }
        btnMultiplicar.setOnClickListener { btnMultiplicar() }
        btnDividir.setOnClickListener { btnDividir() }

        btnLimpiar.setOnClickListener { btnLimpiar() }
        btnRegresar.setOnClickListener { btnRegresar() }
    }

    private fun iniciarComponentes() {
        // Botones
        btnSumar = findViewById(R.id.btnSumar);
        btnRestar = findViewById(R.id.btnRestar);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnRegresar = findViewById(R.id.btnRegresar);

        // Etiquetas
        lblUsuario = findViewById(R.id.lblUsuario);
        lblResultado = findViewById(R.id.lblResultado);

        // Cajas de Texto
        txtUno = findViewById(R.id.txtNum1);
        txtDos = findViewById(R.id.txtNum2);
    }

    fun btnSumar() {
        calculadora.num1 = txtUno.text.toString().toInt();
        calculadora.num2 = txtDos.text.toString().toInt();
        var total = calculadora.suma();
        lblResultado.text = total.toString();
    }

    fun btnRestar() {
        calculadora.num1 = txtUno.text.toString().toInt();
        calculadora.num2 = txtDos.text.toString().toInt();
        var total = calculadora.resta();
        lblResultado.text = total.toString();
    }

    fun btnMultiplicar() {
        calculadora.num1 = txtUno.text.toString().toInt();
        calculadora.num2 = txtDos.text.toString().toInt();
        var total = calculadora.multiplicacion();
        lblResultado.text = total.toString();
    }

    fun btnDividir() {
        calculadora.num1 = txtUno.text.toString().toInt();
        calculadora.num2 = txtDos.text.toString().toInt();
        var total = calculadora.division();
        lblResultado.text = total.toString();
    }

    fun btnLimpiar() {
        lblResultado.text = "";
        txtDos.text.clear();
        txtUno.text.clear();
    }

    fun btnRegresar() {
        var confirmar = AlertDialog.Builder(this);
        confirmar.setTitle("Calculadora");
        confirmar.setMessage("Regresar al MainActivity");
        confirmar.setPositiveButton("Confirmar"){dialogInterface,which->finish()}
        confirmar.setNegativeButton("Cancelar"){dialogInterface,which->}
        confirmar.show();
    }
}