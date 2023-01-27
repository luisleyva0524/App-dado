package com.example.diceroll

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/* Esta actividad permite al usuario tirar un dado y ver el resultado.
en la pantalla.
*/
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // creamos la variable rollButton para encontrar el botton y posteriormente poder usarlo
        val rollButton: Button = findViewById(R.id.button)
        // Llamamos al button para que este en escucha
        rollButton.setOnClickListener { roolDice() }
        // Inicia un numero random al inciar la aplicacion para dar un efecto interactivo.
        roolDice()
    }

    // Funcion que permite crear un numero random y tira los dados y actualiza la pantalla con el resultado.
    private fun roolDice() {
        // Crea un nuevo objeto Dice con 6 lados y tira los dados
        val dice = Dice(6)
        // Guardamos el valor de
        val diceRoll = dice.roll()
        // Creamos la variable diceImage para almacenar el ImageView que queremos mostrar en pantalla al usuario
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Asignamos valor en la variable drawableResource obteniendo el id en base la condicion cumplida.
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Asignamos el recurso obtenido de la variable drawableResource que deseamos mostrar en pantalla
        diceImage.setImageResource(drawableResource)
        // Agregamos una descripcion a la imagen para que sea accesible por el uso mediante voz.
        diceImage.contentDescription = diceRoll.toString()
    }
}

// Clase que recibe el numero de caras del dado y contiene el metodo roll que genera un numero random a partir del numero de sides asignadas en el parametro de la clase.
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
