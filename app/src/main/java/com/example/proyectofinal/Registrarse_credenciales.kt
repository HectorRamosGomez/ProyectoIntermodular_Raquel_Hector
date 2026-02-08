package com.example.proyectofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import com.example.proyectofinal.databinding.ActivityRegistroCredencialesBinding

class Registrarse_credenciales: AppCompatActivity(), View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener{

    private lateinit var mBinding: ActivityRegistroCredencialesBinding

    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegistroCredencialesBinding.inflate(LayoutInflater.from(this))
        setContentView(R.layout.activity_registro_credenciales)
        mBinding.nombreCompleto.onFocusChangeListener = this
        mBinding.mail.onFocusChangeListener = this
        mBinding.password1.onFocusChangeListener = this
        mBinding.password2.onFocusChangeListener = this


    }


    // Función para poder validar el nombre y que no quede incompleto
    private fun validarNombre(): Boolean {
        var mensajeError: String? = null
        val valor: String = mBinding.nombreCompleto.text.toString()
        if(valor.isEmpty()){
            mensajeError = "Nombre incompleto"
        }

        if(mensajeError != null) {
            mBinding.layoutNombreCompleto.apply {

                isErrorEnabled = true
                error = mensajeError
            }
        }

        return mensajeError == null
    }

    //Función para comprobar el email
    private fun validarEmail(): Boolean {
        var mensajeError: String? = null
        val valor: String = mBinding.mail.text.toString()
        if(valor.isEmpty()){
            mensajeError = "Correo Incompleto"
        }else if(!Patterns.EMAIL_ADDRESS.matcher(valor).matches()) {
            mensajeError = "Correo no valido"
        }

        if(mensajeError != null) {
            mBinding.layoutCorreo.apply {

                isErrorEnabled = true
                error = mensajeError
            }
        }

        return mensajeError == null
    }


    private fun validarPassword(): Boolean {
        var mensajeError: String? = null
        val valor: String = mBinding.password1.text.toString()
        if(valor.isEmpty()){
            mensajeError = "La contraseña es necesaria"
        }else if(valor.length < 6) {
            mensajeError = "Necesitas minimo 6 caracteres"
        }

        if(mensajeError != null) {
            mBinding.layoutPassword.apply {

                isErrorEnabled = true
                error = mensajeError
            }
        }
        return mensajeError == null
    }

    private fun validarConfirmacionPassword(): Boolean {
        var mensajeError: String? = null
        val valor: String = mBinding.password2.text.toString()
        if(valor.isEmpty()){
            mensajeError = "La confirmación de contraseña es necesaria"
        }else if(valor.length < 6) {
            mensajeError = "La confirmación necesita minimo 6 caracteres"
        }

        if(mensajeError != null) {
            mBinding.layoutPasswordConfirmacion.apply {

                isErrorEnabled = true
                error = mensajeError
            }
        }
        return mensajeError == null
    }

    private fun validarConfirmacionPasswordConPassword(): Boolean {
        var mensajeError: String? = null
        val password: String = mBinding.password1.text.toString()
        val passwordConfirmada: String = mBinding.password2.text.toString()
        if(password != passwordConfirmada){
            mensajeError = "Las contraseñas no son iguales"
        }

        if(mensajeError != null) {
            mBinding.layoutPasswordConfirmacion.apply {

                isErrorEnabled = true
                error  = mensajeError
            }
        }

        return mensajeError == null
    }

    override fun onFocusChange(view: View?, hasFocus: Boolean) {
        if(view != null) {
            when(view.id) {
                R.id.nombreCompleto -> {
                    if(hasFocus) {
                        if(mBinding.layoutNombreCompleto.isErrorEnabled) {
                            mBinding.layoutNombreCompleto.isErrorEnabled = false
                        }
                    }else {
                        validarNombre()
                    }
                }
                R.id.mail -> {
                    if(hasFocus) {
                        if(mBinding.layoutCorreo.isErrorEnabled) {
                            mBinding.layoutCorreo.isErrorEnabled = false
                        }
                    }else {
                        validarEmail()
                    }
                }
                R.id.password1 -> {
                    if(hasFocus) {
                        if(mBinding.layoutPassword.isErrorEnabled) {
                            mBinding.layoutPassword.isErrorEnabled = false
                        }
                    }else {
                        if(validarPassword() && mBinding.password2.text!!.isNotEmpty() && validarConfirmacionPassword() && validarConfirmacionPasswordConPassword()){
                            if(mBinding.layoutPasswordConfirmacion.isErrorEnabled){
                                mBinding.layoutPasswordConfirmacion.isErrorEnabled = false
                            }
                            mBinding.layoutPasswordConfirmacion.setStartIconDrawable(R.drawable.baseline_check_circle_outline_24)
                        }
                    }
                }
                R.id.password2 -> {
                    if(hasFocus) {
                        if(mBinding.layoutPasswordConfirmacion.isErrorEnabled) {
                            mBinding.layoutPasswordConfirmacion.isErrorEnabled = false
                        }
                    }else {
                        if(validarConfirmacionPassword() && validarPassword() && validarConfirmacionPasswordConPassword()){
                            if(mBinding.layoutPasswordConfirmacion.isErrorEnabled){
                                mBinding.layoutPasswordConfirmacion.isErrorEnabled = false
                            }
                            mBinding.layoutPasswordConfirmacion.setStartIconDrawable(R.drawable.baseline_check_circle_outline_24)
                        }
                    }
                }
            }

        }
    }

    override fun onClick(view: View?) {

    }

    override fun onKey(view: View?, event: Int, keyEvent: KeyEvent?): Boolean {
        return false
    }
}