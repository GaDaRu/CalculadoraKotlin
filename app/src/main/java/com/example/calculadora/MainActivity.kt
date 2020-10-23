package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this@MainActivity, "Selecciona Tipo de calculo", Toast.LENGTH_SHORT).show()
    }

    var memoria: String = "f";

    var contador: Int = 0;

    lateinit var valor1: String

    lateinit var valor2: String

    lateinit var operacion: String

    lateinit var resultado: String

    var binario: Boolean = false

    var decimal: Boolean = true

    var hexadecimal: Boolean = false

    var dHexa: kotlin.Long = 0

    fun pulsarBoton(v: View){
        val numero = findViewById<Button>(v.id)
        if(numero == button8){
            val numEscrito = textView.text.toString()
            textView.text = numEscrito + "8";
        }else if(numero == button9){
            val numEscrito = textView.text.toString()
            textView.text = numEscrito + "9"
        }else if(numero == button7){
            val numEscrito = textView.text.toString()
            textView.text = numEscrito + "7"
        }else if(numero == button4){
            val numEscrito = textView.text.toString()
            textView.text = numEscrito + "4"
        }else if(numero == button5){
            val numEscrito = textView.text.toString()
            textView.text = numEscrito + "5"
        }else if(numero == button6){
            val numEscrito = textView.text.toString()
            textView.text = numEscrito + "6"
        }else if(numero == button1){
            val numEscrito = textView.text.toString()
            textView.text = numEscrito + "1"
        }else if(numero == button2){
            val numEscrito = textView.text.toString()
            textView.text = numEscrito + "2"
        }else if(numero == button3){
            val numEscrito = textView.text.toString()
            textView.text = numEscrito + "3"
        }else if(numero == button0){
            val numEscrito = textView.text.toString()
            textView.text = numEscrito + "0"
        }else if(numero == buttonD){
            valor1 = textView.text.toString()
            operacion = "/"
            textView.text = ""
        }else if(numero == buttonM){
            valor1 = textView.text.toString()
            operacion = "*"
            textView.text = ""
        }else if(numero == buttonR){
            valor1 = textView.text.toString()
            operacion = "-"
            textView.text = ""
        }else if(numero == buttonS){
            valor1 = textView.text.toString()
            operacion = "+"
            textView.text = ""
        }else if(numero == buttonC){
            val numEscrito = textView.text.toString()
            val eliminado = numEscrito.substring(0, numEscrito.length - 1)
            textView.text = eliminado
        }else if(numero == buttonB){
            textView.text = ""
        }else if(numero == buttonG){
            if(contador % 2 == 0){
                Toast.makeText(this@MainActivity, "Numero Guardado", Toast.LENGTH_SHORT).show()
                memoria = textView.text.toString()
                contador++
            }else{
                //Toast.makeText(this@MainActivity, "p", Toast.LENGTH_SHORT).show()
                textView.text = memoria
                contador++
            }
        }else if(numero == buttonI){
            valor2 = textView.text.toString()

            if(binario){
                val dato3 = Integer.parseInt(valor1, 2)
                val dato4 = Integer.parseInt(valor2, 2)
                if(operacion.equals("/")){
                    if(dato3 <=0 || dato4 <= 0){
                        resultado = "Error"
                    }else{
                        val valor = dato3 / dato4
                        val numero = Integer.toBinaryString(valor)
                        resultado = numero.toString()
                    }
                }else if(operacion.equals("*")){
                    val valor = dato3 * dato4
                    val numero = Integer.toBinaryString(valor)
                    resultado = numero.toString()
                }else if(operacion.equals("+")){
                    val valor = dato3 + dato4
                    val numero = Integer.toBinaryString(valor)
                    resultado = numero.toString()
                }else if(operacion.equals("-")){
                    val valor = dato3 - dato4
                    val numero = Integer.toBinaryString(valor)
                    resultado = numero.toString()
                }
            }else if(decimal){
                val dato1 = valor1.toInt()
                val dato2 = valor2.toInt()

                if(operacion.equals("/")){
                    if(dato1 <=0 || dato2 <= 0){
                        resultado = "Error"
                    }else {
                        val valor = dato1 / dato2
                        resultado = valor.toString()
                    }
                }else if(operacion.equals("*")){
                    val valor = dato1 * dato2
                    resultado = valor.toString()
                }else if(operacion.equals("+")){
                    val valor = dato1 + dato2
                    resultado = valor.toString()
                }else if(operacion.equals("-")){
                    val valor = dato1 - dato2
                    resultado = valor.toString()
                }
            }else if(hexadecimal){
                val dato = hexadecimalADecimal(valor1) //valor1.toInt()
                val dato0 = hexadecimalADecimal(valor2) //valor2.toInt()

                //val dato5 = valor1.toInt()
                //val dato6 = valor2.toInt()

                val dato5 = dato.toInt()
                val dato6 = dato0.toInt()

                if (operacion.equals("/")) {
                    if(dato5 <=0 || dato6 <= 0){
                        resultado = "Error"
                    }else{
                        val valor = dato5 / dato6
                        val numero = Integer.toHexString(valor)
                        resultado = numero.toString()
                    }
                } else if (operacion.equals("*")) {
                    val valor = dato5 * dato6
                    val numero = Integer.toHexString(valor)
                    resultado = numero.toString()
                } else if (operacion.equals("+")) {
                    val valor = dato5 + dato6
                    val numero = Integer.toHexString(valor)
                    resultado = numero.toString()
                } else if (operacion.equals("-")) {
                    val valor = dato5 - dato6
                    val numero = Integer.toHexString(valor)
                    resultado = numero.toString()
                }
            }

            textView.text = resultado
        }else if(numero == buttonP){
            val numEscrito = textView.text.toString()
            textView.text = numEscrito + "."
        }else if(numero == buttonAH){
            val numEscrito = textView.text.toString()
            textView.text = numEscrito + "A"
        }else if(numero == buttonBH){
            val numEscrito = textView.text.toString()
            textView.text = numEscrito + "B"
        }else if(numero == buttonCH){
            val numEscrito = textView.text.toString()
            textView.text = numEscrito + "C"
        }else if(numero == buttonDH){
            val numEscrito = textView.text.toString()
            textView.text = numEscrito + "D"
        }else if(numero == buttonEH){
            val numEscrito = textView.text.toString()
            textView.text = numEscrito + "E"
        }else if(numero == buttonFH){
            val numEscrito = textView.text.toString()
            textView.text = numEscrito + "F"
        }else if(numero == buttonBi){
            escribirBinario()
        }else if(numero == buttonDe){
            escribirDecimal()
        }else if(numero == buttonHe){
            escribirHexadecimal()
        }
    }

    fun escribirBinario(){
        binario = true
        decimal = false
        hexadecimal = false
        textView.text = ""
        button2.isClickable = false
        button3.isClickable = false
        button4.isClickable = false
        button5.isClickable = false
        button6.isClickable = false
        button7.isClickable = false
        button8.isClickable = false
        button9.isClickable = false
        buttonAH.isClickable = false
        buttonBH.isClickable = false
        buttonCH.isClickable = false
        buttonDH.isClickable = false
        buttonEH.isClickable = false
        buttonFH.isClickable = false
    }

    fun escribirDecimal(){
        decimal = true
        binario = false
        hexadecimal = false
        textView.text = ""
        buttonAH.isClickable = false
        buttonBH.isClickable = false
        buttonCH.isClickable = false
        buttonDH.isClickable = false
        buttonEH.isClickable = false
        buttonFH.isClickable = false
        button2.isClickable = true
        button3.isClickable = true
        button4.isClickable = true
        button5.isClickable = true
        button6.isClickable = true
        button7.isClickable = true
        button8.isClickable = true
        button9.isClickable = true
    }

    fun escribirHexadecimal(){
        hexadecimal = true
        binario = false
        decimal = false
        textView.text = ""
        buttonAH.isClickable = true
        buttonBH.isClickable = true
        buttonCH.isClickable = true
        buttonDH.isClickable = true
        buttonEH.isClickable = true
        buttonFH.isClickable = true
        button2.isClickable = true
        button3.isClickable = true
        button4.isClickable = true
        button5.isClickable = true
        button6.isClickable = true
        button7.isClickable = true
        button8.isClickable = true
        button9.isClickable = true
    }

    fun caracterHexadecimalADecimal(caracter: Char): Int {
        return when (caracter) {
            'A' -> 10
            'B' -> 11
            'C' -> 12
            'D' -> 13
            'E' -> 14
            'F' -> 15
            else -> caracter.toString().toInt()
        }
    }

    fun hexadecimalADecimal(hexadecimal: String): Long {
        var decimal: Long = 0
        // Saber en cuál posición de la cadena (de izquierda a derecha) vamos
        var potencia = 0
        // Recorrer la cadena de derecha a izquierda
        for (x in hexadecimal.length - 1 downTo 0) {
            val valor = caracterHexadecimalADecimal(hexadecimal[x])
            val elevado = Math.pow(16.0, potencia.toDouble()).toLong() * valor
            decimal += elevado
            // Avanzar en la potencia
            potencia++
        }
        return decimal
    }
}