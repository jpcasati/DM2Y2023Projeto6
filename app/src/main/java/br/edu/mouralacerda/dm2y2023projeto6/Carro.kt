package br.edu.mouralacerda.dm2y2023projeto6

import org.ksoap2.serialization.KvmSerializable
import org.ksoap2.serialization.PropertyInfo
import java.util.Hashtable

data class Carro (
    val placa: String,
    val marca: String,
    val modelo: String,
    val ano: Int
) : KvmSerializable {

    override fun getProperty(index: Int): Any {

        if(index == 0)
            return placa
        else if(index == 1)
            return marca
        else if(index == 2)
            return modelo
        else if(index == 3)
            return ano
        return "null"
    }

    override fun getPropertyCount(): Int {
        return 4
    }

    override fun getPropertyInfo(index: Int, properties: Hashtable<*, *>?, info: PropertyInfo?) {

        if (info == null)
            return

        when (index) {
            0 -> {
                info.type = PropertyInfo.STRING_CLASS
                info.name = "placa"
            }
            1 -> {
                info.type = PropertyInfo.STRING_CLASS
                info.name = "marca"
            }
            2 -> {
                info.type = PropertyInfo.STRING_CLASS
                info.name = "modelo"
            }
            3 -> {
                info.type = PropertyInfo.INTEGER_CLASS
                info.name = "ano"
            }
            else -> {}
        }
    }

    override fun setProperty(index: Int, value: Any?) {
        when (index) {
            0 -> value.toString()
            1 -> value.toString()
            2 -> value.toString()
            3 -> value
            else -> "null"
        }
    }

}