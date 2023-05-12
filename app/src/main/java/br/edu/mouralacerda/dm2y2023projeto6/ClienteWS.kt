package br.edu.mouralacerda.dm2y2023projeto6

import android.os.StrictMode
import org.ksoap2.SoapEnvelope
import org.ksoap2.serialization.SoapObject
import org.ksoap2.serialization.SoapSerializationEnvelope
import org.ksoap2.transport.HttpTransportSE
import org.xmlpull.v1.XmlPullParserException
import java.io.IOException

class ClienteWS {

    @Throws(IOException::class, XmlPullParserException::class)
    fun enviarCarro(c: Carro?) {

        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())

        val soap = SoapObject("http://servicosparaapp.mycompany.com/", "recebercarro")
        soap.addProperty("carro", c)

        val envelope = SoapSerializationEnvelope(SoapEnvelope.VER10)

        envelope.setOutputSoapObject(soap)

        HttpTransportSE("http://10.0.2.2:8080/ServicosParaApp/ServicosApp?wsdl").call("recebercarro", envelope)

    }


    @Throws(IOException::class, XmlPullParserException::class)
    fun receberSaudacao(nomeDigitado: String?): String? {

        // Política criada para não haver necessidade de chamada assíncrona
        val policy =
            StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)


        val soap = SoapObject(
            "http://servicosparaapp.mycompany.com/",
            "saudacao"
        )
        //SOAP OBJECT
        // namespace é o que está no targetnamespace do WSDL
        // name é o nome da operação (método) que irá executar

        // Parâmetros que o webservice recebe
        soap.addProperty("nome", nomeDigitado)

        // Usado 1.1 (VER11) no Glassfish
        // Tomcat - VER10
        val envelope = SoapSerializationEnvelope(SoapEnvelope.VER10)

        envelope.setOutputSoapObject(soap)

        val transmitir = HttpTransportSE(
            "http://10.0.2.2:8080/ServicosParaApp/ServicosApp?wsdl"
        )

        transmitir.call("saudacao", envelope)

        // Pego o resultado da execução do webservice
        val resultado = envelope.response

        return resultado.toString()
    }
}